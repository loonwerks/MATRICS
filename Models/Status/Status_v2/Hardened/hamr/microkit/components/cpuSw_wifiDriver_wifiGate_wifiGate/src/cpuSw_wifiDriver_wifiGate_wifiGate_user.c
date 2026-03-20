#include "cpuSw_wifiDriver_wifiGate_wifiGate.h"

// This file will not be overwritten if codegen is rerun

void cpuSw_wifiDriver_wifiGate_wifiGate_initialize(void) {
  printf("%s: cpuSw_wifiDriver_wifiGate_wifiGate_initialize invoked\n", microkit_name);
}

void cpuSw_wifiDriver_wifiGate_wifiGate_timeTriggered(void) {
  printf("%s: cpuSw_wifiDriver_wifiGate_wifiGate_timeTriggered invoked\n", microkit_name);
}

void cpuSw_wifiDriver_wifiGate_wifiGate_notify(microkit_channel channel) {
  // this method is called when the monitor does not handle the passed in channel
  switch (channel) {
    default:
      printf("%s: Unexpected channel %d\n", microkit_name, channel);
  }
}
