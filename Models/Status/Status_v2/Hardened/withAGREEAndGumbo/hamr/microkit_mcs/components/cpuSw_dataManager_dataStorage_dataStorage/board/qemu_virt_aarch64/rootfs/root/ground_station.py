from pathlib import Path
import mmap
import ctypes
import time

usb_path = Path("/dev/sda")

def main():
     i = 0
     while True:
          if usb_path.exists():
               files = [str(file) for file in usb_path.rglob("*") if file.is_file()]
     
               print(f"Found {len(files)} files on the USB drive:")
               for file in files:
                    print(file)
               time.sleep(2)
               file_name = f"temp_{i}.txt"
               with open(file_name, "w") as file:
                    file.write("This is the first line of content.\n")
                    file.write("This is the second line.")
               print(f"Successfully saved {file_name}")

if __name__ == "__main__":
    main()