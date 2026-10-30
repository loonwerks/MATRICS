/*
 * Copyright 2024, DornerWorks
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
#pragma once

#include <microkit.h>

// This file will not be overwritten if HAMR codegen is rerun

#if defined(BOARD_qemu_virt_aarch64)
#define GUEST_RAM_SIZE 0x10000000
#define GUEST_RAM_START_VADDR 0x80000000
#define GUEST_DTB_VADDR           0x89000000
#define GUEST_INIT_RAM_DISK_VADDR 0x87000000
#elif defined(BOARD_rpi4b_4gb)
#define GUEST_RAM_SIZE 0x40000000
#define GUEST_RAM_START_VADDR 0x00000000
#define GUEST_DTB_VADDR           0x5f000000
#define GUEST_INIT_RAM_DISK_VADDR 0x5c000000
#else
#error Need to define guest kernel image address and DTB address
#endif

#if defined(BOARD_qemu_virt_aarch64)
#define MAX_IRQS 1
#define USB_IRQ_CH 1
#define USB_IRQ 36
#elif defined(BOARD_rpi4b_4gb)
#define MAX_IRQS 0
#define SERIAL_IRQ_CH 1
#define SERIAL_IRQ 125
#else
#error Need to define IRQs
#endif

struct mk_irq {
  int irq;
  microkit_channel channel;
};

#if defined(BOARD_qemu_virt_aarch64)
struct mk_irq mk_irqs[MAX_IRQS] = {
  // USB
  {
     .irq = USB_IRQ,
     .channel = USB_IRQ_CH,
  },
};
#elif defined(BOARD_rpi4b_4gb)
struct mk_irq mk_irqs[MAX_IRQS] = {
//   { // Serial
//     .irq = SERIAL_IRQ,
//     .channel = SERIAL_IRQ_CH,
//   },
};
#endif
