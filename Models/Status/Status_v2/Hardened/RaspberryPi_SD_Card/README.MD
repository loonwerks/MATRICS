# Setting Up SD Card for Raspberry Pi 4B

Reference: https://docs.sel4.systems/Hardware/Rpi4.html

## Formating SD Card

1. Download the Raspberry Pi Imager
2. Navigate to OS
3. Select Erase

## Build U-Boot
Run the following:
```
     git clone https://github.com/u-boot/u-boot.git u-boot
     cd u-boot
     make CROSS_COMPILE=aarch64-linux-gnu- rpi_4_defconfig
     make CROSS_COMPILE=aarch64-linux-gnu-
```

## Generate boot script
1. Create a boot script like `boot.cmd`
2. Run `./boot.sh` to generate `boot.scr`

## Copying files
1. Copy `u-boot.bin` and `boot.scr` from above to SD card
2. Copy `config.txt` from this directory to SD card
3. Copy `start4.elf`, `fixup4.dat`, `bcm2711-rpi4-b.dtb`, and `overlays/*` from https://github.com/raspberrypi/firmware/tree/master/boot to SD card
4. Copy seL4 image file (`boot.cmd` assumes the image is named `loader.img`)

## Booting
1. Eject SD card from computer
2. Insert into Raspberry Pi 4B
3. Power on Raspberry Pi 4B

## Connecting to UART
Once seL4 is booted, seL4 output will be redirected to the UART interface on the Raspberry Pi. Perform the following:
1. Get a USB to UART TTL Cable.
2. Install applicable drivers to computer and software to read UART (e.g., PuTTY or CoolTerm)
3. Plug in wires to Raspberry Pi 4B. The GND is on pin 6, TX is on pin 8, RX is on pin 10 (ignore any power connections).
4. Plug into computer and monitor with software from step 2.
