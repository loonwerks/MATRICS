import os

key = os.urandom(16) # 128 bits = 16 bytes
iv = os.urandom(12) # 96 bits = 12 bytes

print(f"Generated Key: {key.hex()}")
print(f"Generate Initialization Vector: {iv.hex()}")