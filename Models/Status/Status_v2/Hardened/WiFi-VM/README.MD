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

### Raspberry Pi 4B
1. Locate to linux kernel source directory

          cd /home/rpi-linux-src

2. There are two options to configure the kernel:

     <u>Option 1:</u> Make Custom .config:

     a. Set default .config:

          make ARCH=arm64 CROSS_COMPILE=aarch64-none-elf- bcm2711_defconfig

     b. Edit .config through the menu:

          make ARCH=arm64 CROSS_COMPILE=aarch64-none-elf- menuconfig

     **NOTE:** Disable `Virtualization` to remove interrupt error.

     **NOTE:** To ensure WiFi driver is built-in, enable the following in `Networking support`:
     
     - `RF switch subsystem support`
       - `GPIO RFKILL driver`
     - `Wireless`
       - `cfg80211 - wireless configuration API`
       - `Generic IEEE 802.11 Networking Stack (mac80211)`
  
     and enable the following in `Device Drivers` >> `Network Device Support` >> `Wireless LAN`:

     - `Broadcom 43xx wireless support (mac80211 stack)`
       - `Broadcom 43xx SDIO device support`
       - `Support for N-PHY (the main 802.11n series) devices`
       - `Broadcom 43xx debugging`
       - `Broadcom 43xx-legacy wireless support (mac80211 stack)`
     - `Broadcom FullMAC WLAN driver`

     <u>Option 2:</u> Utilize already created .config:
     
          cp ../linux/RPI4B-VM/.linuxconfig .config

3. Compile Kernel:

          make ARCH=arm64 CROSS_COMPILE=aarch64-none-elf- Image -j$(nproc)
          cp arch/arm64/boot/Image ../linux/RPI4B-VM/linux

## Device Tree Blob (.dtb)

We must create two device tree sources (which will later be compiled to a .dtb during the build process of
our seL4 application): overlay.dts and linux.dts. These will be different for each platform.

### qemu_virt_aarch64

Already provided in QEMU-VM/overlay.dts and QEMU-VM/linux.dts

### Raspberry Pi 4B

There are two options to configure the device tree sources:

<u>Option 1:</u> Make Custom .dts:

Full Device Tree Blob available here: https://github.com/raspberrypi/firmware/blob/master/boot/bcm2711-rpi-4-b.dtb

- To de-compile Device Tree Blob (.dtb) to Device Tree Souce (.dts):
  
          dtc -I dtb -O dts <input_file.dtb> -o <output_file.dts>

- To compile Device Tree Souce (.dts) to Device Tree Blob (.dtb):

          dtc -I dts -O dtb <input_file.dts> -o <output_file.dtb>

<u>Option 2:</u> Utilize already created .dts:
   
- Already provided in RPI4B-VM/overlay.dts and RPI4B-VM/linux.dts

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

### Raspberry Pi 4B
1. Locate to the buildroot directory

          cd /home/buildroot

2. There are two options to configure the root file system:

     <u>Option 1:</u> Make Custom .config:

     a. Set default .config:

          make raspberrypi4_64_defconfig

     b. Edit .config through the menu:

          make menuconfig

     **NOTE:** You will have to navigate to the `Filesystem images` menu and select `cpio the root filesystem (for use as an initial RAM filesystem)` and `Compression method` -> `(gzip)`.

     **NOTE:** You will have to naviate to the `Toolchain` >> `C Library` and select the `glibc` option.

     **NOTE:** You will want to deselect `Kernel` >> `Linux Kernel` so Buildroot doesn't compile a linux kernel (because we already did that above).

     **NOTE:** To connect to WiFi, select the following:
     
     - `System Configuration` >> `/dev managment` >> `Dynamic using devtempfs + eudev)`
     - `Target Packages` >> `Networking Applications` >> `network-manager` >> `nmcli support`

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

     **NOTE:** To enable WiFi, enable the following in `Target Packages`:
     
     - `Hardware Handling` >> `Firmware`
       - `brcmfmac-sdio-firmware-rpi`
       - `brcmfmac-sdio-firmware-rpi-wifi`
     - `Networking Applications`
       - `iw`
       - `wireless-regdb`
       - `wpa_supplicant`
         - `Install wpa_cli binary`
         - `Install wpa_passphrase binary`
         - `Enable the Unix-socket control interface`

     **NOTE:** To disable ethernet and enable WiFi on bootup, go to `System Configuration` >> `Network interface to configure through DHCP` and change text to `wlan0`.

     **NOTE:** To enable console, go to `System Configuration` >> `Run a getty (login prompt) after boot` and change to `(ttyS0) TTY port`.

     <u>Option 2:</u> Utilize already created .config:
     
          cp ../linux/RPI4B-VM/.buildrootconfig .config

3. Make root filesystem:

          make
          cp output/images/rootfs.cpio.gz ../linux/RPI4B-VM/

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

