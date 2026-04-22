from flask import Flask, request
import mmap
import ctypes
import json

# Create the application instance
app = Flask(__name__)

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
    headers = dict(request.headers)
    body = request.get_data().decode('utf-8')
    result = {"headers": headers,
               "body": body}
     # return {"status": "success", "message": "Data received"}
    return json.dumps(result)

@app.route("/request", methods=["GET"])
def request_hmd_data():
     client_ip = request.remote_addr

if __name__ == '__main__':
     app.run()