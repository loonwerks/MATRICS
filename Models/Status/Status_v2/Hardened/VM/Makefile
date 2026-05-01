
CPU := cortex-a72

VM_DIR = Test-VM
IMAGE_FILE = $(VM_DIR)/linux
DTB_FILE = Microkit-VM/linux.dtb
INITRAMFS_FILE = $(VM_DIR)/rootfs.cpio.gz

run: $(IMAGE_FILE)
	qemu-system-aarch64 -machine raspi4b \
		-cpu $(CPU) \
		-smp 4 -m 2G \
		-dtb $(DTB_FILE) \
		-kernel $(IMAGE_FILE) \
		-initrd $(INITRAMFS_FILE) \
		-drive file=sd.img,if=sd,format=raw \
		-serial mon:stdio \
		-usb -device usb-kbd -device usb-mouse \
		-monitor telnet::45454,server,nowait \
		-append "earlycon=pl011,mmio32,0xfe201000 console=ttyAMA0,115200"

qemu: $(IMAGE_FILE)
	qemu-system-aarch64 -machine virt,virtualization=on,highmem=off,secure=off,gic-version=2 \
			-cpu cortex-a53 \
			-serial mon:stdio \
			-dtb $(DTB_FILE) \
			-kernel $(IMAGE_FILE) \
			-initrd $(INITRAMFS_FILE) \
			-m size=1G \
			-nographic \
			-global virtio-mmio.force-legacy=false \
			-netdev user,id=mynet0  \
 			-device virtio-net-device,netdev=mynet0