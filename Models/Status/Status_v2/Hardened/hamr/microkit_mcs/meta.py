# Copyright 2025, UNSW
# SPDX-License-Identifier: BSD-2-Clause
import argparse
import struct
import xml.etree.ElementTree as ET
from random import randint
from dataclasses import dataclass
from typing import List, Tuple, Optional
from sdfgen import SystemDescription, Sddf, DeviceTree, LionsOs
from importlib.metadata import version

# This file will not be overwritten if HAMR codegen is rerun

assert version('sdfgen').split(".")[1] == "30", "Unexpected sdfgen version"

from sdfgen_helper import *

ProtectionDomain = SystemDescription.ProtectionDomain
MemoryRegion = SystemDescription.MemoryRegion
Map = SystemDescription.Map
Channel = SystemDescription.Channel
IrqConventional = SystemDescription.IrqConventional
VirtualMachine = SystemDescription.VirtualMachine

@dataclass
class Board:
    name: str
    arch: SystemDescription.Arch
    paddr_top: int
    serial: str
    timer: str
    ethernet: str
    i2c: Optional[str]


BOARDS: List[Board] = [
    Board(
        name="qemu_virt_aarch64",
        arch=SystemDescription.Arch.AARCH64,
        paddr_top=0x6_0000_000,
        serial="pl011@9000000",
        timer="timer",
        ethernet="virtio_mmio@a003e00",
        i2c=None,
    ),
    Board(
        name="rpi4b_4gb",
        arch=SystemDescription.Arch.AARCH64,
        paddr_top=0x2_000_000,
        serial="soc/serial@7e215040",
        timer="soc/timer@7e003000",
        ethernet=None,
        i2c=None,
    ),
]

def schedule(*entries):
    """
    entries: sequence of (channel, timeslice_ns)
    """
    part_ch, part_timeslices, is_user_partition = zip(*entries)
    return UserSchedule(list(part_timeslices), list(part_ch), list(is_user_partition))

def add_setvar_vaddr(xml_str, mappings):
    """
    Post-process sdf.render() output to add setvar_vaddr attributes.
    sdfgen v27-29 does not support setvar_vaddr natively.
    mappings: dict of (pd_name, mr_name) -> var_name
    """
    root = ET.fromstring(xml_str)
    for pd in root.iter('protection_domain'):
        pd_name = pd.get('name')
        for m in pd.findall('map'):
            key = (pd_name, m.get('mr'))
            if key in mappings:
                m.set('setvar_vaddr', mappings[key])
    ET.indent(root, space='  ')
    return ET.tostring(root, encoding='unicode', xml_declaration=True)

setvar_mappings = {
    ("cpuSw_btDriver_btDriver", "GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btRecv_1_Memory_Region"): "btRecv_queue_1",
    ("cpuSw_btDriver_btDriver", "GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btSend_1_Memory_Region"): "btSend_queue_1",
    ("cpuSw_usbDriver_usbDriver", "GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbRecv_1_Memory_Region"): "usbRecv_queue_1",
    ("cpuSw_usbDriver_usbDriver", "GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbSend_1_Memory_Region"): "usbSend_queue_1",
    ("cpuSw_dataManager_dataManager", "GroundStation_Impl_Instance_cpuSw_dataManager_dataManager_response_log_1_Memory_Region"): "response_log_queue_1",
    ("cpuSw_dataManager_dataManager", "GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_request_log_1_Memory_Region"): "request_log_queue_1",
    ("cpuSw_dataManager_dataManager", "GroundStation_Impl_Instance_cpuSw_decryptor_decryptor_HMD_log_out_1_Memory_Region"): "HMD_log_queue_1",
    ("cpuSw_dataManager_dataManager", "GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_alert_1_Memory_Region"): "zeroize_queue_1",
    ("cpuSw_dataAnalysis_dataAnalysis", "GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_request_log_1_Memory_Region"): "request_log_queue_1",
    ("cpuSw_dataAnalysis_dataAnalysis", "GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_analysis_report_1_Memory_Region"): "analysis_report_queue_1",
    ("cpuSw_dataAnalysis_dataAnalysis", "GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_response_log_out_1_Memory_Region"): "response_log_queue_1",
    ("cpuSw_dataAnalysis_dataAnalysis", "GroundStation_Impl_Instance_cpuSw_firewall_firewall_analysis_request_out_1_Memory_Region"): "analysis_request_queue_1",
    ("cpuSw_decryptor_decryptor", "GroundStation_Impl_Instance_cpuSw_decryptor_decryptor_HMD_log_out_1_Memory_Region"): "HMD_log_out_queue_1",
    ("cpuSw_decryptor_decryptor", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_HMD_log_1_Memory_Region"): "HMD_log_in_queue_1",
    ("cpuSw_encryptor_encryptor", "GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_analysis_report_1_Memory_Region"): "analysis_report_in_queue_1",
    ("cpuSw_encryptor_encryptor", "GroundStation_Impl_Instance_cpuSw_encryptor_encryptor_analysis_report_out_1_Memory_Region"): "analysis_report_out_queue_1",
    ("cpuSw_logMonitor_logMonitor", "GroundStation_Impl_Instance_cpuSw_dataManager_dataManager_response_log_1_Memory_Region"): "response_log_in_queue_1",
    ("cpuSw_logMonitor_logMonitor", "GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_request_log_1_Memory_Region"): "request_log_queue_1",
    ("cpuSw_logMonitor_logMonitor", "GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_response_log_out_1_Memory_Region"): "response_log_out_queue_1",
    ("cpuSw_logMonitor_logMonitor", "GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_alert_1_Memory_Region"): "alert_queue_1",
    ("cpuSw_reportMonitor_reportMonitor", "GroundStation_Impl_Instance_cpuSw_encryptor_encryptor_analysis_report_out_1_Memory_Region"): "analysis_report_in_queue_1",
    ("cpuSw_reportMonitor_reportMonitor", "GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_analysis_report_out_1_Memory_Region"): "analysis_report_out_queue_1",
    ("cpuSw_reportMonitor_reportMonitor", "GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_alert_1_Memory_Region"): "alert_queue_1",
    ("cpuSw_reportMonitor_reportMonitor", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_analysis_request_1_Memory_Region"): "analysis_request_queue_1",
    ("cpuSw_firewall_firewall", "GroundStation_Impl_Instance_cpuSw_firewall_firewall_analysis_request_out_1_Memory_Region"): "analysis_request_out_queue_1",
    ("cpuSw_firewall_firewall", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_analysis_request_1_Memory_Region"): "analysis_request_in_queue_1",
    ("cpuSw_wifiDriver_wifiDriver_wifiDriver", "GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_analysis_report_out_1_Memory_Region"): "analysis_report_queue_1",
    ("cpuSw_wifiDriver_wifiDriver_wifiDriver", "GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_alert_1_Memory_Region"): "alert_queue_1",
    ("cpuSw_wifiDriver_wifiDriver_wifiDriver", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_wifiSend_1_Memory_Region"): "wifiSend_queue_1",
    ("cpuSw_wifiDriver_wifiDriver_wifiDriver", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_HMD_log_1_Memory_Region"): "HMD_log_queue_1",
    ("cpuSw_wifiDriver_wifiDriver_wifiDriver", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_analysis_request_1_Memory_Region"): "analysis_request_queue_1",
    ("cpuSw_wifiDriver_wifiDriver_wifiDriver", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvOut_1_Memory_Region"): "wifiRecv_queue_1",
    ("cpuSw_wifiDriver_wifiDriverVM_wifiDriver", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_RAM"): "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_RAM_vaddr",
    ("cpuSw_wifiDriver_wifiDriverVM_wifiDriver", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_wifiSend_1_Memory_Region"): "wifiSendIn_queue_1",
    ("cpuSw_wifiDriver_wifiDriverVM_wifiDriver", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvOut_1_Memory_Region"): "wifiRecvOut_queue_1",
    ("cpuSw_wifiDriver_wifiDriverVM_wifiDriver", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvIn_1_Memory_Region"): "wifiRecvIn_queue_1",
    ("cpuSw_wifiDriver_wifiDriverVM_wifiDriver", "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiSendOut_1_Memory_Region"): "wifiSendOut_queue_1"
}

def generate(sdf_path: str, output_dir: str, dtb: DeviceTree):
    timer_node = dtb.node(board.timer)
    assert timer_node is not None

    timer_driver = ProtectionDomain("timer_driver", "timer_driver.elf", priority=201)
    timer_system = Sddf.Timer(sdf, timer_node, timer_driver)

    scheduler = ProtectionDomain("scheduler", "scheduler.elf", priority=200)

    if board.name == "qemu_virt_aarch64":
        RAM = 0x4000_0000
        RAM_SIZE = 0x1000_0000
        GIC_VM = 0x8_010_000
        GIC_VMM = 0x8_040_000
        Serial = 0x9_000_000
        Serial_IRQ = 33
        OFFSET = 0
    elif board.name == "rpi4b_4gb":
        RAM = 0x2000_0000
        RAM_SIZE = 0x1000_0000
        GIC_VM = 0xFF84_2000 # CPU Interface
        GIC_VMM = 0xFF84_6000 # vCPU interface
        Serial = 0xFE21_5000
        Serial_IRQ = 125
        OFFSET = 0
    else:
        assert False



    # BEGIN META MARKER

    #######################################
    # PARTITION PROTECTION DOMAINS
    #######################################
    cpuSw_btDriver_btDriver_MON = ProtectionDomain("cpuSw_btDriver_btDriver_MON", "cpuSw_btDriver_btDriver_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_btDriver_btDriver_MON)
    cpuSw_usbDriver_usbDriver_MON = ProtectionDomain("cpuSw_usbDriver_usbDriver_MON", "cpuSw_usbDriver_usbDriver_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_usbDriver_usbDriver_MON)
    cpuSw_dataManager_dataManager_MON = ProtectionDomain("cpuSw_dataManager_dataManager_MON", "cpuSw_dataManager_dataManager_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_dataManager_dataManager_MON)
    cpuSw_dataAnalysis_dataAnalysis_MON = ProtectionDomain("cpuSw_dataAnalysis_dataAnalysis_MON", "cpuSw_dataAnalysis_dataAnalysis_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_dataAnalysis_dataAnalysis_MON)
    cpuSw_decryptor_decryptor_MON = ProtectionDomain("cpuSw_decryptor_decryptor_MON", "cpuSw_decryptor_decryptor_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_decryptor_decryptor_MON)
    cpuSw_encryptor_encryptor_MON = ProtectionDomain("cpuSw_encryptor_encryptor_MON", "cpuSw_encryptor_encryptor_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_encryptor_encryptor_MON)
    cpuSw_logMonitor_logMonitor_MON = ProtectionDomain("cpuSw_logMonitor_logMonitor_MON", "cpuSw_logMonitor_logMonitor_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_logMonitor_logMonitor_MON)
    cpuSw_reportMonitor_reportMonitor_MON = ProtectionDomain("cpuSw_reportMonitor_reportMonitor_MON", "cpuSw_reportMonitor_reportMonitor_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_reportMonitor_reportMonitor_MON)
    cpuSw_firewall_firewall_MON = ProtectionDomain("cpuSw_firewall_firewall_MON", "cpuSw_firewall_firewall_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_firewall_firewall_MON)
    cpuSw_wifiDriver_wifiDriver_wifiDriver_MON = ProtectionDomain("cpuSw_wifiDriver_wifiDriver_wifiDriver_MON", "cpuSw_wifiDriver_wifiDriver_wifiDriver_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_wifiDriver_wifiDriver_wifiDriver_MON)
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON = ProtectionDomain("cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON", "cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON.elf", priority=150, passive=True)
    scheduler.add_child_pd(cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON)

    cpuSw_btDriver_btDriver = ProtectionDomain("cpuSw_btDriver_btDriver", "cpuSw_btDriver_btDriver.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_btDriver_btDriver)
    cpuSw_usbDriver_usbDriver = ProtectionDomain("cpuSw_usbDriver_usbDriver", "cpuSw_usbDriver_usbDriver.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_usbDriver_usbDriver)
    cpuSw_dataManager_dataManager = ProtectionDomain("cpuSw_dataManager_dataManager", "cpuSw_dataManager_dataManager.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_dataManager_dataManager)
    cpuSw_dataAnalysis_dataAnalysis = ProtectionDomain("cpuSw_dataAnalysis_dataAnalysis", "cpuSw_dataAnalysis_dataAnalysis.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_dataAnalysis_dataAnalysis)
    cpuSw_decryptor_decryptor = ProtectionDomain("cpuSw_decryptor_decryptor", "cpuSw_decryptor_decryptor.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_decryptor_decryptor)
    cpuSw_encryptor_encryptor = ProtectionDomain("cpuSw_encryptor_encryptor", "cpuSw_encryptor_encryptor.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_encryptor_encryptor)
    cpuSw_logMonitor_logMonitor = ProtectionDomain("cpuSw_logMonitor_logMonitor", "cpuSw_logMonitor_logMonitor.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_logMonitor_logMonitor)
    cpuSw_reportMonitor_reportMonitor = ProtectionDomain("cpuSw_reportMonitor_reportMonitor", "cpuSw_reportMonitor_reportMonitor.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_reportMonitor_reportMonitor)
    cpuSw_firewall_firewall = ProtectionDomain("cpuSw_firewall_firewall", "cpuSw_firewall_firewall.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_firewall_firewall)
    cpuSw_wifiDriver_wifiDriver_wifiDriver = ProtectionDomain("cpuSw_wifiDriver_wifiDriver_wifiDriver", "cpuSw_wifiDriver_wifiDriver_wifiDriver.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_wifiDriver_wifiDriver_wifiDriver)
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver = ProtectionDomain("cpuSw_wifiDriver_wifiDriverVM_wifiDriver", "cpuSw_wifiDriver_wifiDriverVM_wifiDriver.elf", priority=140, passive=True)
    scheduler.add_child_pd(cpuSw_wifiDriver_wifiDriverVM_wifiDriver)

    #######################################
    # MEMORY REGIONS
    #######################################
    GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_RAM = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_RAM", size=RAM_SIZE, paddr=RAM)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_RAM)
    GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_GIC = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_GIC", size=0x1_000, paddr=GIC_VMM)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_GIC)
    GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_Serial = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_Serial", size=0x1_000, paddr=Serial)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_Serial)
    GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btRecv_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btRecv_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btRecv_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btSend_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btSend_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btSend_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbRecv_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbRecv_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbRecv_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbSend_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbSend_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbSend_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_dataManager_dataManager_response_log_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_dataManager_dataManager_response_log_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_dataManager_dataManager_response_log_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_request_log_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_request_log_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_request_log_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_analysis_report_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_analysis_report_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_analysis_report_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_decryptor_decryptor_HMD_log_out_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_decryptor_decryptor_HMD_log_out_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_decryptor_decryptor_HMD_log_out_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_encryptor_encryptor_analysis_report_out_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_encryptor_encryptor_analysis_report_out_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_encryptor_encryptor_analysis_report_out_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_response_log_out_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_response_log_out_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_response_log_out_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_alert_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_alert_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_alert_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_analysis_report_out_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_analysis_report_out_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_analysis_report_out_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_alert_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_alert_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_alert_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_firewall_firewall_analysis_request_out_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_firewall_firewall_analysis_request_out_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_firewall_firewall_analysis_request_out_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_wifiSend_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_wifiSend_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_wifiSend_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_HMD_log_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_HMD_log_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_HMD_log_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_analysis_request_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_analysis_request_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_analysis_request_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvOut_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvOut_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvOut_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvIn_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvIn_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvIn_1_Memory_Region)
    GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiSendOut_1_Memory_Region = MemoryRegion(sdf, "GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiSendOut_1_Memory_Region", 0x1_000)
    sdf.add_mr(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiSendOut_1_Memory_Region)

    cpuSw_wifiDriver_wifiDriverVM_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_RAM, RAM, perms="rw"))
    cpuSw_btDriver_btDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btRecv_1_Memory_Region, 0x10_000_000 + OFFSET, perms="r"))
    cpuSw_btDriver_btDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_btDriver_btDriver_btSend_1_Memory_Region, 0x10_001_000 + OFFSET, perms="rw"))
    cpuSw_usbDriver_usbDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbRecv_1_Memory_Region, 0x10_000_000 + OFFSET, perms="r"))
    cpuSw_usbDriver_usbDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_usbDriver_usbDriver_usbSend_1_Memory_Region, 0x10_001_000 + OFFSET, perms="rw"))
    cpuSw_dataManager_dataManager.add_map(Map(GroundStation_Impl_Instance_cpuSw_dataManager_dataManager_response_log_1_Memory_Region, 0x10_000_000 + OFFSET, perms="rw"))
    cpuSw_logMonitor_logMonitor.add_map(Map(GroundStation_Impl_Instance_cpuSw_dataManager_dataManager_response_log_1_Memory_Region, 0x10_000_000 + OFFSET, perms="r"))
    cpuSw_dataManager_dataManager.add_map(Map(GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_request_log_1_Memory_Region, 0x10_001_000 + OFFSET, perms="r"))
    cpuSw_dataAnalysis_dataAnalysis.add_map(Map(GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_request_log_1_Memory_Region, 0x10_000_000 + OFFSET, perms="rw"))
    cpuSw_logMonitor_logMonitor.add_map(Map(GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_request_log_1_Memory_Region, 0x10_001_000 + OFFSET, perms="r"))
    cpuSw_dataAnalysis_dataAnalysis.add_map(Map(GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_analysis_report_1_Memory_Region, 0x10_001_000 + OFFSET, perms="rw"))
    cpuSw_encryptor_encryptor.add_map(Map(GroundStation_Impl_Instance_cpuSw_dataAnalysis_dataAnalysis_analysis_report_1_Memory_Region, 0x10_000_000 + OFFSET, perms="r"))
    cpuSw_dataManager_dataManager.add_map(Map(GroundStation_Impl_Instance_cpuSw_decryptor_decryptor_HMD_log_out_1_Memory_Region, 0x10_002_000 + OFFSET, perms="r"))
    cpuSw_decryptor_decryptor.add_map(Map(GroundStation_Impl_Instance_cpuSw_decryptor_decryptor_HMD_log_out_1_Memory_Region, 0x10_000_000 + OFFSET, perms="rw"))
    cpuSw_encryptor_encryptor.add_map(Map(GroundStation_Impl_Instance_cpuSw_encryptor_encryptor_analysis_report_out_1_Memory_Region, 0x10_001_000 + OFFSET, perms="rw"))
    cpuSw_reportMonitor_reportMonitor.add_map(Map(GroundStation_Impl_Instance_cpuSw_encryptor_encryptor_analysis_report_out_1_Memory_Region, 0x10_000_000 + OFFSET, perms="r"))
    cpuSw_dataAnalysis_dataAnalysis.add_map(Map(GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_response_log_out_1_Memory_Region, 0x10_002_000 + OFFSET, perms="r"))
    cpuSw_logMonitor_logMonitor.add_map(Map(GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_response_log_out_1_Memory_Region, 0x10_002_000 + OFFSET, perms="rw"))
    cpuSw_dataManager_dataManager.add_map(Map(GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_alert_1_Memory_Region, 0x10_003_000 + OFFSET, perms="r"))
    cpuSw_logMonitor_logMonitor.add_map(Map(GroundStation_Impl_Instance_cpuSw_logMonitor_logMonitor_alert_1_Memory_Region, 0x10_003_000 + OFFSET, perms="rw"))
    cpuSw_reportMonitor_reportMonitor.add_map(Map(GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_analysis_report_out_1_Memory_Region, 0x10_001_000 + OFFSET, perms="rw"))
    cpuSw_wifiDriver_wifiDriver_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_analysis_report_out_1_Memory_Region, 0x10_000_000 + OFFSET, perms="r"))
    cpuSw_reportMonitor_reportMonitor.add_map(Map(GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_alert_1_Memory_Region, 0x10_002_000 + OFFSET, perms="rw"))
    cpuSw_wifiDriver_wifiDriver_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_reportMonitor_reportMonitor_alert_1_Memory_Region, 0x10_001_000 + OFFSET, perms="r"))
    cpuSw_dataAnalysis_dataAnalysis.add_map(Map(GroundStation_Impl_Instance_cpuSw_firewall_firewall_analysis_request_out_1_Memory_Region, 0x10_003_000 + OFFSET, perms="r"))
    cpuSw_firewall_firewall.add_map(Map(GroundStation_Impl_Instance_cpuSw_firewall_firewall_analysis_request_out_1_Memory_Region, 0x10_000_000 + OFFSET, perms="rw"))
    cpuSw_wifiDriver_wifiDriver_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_wifiSend_1_Memory_Region, 0x10_002_000 + OFFSET, perms="rw"))
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_wifiSend_1_Memory_Region, 0x10_000_000 + OFFSET, perms="r"))
    cpuSw_decryptor_decryptor.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_HMD_log_1_Memory_Region, 0x10_001_000 + OFFSET, perms="r"))
    cpuSw_wifiDriver_wifiDriver_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_HMD_log_1_Memory_Region, 0x10_003_000 + OFFSET, perms="rw"))
    cpuSw_reportMonitor_reportMonitor.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_analysis_request_1_Memory_Region, 0x10_003_000 + OFFSET, perms="r"))
    cpuSw_firewall_firewall.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_analysis_request_1_Memory_Region, 0x10_001_000 + OFFSET, perms="r"))
    cpuSw_wifiDriver_wifiDriver_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriver_wifiDriver_analysis_request_1_Memory_Region, 0x10_004_000 + OFFSET, perms="rw"))
    cpuSw_wifiDriver_wifiDriver_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvOut_1_Memory_Region, 0x10_005_000 + OFFSET, perms="r"))
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvOut_1_Memory_Region, 0x10_001_000 + OFFSET, perms="rw"))
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiRecvIn_1_Memory_Region, 0x10_002_000 + OFFSET, perms="r"))
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_wifiSendOut_1_Memory_Region, 0x10_003_000 + OFFSET, perms="rw"))

    #######################################
    # Interrupts
    #######################################
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver.add_irq(IrqConventional(irq=Serial_IRQ,id=1))

    #######################################
    # Virtual Machines
    #######################################
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM = VirtualMachine("cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM", [VirtualMachine.Vcpu(id=0)])
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_RAM, RAM, perms="rwx"))
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_GIC, GIC_VM, cached=False, perms="rw"))
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM.add_map(Map(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_Serial, Serial, cached=False, perms="rw"))
    cpuSw_wifiDriver_wifiDriverVM_wifiDriver.set_virtual_machine(cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM)

    #######################################
    # CHANNELS
    #######################################
    channel_cpuSw_btDriver_btDriver_MON = 11
    channel_cpuSw_usbDriver_usbDriver_MON = 12
    channel_cpuSw_dataManager_dataManager_MON = 7
    channel_cpuSw_dataAnalysis_dataAnalysis_MON = 6
    channel_cpuSw_decryptor_decryptor_MON = 4
    channel_cpuSw_encryptor_encryptor_MON = 9
    channel_cpuSw_logMonitor_logMonitor_MON = 8
    channel_cpuSw_reportMonitor_reportMonitor_MON = 10
    channel_cpuSw_firewall_firewall_MON = 5
    channel_cpuSw_wifiDriver_wifiDriver_wifiDriver_MON = 3
    channel_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON = 2

    sdf.add_channel(Channel(scheduler, cpuSw_btDriver_btDriver_MON, a_id=channel_cpuSw_btDriver_btDriver_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_btDriver_btDriver_MON, cpuSw_btDriver_btDriver, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_usbDriver_usbDriver_MON, a_id=channel_cpuSw_usbDriver_usbDriver_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_usbDriver_usbDriver_MON, cpuSw_usbDriver_usbDriver, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_dataManager_dataManager_MON, a_id=channel_cpuSw_dataManager_dataManager_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_dataManager_dataManager_MON, cpuSw_dataManager_dataManager, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_dataAnalysis_dataAnalysis_MON, a_id=channel_cpuSw_dataAnalysis_dataAnalysis_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_dataAnalysis_dataAnalysis_MON, cpuSw_dataAnalysis_dataAnalysis, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_decryptor_decryptor_MON, a_id=channel_cpuSw_decryptor_decryptor_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_decryptor_decryptor_MON, cpuSw_decryptor_decryptor, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_encryptor_encryptor_MON, a_id=channel_cpuSw_encryptor_encryptor_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_encryptor_encryptor_MON, cpuSw_encryptor_encryptor, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_logMonitor_logMonitor_MON, a_id=channel_cpuSw_logMonitor_logMonitor_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_logMonitor_logMonitor_MON, cpuSw_logMonitor_logMonitor, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_reportMonitor_reportMonitor_MON, a_id=channel_cpuSw_reportMonitor_reportMonitor_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_reportMonitor_reportMonitor_MON, cpuSw_reportMonitor_reportMonitor, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_firewall_firewall_MON, a_id=channel_cpuSw_firewall_firewall_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_firewall_firewall_MON, cpuSw_firewall_firewall, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_wifiDriver_wifiDriver_wifiDriver_MON, a_id=channel_cpuSw_wifiDriver_wifiDriver_wifiDriver_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_wifiDriver_wifiDriver_wifiDriver_MON, cpuSw_wifiDriver_wifiDriver_wifiDriver, a_id=1, b_id=0))
    sdf.add_channel(Channel(scheduler, cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON, a_id=channel_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON, b_id=0))
    sdf.add_channel(Channel(cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON, cpuSw_wifiDriver_wifiDriverVM_wifiDriver, a_id=1, b_id=0))

    #######################################
    # SCHEDULE
    #######################################
    ts_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON = (channel_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON, 150000000, True)
    ts_cpuSw_wifiDriver_wifiDriver_wifiDriver_MON = (channel_cpuSw_wifiDriver_wifiDriver_wifiDriver_MON, 50000000, True)
    ts_cpuSw_decryptor_decryptor_MON = (channel_cpuSw_decryptor_decryptor_MON, 50000000, True)
    ts_cpuSw_firewall_firewall_MON = (channel_cpuSw_firewall_firewall_MON, 50000000, True)
    ts_cpuSw_dataAnalysis_dataAnalysis_MON = (channel_cpuSw_dataAnalysis_dataAnalysis_MON, 50000000, True)
    ts_cpuSw_dataManager_dataManager_MON = (channel_cpuSw_dataManager_dataManager_MON, 50000000, True)
    ts_cpuSw_logMonitor_logMonitor_MON = (channel_cpuSw_logMonitor_logMonitor_MON, 50000000, True)
    ts_cpuSw_encryptor_encryptor_MON = (channel_cpuSw_encryptor_encryptor_MON, 50000000, True)
    ts_cpuSw_reportMonitor_reportMonitor_MON = (channel_cpuSw_reportMonitor_reportMonitor_MON, 50000000, True)
    ts_cpuSw_btDriver_btDriver_MON = (channel_cpuSw_btDriver_btDriver_MON, 50000000, True)
    ts_cpuSw_usbDriver_usbDriver_MON = (channel_cpuSw_usbDriver_usbDriver_MON, 50000000, True)
    ts_pad = (0, 350000000, False)

    user_schedule = schedule(
      ts_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_MON,
      ts_cpuSw_wifiDriver_wifiDriver_wifiDriver_MON,
      ts_cpuSw_decryptor_decryptor_MON,
      ts_cpuSw_firewall_firewall_MON,
      ts_cpuSw_dataAnalysis_dataAnalysis_MON,
      ts_cpuSw_dataManager_dataManager_MON,
      ts_cpuSw_logMonitor_logMonitor_MON,
      ts_cpuSw_encryptor_encryptor_MON,
      ts_cpuSw_reportMonitor_reportMonitor_MON,
      ts_cpuSw_btDriver_btDriver_MON,
      ts_cpuSw_usbDriver_usbDriver_MON,
      ts_pad
    )

    # END META MARKER

    sdf.add_pd(timer_driver)
    sdf.add_pd(scheduler)
    timer_system.add_client(scheduler)

    assert timer_system.connect()
    assert timer_system.serialise_config(output_dir)

    data_path = output_dir + "/schedule_config.data"
    with open(data_path, "wb+") as f:
        f.write(user_schedule.serialise())
    update_elf_section(obj_copy, scheduler.program_image,
                       user_schedule.section_name,
                       data_path)

    with open(f"{output_dir}/{sdf_path}", "w+") as f:
        f.write(add_setvar_vaddr(sdf.render(), setvar_mappings))


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--dtb", required=True)
    parser.add_argument("--sddf", required=True)
    parser.add_argument("--board", required=True, choices=[b.name for b in BOARDS])
    parser.add_argument("--output", required=True)
    parser.add_argument("--sdf", required=True)
    parser.add_argument("--objcopy", required=True)

    args = parser.parse_args()

    # Import the config structs module from the build directory
    sys.path.append(args.output)
    from config_structs import *

    board = next(filter(lambda b: b.name == args.board, BOARDS))

    sdf = SystemDescription(board.arch, board.paddr_top)
    sddf = Sddf(args.sddf)

    global obj_copy
    obj_copy = args.objcopy

    with open(args.dtb, "rb") as f:
        dtb = DeviceTree(f.read())

    generate(args.sdf, args.output, dtb)
