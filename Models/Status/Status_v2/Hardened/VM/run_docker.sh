#! /bin/bash

# docker build --platform linux/amd64 --no-cache -t linux-build-kernel:latest .

docker run --platform linux/amd64 -it \
    -v ./:/home/linux/ \
    linux-build-kernel:latest /bin/bash