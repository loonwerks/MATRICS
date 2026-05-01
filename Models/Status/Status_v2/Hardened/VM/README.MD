# Setting Up Virtual Machines on sel4 Microkit

To setup a guest VM on seL4 Microkit, the following are required:

- Kernel Image
- Device Tree Blob (.dtb)
- Initial Ram Disk (rootfs.cpio.gz)

To begin, run the `run_docker.sh` script. This will open a docker container in interactive mode with 
this directory mounted to `/home/linux`. (The docker container will take a few minutes to build.)

## Kernel Images

We must compile a linux kernel image from source for each platform.

### qemu_virt_aarch64 
1. Locate to linux kernel source directory

          cd /home/linux-src

2. There are two options to configure the kernel:

     <u>Option 1:</u> Make Custom .config:

     a. Set default .config:

          make ARCH=arm64 CROSS_COMPILE=aarch64-none-elf- virt.config

     b. Edit .config through the menu:

          make ARCH=arm64 CROSS_COMPILE=aarch64-none-elf- menuconfig

     <u>Option 2:</u> Utilize already created .config:
     
          cp ../linux/QEMU-VM/.linuxconfig .config

3. Compile Kernel:

          make ARCH=arm64 CROSS_COMPILE=aarch64-none-elf- Image -j$(nproc)
          cp arch/arm64/boot/Image ../linux/QEMU-VM/linux

## Device Tree Blob (.dtb)

We must create two device tree sources (which will later be compiled to a .dtb during the build process of
our seL4 application): overlay.dts and linux.dts. These will be different for each platform.

### qemu_virt_aarch64

Already provided in QEMU-VM/overlay.dts and QEMU-VM/linux.dts

### Raspberry Pi 4B

There are two options to configure the device tree sources:

<u>Option 1:</u> Make Custom .dts:

Full Device Tree Blob available here: https://github.com/raspberrypi/firmware/blob/master/boot/bcm2711-rpi-4-b.dtb

<u>Option 2:</u> Utilize already created .dts:
   
- Already provided in QEMU-VM/overlay.dts and QEMU-VM/linux.dts

## Intial Ram Disk (rootfs.cpio.gz)

We must create and compress an initial root file system.

### qemu_virt_aarch64
1. Locate to the buildroot directory

          cd /home/buildroot

2. There are two options to configure the root file system:

     <u>Option 1:</u> Make Custom .config:

     a. Set default .config:

          make qemu_aarch64_virt_defconfig

     b. Edit .config through the menu:

          make menuconfig

     **NOTE:** You will have to navigate to the `Filesystem images` menu and select `cpio the root filesystem (for use as an initial RAM filesystem)` and `Compression method` -> `(gzip)`.

     **NOTE:** You will have to naviate to the `Toolchain` >> `C Library` and select the `glibc` option.

     **NOTE:** You will want to deselect `Kernel` >> `Linux Kernel` so Buildroot doesn't compile a linux kernel (because we already did that above).

     **NOTE:** For nginx webserver, enable `Target Packages` >> `Networking applications` >> `nginx` and enable the following modules:

     - `ngx_http_ssl_module`
     - `ngx_http_proxy_module`

     **NOTE:** For Flask Python Webserver, enable `Target Packages` >> `Interpreter languages and scripting` >> `python3` and enable the following modules:

     - `python-flask`
     - `python-flask-expects-json`
     - `python-gunicorn`
     - 
     **NOTE:** For creating SSL certificates with OpenSSL, enable `Target Packages` >> `Libraries` >> `Crypto` and enable the following:

     - `openssl binary`



     <u>Option 2:</u> Utilize already created .config:
     
          cp ../linux/QEMU-VM/.buildrootconfig .config

3. Make root filesystem:

          make
          cp output/images/rootfs.cpio.gz ../linux/QEMU-VM/

**NOTE:** This will take a while to build.

### Editing Initial Ram Disk for Booting

1. Decompress the rootfs.cpio.gz
   
          gzip -d rootfs.cpio.gz
          mkdir rootfs
          cd rootfs
          cpio -idmv < ../rootfs.cpio

2. Make changes to startup scripts by adding required scripts to /etc/init.d/
   
**NOTE:** `etc/network/interfaces` should not include `eth0`

1. Recompress the rootfs (from `rootfs/` directory)

          rm -rf ../rootfs.cpio
          find . -print0 | cpio --null -o -H newc > ../rootfs.cpio
          cd ../
          gzip rootfs.cpio

