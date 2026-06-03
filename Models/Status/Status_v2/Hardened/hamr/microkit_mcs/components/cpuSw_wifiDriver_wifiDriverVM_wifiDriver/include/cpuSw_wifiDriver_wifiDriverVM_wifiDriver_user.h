/*
 * Copyright 2024, DornerWorks
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
#pragma once

#include <microkit.h>

// This file will not be overwritten if HAMR codegen is rerun

#if defined(BOARD_qemu_virt_aarch64)
#define GUEST_DTB_VADDR           0x47f00000
#define GUEST_INIT_RAM_DISK_VADDR 0x47000000
#elif defined(BOARD_rpi4b_4gb)
#define GUEST_DTB_VADDR           0x2f000000
#define GUEST_INIT_RAM_DISK_VADDR 0x2d700000
#else
#error Need to define guest kernel image address and DTB address
#endif

#define MAX_IRQS 1

#if defined(BOARD_qemu_virt_aarch64)
#define SERIAL_IRQ_CH 1
#define SERIAL_IRQ 33
#elif defined(BOARD_rpi4b_4gb)
#define SERIAL_IRQ_CH 1
#define SERIAL_IRQ 57
#else
#error Need to define IRQs
#endif

struct mk_irq {
  int irq;
  microkit_channel channel;
};

struct mk_irq mk_irqs[MAX_IRQS] = {
  { // Serial
    .irq = SERIAL_IRQ,
    .channel = SERIAL_IRQ_CH
  }
};
