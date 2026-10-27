from flask import Flask, request
from enum import Enum
import mmap
import ctypes
import json
import time

# Create the application instance
app = Flask(__name__)

# Define Status Enum
class Status(Enum):
     SUCCESS = 1
     BUSY = 2
     EMPTY = 3
     FAILURE = 4

def write_rx_buffer(msg):
     memory_addr = 0x50000000
     memory_size = 0x2000
     status = Status.SUCCESS
     with open("/dev/mem", "r+b") as f:
          mm = mmap.mmap(f.fileno(), memory_size, offset=memory_addr, flags = mmap.MAP_SHARED | mmap.MAP_POPULATE)
          try:
               pad_len = (4 - (len(msg) % 4))
               data = json.dumps(msg).encode('utf-8') + (b"\x00" * pad_len) # manually add null terminated bytes to make multiple of 4
               if len(data) >= memory_size:
                    status = Status.FAILURE
               ptr = ctypes.addressof(ctypes.c_char.from_buffer(mm))
               flag =  ctypes.cast(ptr, ctypes.POINTER(ctypes.c_uint32)).contents.value
               if flag != 0x1:
                    ctypes.cast(ptr, ctypes.POINTER(ctypes.c_uint32)).contents.value = 0x1 # set RX buffer full flag
                    # Iteratively write the payload as 32-bit words starting at index 1 (offset 0x04)
                    for i in range(0, len(data), 4):
                         word = int.from_bytes(data[i:i+4], byteorder='little')
                         ctypes.cast(ptr + 0x04 + i, ctypes.POINTER(ctypes.c_uint32)).contents.value = word
               else:
                    status = Status.EMPTY
          except Exception as e:
               status = Status.FAILURE
          finally:
               mm.close()
     return status

def read_tx_buffer(client):
     memory_addr = 0x50002000
     memory_size = 0x2000
     status = Status.SUCCESS
     msg = ""
     with open("/dev/mem", "r+b") as f:
          mm = mmap.mmap(f.fileno(), memory_size, offset=memory_addr, flags = mmap.MAP_SHARED | mmap.MAP_POPULATE)
          try:
               ptr = ctypes.addressof(ctypes.c_char.from_buffer(mm))
               flag =  ctypes.cast(ptr, ctypes.POINTER(ctypes.c_uint32)).contents.value
               if flag != 0x0:

                    end_of_data = mm.find(b"\x00", 0x04)
                    if end_of_data != -1 and end_of_data < memory_size:
                         null_terminated_bytes = mm[0x04:end_of_data]
                         try:
                              data = null_terminated_bytes.decode('utf-8')
                              parsed_data = json.loads(data)
                              ip_addr = f"""{(parsed_data["client"] >> 24) & 0xFF}.{(parsed_data["client"] >> 16) & 0xFF}.{(parsed_data["client"] >> 8) & 0xFF}.{parsed_data["client"] & 0xFF}"""
                              if ip_addr == client: # The data in the TX Buffer is for this current client
                                   msg = parsed_data["body"]
                                   ctypes.cast(ptr, ctypes.POINTER(ctypes.c_uint32)).contents.value = 0x0 # reset TX buffer full flag
                              else: # Something is in the TX Buffer but its not for this current client
                                   status = Status.EMPTY
                         except Exception as e:
                              status = Status.FAILURE
                    else:
                         status = Status.FAILURE
               else:
                    status = Status.EMPTY
          except Exception as e:
               status = Status.FAILURE
          finally:
               mm.close()
     return (msg, status)

@app.before_request
def block_duplicate_args():
    for key, values in request.args.lists():
        if len(values) > 1: # Ensure there is only one of each argument
            return {"status": "error", "message": f"There is more than one {key} argument."}


# Define a route for the homepage
@app.route("/")
def hello_world():
#     text = f"<p>Headers: {dict(request.headers)}</p>"
#     text += f"<p>Args: {request.args.to_dict()}</p>"
#     text += f"<p>Form: {request.form.to_dict()}</p>"
#     text += f"<p>JSON: {request.get_json(silent=True)}</p>"
#     text += f"<p>Body: {request.get_data()}</p>"

    headers = dict(request.headers)
    body = request.get_data().decode('utf-8')
    result = {"headers": headers,
               "body": body}
    memory_addr = 0x50000000
    memory_size = 0x1000
    with open("/dev/mem", "r+b") as f:
          mm = mmap.mmap(f.fileno(), memory_size, offset=memory_addr, flags = mmap.MAP_SHARED | mmap.MAP_POPULATE)
          data = json.dumps(result).encode('utf-8')
          ptr = ctypes.addressof(ctypes.c_char.from_buffer(mm))
          flag =  ctypes.cast(ptr, ctypes.POINTER(ctypes.c_uint32)).contents.value
          if flag != 0x1:
               ctypes.cast(ptr, ctypes.POINTER(ctypes.c_uint32)).contents.value = 0x1 # set RX buffer ready flag
               ctypes.memmove(ptr+0x04, data + b"\x00", len(data)+1) # manually add null terminated byte
          mm.close()

    return json.dumps(result)

@app.route("/hmd", methods=["POST"])
def store_hmd_data():
     headers = {
               'Host': f"{request.host}{request.headers.get('X-Original-URI')}",
               'X-Forwarded-For': request.headers.get('X-Forwarded-For')
          }
     body = request.get_data().decode('utf-8')
     result = {"headers": headers,
               "body": body}
     if write_rx_buffer(result) == Status.SUCCESS:
          return {"status": "success", "message": "Data received"}
     else:
          return {"status": "failure", "message": "Data received but failure occurred"}

@app.route("/request", methods=["GET"])
def request_hmd_data():
     if request.get_data():
          return {"status": "error", "message": "Requests must not contain a body."}

     ALLOWED_PARAMS = {
          'analysisType': str,
          'guardID': int,
          'startTime': int,
          'endTime': int,
          'targetID': int
     }

     received_keys = set(request.args.keys())
     allowed_keys = set(ALLOWED_PARAMS.keys())
     unknown_keys = received_keys - allowed_keys
     if unknown_keys:
          return {"status": "error", "message": f"Invalid query parameter(s): {list(unknown_keys)}"}

     if 'analysisType' in request.args:
          val = request.args.get('analysisType')
          if val not in {'All_Records', 'Threat_Only', 'Safe_Only', 'Unreviewed_Only', 'Target_History'}:
               return {"status": "error", "message": "analysisType must be All_Records, Threat_Only, Safe_Only, Unreviewed_Only, or Target_History"}
          if val == 'Target_History':
               if 'targetID' in request.args:
                    val_target = request.args.get('targetID')
                    if not val_target.isdigit():
                         return {"status": "error", "message": "targetID must be a valid ID number."}
               else: 
                    return {"status": "error", "message": "No targetID indicated."}
          else:
               if 'targetID' in request.args:
                    return {"status": "error", "message": f"targetID is not allowed for analysisType {val}"}
     else:
          return {"status": "error", "message": "No analysisType indicated."}

     if 'guardID' in request.args:
          val = request.args.get('guardID')
          if not val.isdigit():
               return {"status": "error", "message": "guardID must be a valid ID number."}
     else:
          return {"status": "error", "message": "No guardID indicated."}

     if 'startTime' in request.args:
          val = request.args.get('startTime')
          if not val.isdigit():
               return {"status": "error", "message": "startTime must be a valid timestamp."}
     else:
          return {"status": "error", "message": "No startTime indicated."}

     if 'endTime' in request.args:
          val = request.args.get('endTime')
          if not val.isdigit():
               return {"status": "error", "message": "endTime must be a valid timestamp."}

     headers = {
          'Host': f"{request.host}{request.headers.get('X-Original-URI')}",
          'X-Forwarded-For': request.headers.get('X-Forwarded-For')
     }
     
     result = {"headers": headers}
     if write_rx_buffer(result) == Status.SUCCESS:
          deadline = time.monotonic() + 2.0 # Deadline is 2 seconds
          while time.monotonic() < deadline:
               (data, status) = read_tx_buffer(request.access_route[0])
               if status == Status.SUCCESS:
                    return data, 200
               elif status == Status.FAILURE:
                    return {"status": "failure"}, 500
               time.sleep(0.01)
          return {"status": "timeout"}, 504
     else:
          return {"status": "failure"}

if __name__ == '__main__':
     app.run()