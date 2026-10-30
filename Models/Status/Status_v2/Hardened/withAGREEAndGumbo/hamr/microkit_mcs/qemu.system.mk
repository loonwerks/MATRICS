# QEMU board additions kept outside HAMR's generated system.mk.
override SUPPORTED_BOARDS := qemu_virt_aarch64 rpi4b_4gb
include $(TOP_DIR)/system.mk

USB_IMG := $(TOP_DIR)/components/cpuSw_dataManager_dataStorage_dataStorage/board/qemu_virt_aarch64/usb.img

qemu: $(USB_IMG)

$(USB_IMG):
	dd if=/dev/zero of=$@ bs=1M count=1024

# Preserve the QEMU platform and networking options used by the Wi-Fi guest.
override QEMU_ARCH_ARGS := \
	-machine virt,virtualization=on,highmem=off,secure=off,gic-version=2 \
	-cpu cortex-a53 \
	-serial mon:stdio \
	-device loader,file=$(IMAGE_FILE),addr=0x70000000,cpu-num=0 \
	-m 2G \
	-global virtio-mmio.force-legacy=false \
	-netdev user,id=mynet0,hostfwd=tcp::8080-:80,hostfwd=tcp::8443-:443 \
	-device virtio-net-device,netdev=mynet0 \
	-device qemu-xhci,id=xhci \
	-drive file=$(USB_IMG),format=raw,if=none,id=myusb \
	-device usb-storage,bus=xhci.0,drive=myusb,removable=on
