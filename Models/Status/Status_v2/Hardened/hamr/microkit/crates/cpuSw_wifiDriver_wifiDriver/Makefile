# This file will not be overwritten if codegen is rerun

microkit_sdk_config_dir := $(MICROKIT_SDK)/board/$(MICROKIT_BOARD)/$(MICROKIT_CONFIG)

sel4_include_dirs := $(firstword $(wildcard $(microkit_sdk_config_dir)/include \
                                            $(microkit_sdk_config_dir)/debug/include))

export AR := llvm-ar 
export AS := llvm-as
export WIFI_LIBVMM_DIR := $(CRATES_DIR)/cpuSw_wifiDriver_wifiDriver/build

ENV_VARS = RUSTC_BOOTSTRAP=1

VM_IMAGES := $(CRATES_DIR)/cpuSw_wifiDriver_wifiDriver/images

DTS := $(VM_IMAGES)/linux.dts
DTB := $(VM_IMAGES)/linux.dtb

BUILD_ENV_VARS = $(ENV_VARS) \
                 SEL4_INCLUDE_DIRS=$(abspath $(sel4_include_dirs)) \
			  LINUX_PATH=$(VM_IMAGES)/linux \
			  INITRD_PATH=$(VM_IMAGES)/rootfs.cpio.gz \
			  DTB_PATH=$(VM_IMAGES)/linux.dtb 

CARGO_FLAGS = -Z unstable-options \
			-Zjson-target-spec \
			-Z build-std=core,alloc,compiler_builtins \
              -Z build-std-features=compiler-builtins-mem \
		    -Z bindeps \
              --target aarch64-unknown-none

all: build-verus-release

$(DTB): $(DTS)
	dtc -q -I dts -O dtb $< > $@

vmm-images:
	mkdir -p $(WIFI_LIBVMM_DIR)
	cp libvmm.mk $(WIFI_LIBVMM_DIR)/Makefile
	$(MAKE) -C $(WIFI_LIBVMM_DIR) build-libvmm

build-verus-release: vmm-images $(DTB)
	$(BUILD_ENV_VARS) cargo-verus build --features sel4 $(CARGO_FLAGS) --release

build-verus: vmm-images $(DTB)
	$(BUILD_ENV_VARS) cargo-verus build --features sel4 $(CARGO_FLAGS)

build-release: vmm-images $(DTB)
	$(BUILD_ENV_VARS) cargo build --features sel4 $(CARGO_FLAGS) --release

build: vmm-images $(DTB)
	$(BUILD_ENV_VARS) cargo build --features sel4 $(CARGO_FLAGS)

verus: vmm-images $(DTB)
	$(ENV_VARS) cargo-verus verify $(CARGO_FLAGS)

verus-json: vmm-images $(DTB)
	$(ENV_VARS) cargo-verus verify $(CARGO_FLAGS) -- --output-json --time > verus_results.json

# Test Example:
#   Run all unit tests
#   Usage: make test
#
#   Run only unit tests whose name contains 'proptest'
#   Usage: make test args=proptest

test-release: vmm-images  $(DTB)
	cargo test $(args) --release

test: vmm-images $(DTB)
	cargo test $(args)

# Coverage Example:
#   Generate a test coverage report combining the results of all unit tests
#   Usage: make coverage
#
#   Generate a test coverage report for unit tests whose name contains 'proptest'
#   Usage: make coverage args=proptest

coverage: vmm-images $(DTB)
	cargo install grcov
	@exists=0; if [ -f target/coverage/report/index.html ]; then exists=1; fi; \
	rm -rf target/coverage; \
	CARGO_INCREMENTAL=0 RUSTFLAGS='-Cinstrument-coverage' LLVM_PROFILE_FILE='target/coverage/cargo-test-%p-%m.profraw' \
	cargo test $(args); \
	grcov . --binary-path ./target/debug/deps/ -s . -t html --branch --ignore-not-existing -o target/coverage/report; \
	if [ $$exists -eq 0 ]; then open target/coverage/report/index.html; fi

clean::
	rm -rf build
	cargo clean
