LIBVMM := $(abspath $(TOP_DIR)/libvmm)
SDDF := $(abspath $(LIBVMM)/dep/sddf)

ARCH := aarch64

VPATH := ${LIBVMM}:${WIFI_LIBVMM_DIR}

CFLAGS := -mcpu=$(CPU) \
	-mstrict-align \
	-ffreestanding \
	-nostdlib \
	-g3 \
	-O3 \
	-Wall -Wno-unused-function -Werror -Wno-unused-command-line-argument \
	-I$(MICROKIT_BOARD_DIR)/include \
	-target $(TARGET) \
	-I$(LIBVMM)/include \
	-I$(LIBVMM)/src \
	-I$(SDDF)/include \
	-I$(SDDF)/include/sddf/util/custom_libc \
	-I$(SDDF)/include/microkit \
	  -MD 

-include vmm.d

include $(LIBVMM)/vmm.mk
include $(SDDF)/util/util.mk

build-libvmm: libvmm.a libsddf_util_debug.a 
