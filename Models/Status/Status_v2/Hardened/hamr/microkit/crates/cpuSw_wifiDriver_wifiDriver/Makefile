# This file will not be overwritten if codegen is rerun

microkit_sdk_config_dir := $(MICROKIT_SDK)/board/$(MICROKIT_BOARD)/$(MICROKIT_CONFIG)

sel4_include_dirs := $(firstword $(wildcard $(microkit_sdk_config_dir)/include \
                                            $(microkit_sdk_config_dir)/debug/include))

export AR := llvm-ar 
export AS := llvm-as
export WIFI_LIBVMM_DIR := $(CRATES_DIR)/cpuSw_wifiDriver_wifiDriver

ENV_VARS = RUSTC_BOOTSTRAP=1

VM_IMAGES := $(CRATES_DIR)/cpuSw_wifiDriver_wifiDriver/images/

DTS := $(VM_IMAGES)/linux.dts
DTB := $(VM_IMAGES)/linux.dtb

LIBVMM := $(TOP_DIR)/libvmm
SDDF := $(LIBVMM)/dep/sddf

ARCH := aarch64

VPATH := ${LIBVMM}:$(CRATES_DIR)/cpuSw_wifiDriver_wifiDriver

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

BUILD_ENV_VARS = $(ENV_VARS) \
                 SEL4_INCLUDE_DIRS=$(abspath $(sel4_include_dirs)) \
			  LINUX_PATH=$(VM_IMAGES)/linux \
			  INITRD_PATH=$(VM_IMAGES)/rootfs.cpio.gz \
			  DTB_PATH=$(VM_IMAGES)/linux.dtb 

CARGO_FLAGS = -Z build-std=core,alloc,compiler_builtins \
              -Z build-std-features=compiler-builtins-mem \
		    -Z bindeps \
              --target aarch64-unknown-none \

all: build-verus-release

-include vmm.d

include $(LIBVMM)/vmm.mk
include $(SDDF)/util/util.mk

$(DTB): $(DTS)
	echo "made dtb"
	@echo $(LIBVMM)/vmm.mk
	dtc -q -I dts -O dtb $< > $@

build-verus-release: libvmm.a libsddf_util_debug.a $(DTB)
	$(BUILD_ENV_VARS) cargo-verus build --features sel4 $(CARGO_FLAGS) --release

build-verus: libvmm.a libsddf_util_debug.a $(DTB)
	$(BUILD_ENV_VARS) cargo-verus build --features sel4 $(CARGO_FLAGS)

build-release: libvmm.a libsddf_util_debug.a $(DTB)
	$(BUILD_ENV_VARS) cargo build --features sel4 $(CARGO_FLAGS) --release

build: libvmm.a libsddf_util_debug.a $(DTB)
	$(BUILD_ENV_VARS) cargo build --features sel4 $(CARGO_FLAGS)

verus: libvmm.a libsddf_util_debug.a $(DTB)
	$(ENV_VARS) cargo-verus verify $(CARGO_FLAGS)

verus-json: libvmm.a libsddf_util_debug.a $(DTB)
	$(ENV_VARS) cargo-verus verify $(CARGO_FLAGS) -- --output-json --time > verus_results.json

# Test Example:
#   Run all unit tests
#   Usage: make test
#
#   Run only unit tests whose name contains 'proptest'
#   Usage: make test args=proptest

test-release: libvmm.a libsddf_util_debug.a  $(DTB)
	cargo test $(args) --release

test: libvmm.a libsddf_util_debug.a $(DTB)
	cargo test $(args)

# Coverage Example:
#   Generate a test coverage report combining the results of all unit tests
#   Usage: make coverage
#
#   Generate a test coverage report for unit tests whose name contains 'proptest'
#   Usage: make coverage args=proptest

coverage: libvmm.a libsddf_util_debug.a $(DTB)
	cargo install grcov
	@exists=0; if [ -f target/coverage/report/index.html ]; then exists=1; fi; \
	rm -rf target/coverage; \
	CARGO_INCREMENTAL=0 RUSTFLAGS='-Cinstrument-coverage' LLVM_PROFILE_FILE='target/coverage/cargo-test-%p-%m.profraw' \
	cargo test $(args); \
	grcov . --binary-path ./target/debug/deps/ -s . -t html --branch --ignore-not-existing -o target/coverage/report; \
	if [ $$exists -eq 0 ]; then open target/coverage/report/index.html; fi

clean::
	cargo clean
