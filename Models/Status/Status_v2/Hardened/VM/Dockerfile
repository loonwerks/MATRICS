FROM ubuntu:24.04

# Architecture to build for
ARG TARGETPLATFORM

# Install 32bit variant on x86_64 image.
RUN if [ "$TARGETPLATFORM" = "linux/amd64" ]; then \
    dpkg --add-architecture i386; \
fi

# The container has no package lists, so need to update first
RUN apt-get update -y

RUN if [ "$TARGETPLATFORM" = "linux/amd64" ]; then \
    apt-get install -y --no-install-recommends \
        g++-multilib \
        libc6:i386; \
fi

# Fetch some basics
RUN apt-get update -q \
    && apt-get install -y --no-install-recommends \
        bc \
        bison \ 
        build-essential \
        bzr \
        ca-certificates \
        cmake \
        cpio \
        curl \
        cvs \
        file \
        flake8 \
        flex \
        g++ \
        git \
        kmod \
        libncurses5-dev \
        libssl-dev \
        locales \
        mercurial \
        openssh-server \
        python3 \
        python3-flake8 \
        python3-magic \
        python3-nose2 \
        python3-pexpect \
        python3-pytest \
        qemu-system-arm \
        qemu-system-misc \
        qemu-system-x86 \
        rsync \
        shellcheck \
        subversion \
        unzip \
        wget \
        && apt-get -y autoremove && \
        apt-get -y clean

# To be able to generate a toolchain with locales, enable one UTF-8 locale
RUN sed -i 's/# \(en_US.UTF-8\)/\1/' /etc/locale.gen && \
    /usr/sbin/locale-gen
        
ENV KERNEL=kernel8
ENV LC_ALL=en_US.UTF-8

WORKDIR /home

RUN git clone --depth=1 --branch rpi-6.12.y https://github.com/raspberrypi/linux.git /home/rpi-linux-src

RUN git clone --depth=1 --branch v6.13 https://github.com/torvalds/linux.git /home/linux-src

RUN git clone --depth=1 --branch 2024.11 https://github.com/buildroot/buildroot.git /home/buildroot

RUN mkdir -p /opt/arm

RUN wget -qO - https://developer.arm.com/-/media/Files/downloads/gnu/15.2.rel1/binrel/arm-gnu-toolchain-15.2.rel1-x86_64-aarch64-none-elf.tar.xz | tar xJf - -C /opt/arm
ENV PATH=$PATH:/opt/arm/arm-gnu-toolchain-15.2.rel1-x86_64-aarch64-none-elf/bin

CMD ["/bin/bash"]
