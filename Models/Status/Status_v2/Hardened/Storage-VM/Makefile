
CPU := cortex-a72

VM_DIR = QEMU-VM
IMAGE_FILE = $(VM_DIR)/linux
LINUX_DTS = $(VM_DIR)/linux.dts
OVERLAY_DTS = $(VM_DIR)/overlay.dts
DTB_FILE = $(VM_DIR)/linux_combined.dtb
INITRAMFS_FILE = $(VM_DIR)/rootfs.cpio.gz
USB_IMG = $(VM_DIR)/usb.img

TEMP_DTS = combined_overlay.dts

$(DTB_FILE): $(LINUX_DTS) $(OVERLAY_DTS)
	@echo "Concatenating DTS files into $(TEMP_DTS)..."
	cat $^ > $(TEMP_DTS)
	@echo "Compiling $(TEMP_DTS) into $(DTB_FILE)..."
	dtc -@ -I dts -O dtb -o $@ $(TEMP_DTS)
	rm -f $(TEMP_DTS)

$(USB_IMG):
	dd if=/dev/zero of=$(USB_IMG) bs=1M count=1024

# Reserve the guest's 16 KiB PCI aperture for xHCI, without QEMU's default NIC.
qemu: $(IMAGE_FILE) $(DTB_FILE) $(USB_IMG)
	qemu-system-aarch64 -machine virt,virtualization=on,highmem=off,secure=off,gic-version=2 \
			-cpu cortex-a53 \
			-serial mon:stdio \
			-dtb $(DTB_FILE) \
			-kernel $(IMAGE_FILE) \
			-initrd $(INITRAMFS_FILE) \
			-m size=1G \
			-nographic \
			-nic none \
			-global virtio-mmio.force-legacy=false \
			-device qemu-xhci,id=xhci \
			-drive file=$(USB_IMG),format=raw,if=none,id=myusb \
			-device usb-storage,bus=xhci.0,drive=myusb,removable=on
