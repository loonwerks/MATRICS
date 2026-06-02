
CPU := cortex-a72

VM_DIR = QEMU-VM
IMAGE_FILE = $(VM_DIR)/linux
LINUX_DTS = $(VM_DIR)/linux.dts
OVERLAY_DTS = $(VM_DIR)/overlay.dts
DTB_FILE = $(VM_DIR)/linux_combined.dtb
INITRAMFS_FILE = $(VM_DIR)/rootfs.cpio.gz

TEMP_DTS = combined_overlay.dts

$(DTB_FILE): $(LINUX_DTS) $(OVERLAY_DTS)
	@echo "Concatenating DTS files into $(TEMP_DTS)..."
	cat $^ > $(TEMP_DTS)
	@echo "Compiling $(TEMP_DTS) into $(DTB_FILE)..."
	dtc -@ -I dts -O dtb -o $@ $(TEMP_DTS)
	rm -f $(TEMP_DTS)


qemu_rpi: $(IMAGE_FILE) $(DTB_FILE)
	qemu-system-aarch64 -machine virt \
		-cpu cortex-a72 \
		-smp 4 -m 4G \
		-dtb $(DTB_FILE) \
		-kernel $(IMAGE_FILE) \
		-initrd $(INITRAMFS_FILE) \
		-serial mon:stdio \
		-nographic \
		-monitor telnet::45454,server,nowait \
		-append "earlycon=pl011,mmio32,0xfe215040 console=ttyAMA0,115200"

qemu: $(IMAGE_FILE) $(DTB_FILE)
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