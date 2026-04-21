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
          data = json.dumps(result)
          ptr = ctypes.addressof(ctypes.c_char.from_buffer(mm))
          ctypes.memmove(ptr, data, len(data))
          mm.close()
    return json.dumps(result)

@app.route("/hmd", methods=["POST"])
def store_hmd_data():
     return {"status": "success", "message": "Data received"}

@app.route("/request", methods=["GET"])
def request_hmd_data():
     client_ip = request.remote_addr

if __name__ == '__main__':
     app.run()