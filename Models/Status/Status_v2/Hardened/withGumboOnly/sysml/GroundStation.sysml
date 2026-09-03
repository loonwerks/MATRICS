//@ HAMR: --platform Microkit --sel4-output-dir ../hamr/microkit_mcs

// SysML v2 realization of the HAMR-supported portion of the Ground Station.

package GroundStation {

    private import HAMR::*;

    ///////////////////////////////////////////////////////////////////////
    // Thread classifiers
    ///////////////////////////////////////////////////////////////////////

    part def Periodic_Rust_Thread :> Thread {
        attribute :>> Dispatch_Protocol = Periodic;
        attribute :>> Period = 1000 [ms];
        attribute :>> Stack_Size = 1048576 [byte];
        attribute :>> Implementation_Language = Rust;
    }

    part def WifiDriverVM_t :> Periodic_Rust_Thread {
        port wifiRecvIn: EventDataPort { in :>> type : Common::IncomingWifiMessage_Impl; }
        port wifiRecvOut: EventDataPort { out :>> type : Common::IncomingWifiMessage_Impl; }
        port wifiSendIn: EventDataPort { in :>> type : Common::OutgoingWifiMessage_Impl; }
        port wifiSendOut: EventDataPort { out :>> type : Common::OutgoingWifiMessage_Impl; }

        attribute :>> Compute_Execution_Time = 150 [ms] .. 150 [ms];
        attribute :>> Implementation_Language = C;
    }

    part def WifiDriver_t :> Periodic_Rust_Thread {
        port wifiRecv: EventDataPort { in :>> type : Common::IncomingWifiMessage_Impl; }
        port wifiSend: EventDataPort { out :>> type : Common::OutgoingWifiMessage_Impl; }
        port HMD_log: EventDataPort { out :>> type : Common::encryptedIncomingPayload_Impl; }
        port analysis_report: EventDataPort { in :>> type : Common::AnalysisReport_Impl; }
        port analysis_request: EventDataPort { out :>> type : Common::AnalysisRequest_Impl; }
        in port alert_in: EventPort;

        language "GUMBO" /*{
            state
                alert_cmd: Base_Types::Boolean;

            initialize
                modifies alert_cmd;

                guarantee defaultAlert:
                    alert_cmd == false;

            compute
                modifies alert_cmd;

                assume IncomingAlert "A: A report should not be received if an alert is received.":
                    HasEvent(alert_in) implies not HasEvent(analysis_report);

                assume Trusted_Report "A: Reports received are to a trusted destination.":
                    HasEvent(analysis_report) implies
                        MATRICS_Model_Transformations::GUMBO__Library::FOUND_IN_ALLOW_LIST(
                            analysis_report.header.client);

                guarantee alert_cmd_variable "G: Once an alert command is seen, always stay alerted.":
                    alert_cmd == (HasEvent(alert_in) or In(alert_cmd));

                guarantee Process_Report "G: Stop outgoing communication once an alert has been received.":
                    if (HasEvent(analysis_report) and not alert_cmd)?
                        MustSend(wifiSend)
                    else
                        NoSend(wifiSend);
        }*/
    }

    part def DataManager_t :> Periodic_Rust_Thread {
        port HMD_log: EventDataPort { in :>> type : Common::Log_Impl; }
        port request_log: EventDataPort { in :>> type : Common::Request_Impl; }
        port response_log: EventDataPort { out :>> type : Common::ResponseLog_Impl; }
        in port zeroize: EventPort;

        language "GUMBO" /*{
            state
                cache: Common::LogArray_Impl;
                zeroize_cmd: Base_Types::Boolean;

            functions
                def IS_ZEROIZED(logs: Common::LogArray_Impl): Base_Types::Boolean :=
                    (0 .. size(logs) - 1) -> forAll { in i;
                        MATRICS_Model_Transformations::GUMBO__Library::IS_NULL_LOG(
                            logs#(i))
                    };

            initialize
                modifies zeroize_cmd;

                guarantee defaultZeroize:
                    zeroize_cmd == false;

            compute
                modifies cache, zeroize_cmd;

                guarantee zeroize_cmd_variable "G: Once a zeroize command is seen, always zeroize.":
                    zeroize_cmd == (HasEvent(zeroize) or In(zeroize_cmd));

                guarantee Zeroize_Payload "G: Zeroize outgoing responses once an alert is received and when a request has been made.":
                    (zeroize_cmd and HasEvent(request_log)) implies
                        IS_ZEROIZED(response_log.payload);

                guarantee Zeroize_Cache "G: Zeroize cache once an alert is received.":
                    zeroize_cmd implies IS_ZEROIZED(cache);
        }*/
    }

    part def DataAnalysis_t :> Periodic_Rust_Thread {
        port request_log: EventDataPort { out :>> type : Common::Request_Impl; }
        port response_log: EventDataPort { in :>> type : Common::ResponseLog_Impl; }
        port analysis_report: EventDataPort { out :>> type : Common::AnalysisReport_Impl; }
        port analysis_request: EventDataPort { in :>> type : Common::AnalysisRequest_Impl; }

        language "GUMBO" /*{
            compute
                assume Trusted_Request "A: Requests received are from a trusted source.":
                    HasEvent(analysis_request) implies
                        MATRICS_Model_Transformations::GUMBO__Library::FOUND_IN_ALLOW_LIST(
                            analysis_request.header.client);
        }*/
    }

    part def BtDriver_t :> Periodic_Rust_Thread {
        port btRecv: EventDataPort { in :>> type : Common::DummyMessage_Impl; }
        port btSend: EventDataPort { out :>> type : Common::DummyMessage_Impl; }
    }

    part def UsbDriver_t :> Periodic_Rust_Thread {
        port usbRecv: EventDataPort { in :>> type : Common::DummyMessage_Impl; }
        port usbSend: EventDataPort { out :>> type : Common::DummyMessage_Impl; }
    }

    part def LogMonitor_t :> Periodic_Rust_Thread {
        port request_log: EventDataPort { in :>> type : Common::Request_Impl; }
        port response_log_in: EventDataPort { in :>> type : Common::ResponseLog_Impl; }
        port response_log_out: EventDataPort { out :>> type : Common::ResponseLog_Impl; }
        out port alert_out: EventPort;

        language "GUMBO" /*{
            state
                since_result: Base_Types::Boolean;
                is_valid: Base_Types::Boolean;
                historically_no_alert_cmd: Base_Types::Boolean;

            initialize
                modifies since_result, historically_no_alert_cmd;

                guarantee defaultSince:
                    since_result == false;

                guarantee defaultHistorically:
                    historically_no_alert_cmd == true;

            compute
                modifies since_result, is_valid, historically_no_alert_cmd;

                guarantee is_valid_variable "G: is_valid set correctly":
                    is_valid ==
                        (if (HasEvent(request_log) and HasEvent(response_log_in))?
                            true
                        else
                            (HasEvent(response_log_in) implies In(since_result)));

                guarantee since_result_variable "G: since_result is equivalent to (not response_log_in event) Since (request_log event)":
                    since_result == GUMBO_PLTL::GUMBO__Library::AGREE_Since(
                        not HasEvent(response_log_in),
                        HasEvent(request_log),
                        In(since_result));

                guarantee Send_Alert "G: Send an alert if more than one response is received without a request.":
                    if (HasEvent(response_log_in) and not is_valid)?
                        (MustSend(alert_out) & historically_no_alert_cmd == false)
                    else
                        (NoSend(alert_out) &
                         historically_no_alert_cmd == In(historically_no_alert_cmd));

                guarantee Forward_Response "G: Only forward a response if a valid request has been made.":
                    if (HasEvent(response_log_in) and historically_no_alert_cmd)?
                        (MustSend(response_log_out) & response_log_out == response_log_in)
                    else
                        NoSend(response_log_out);
        }*/
    }

    part def ReportMonitor_t :> Periodic_Rust_Thread {
        port analysis_request: EventDataPort { in :>> type : Common::AnalysisRequest_Impl; }
        port analysis_report_in: EventDataPort { in :>> type : Common::AnalysisReport_Impl; }
        port analysis_report_out: EventDataPort { out :>> type : Common::AnalysisReport_Impl; }
        out port alert_out: EventPort;

        language "GUMBO" /*{
            state
                counter: Base_Types::Unsigned_32;
                since_result: Base_Types::Boolean;
                is_valid1: Base_Types::Boolean;
                is_invalid2: Base_Types::Boolean;

            functions
                def Counter(i: Base_Types::Boolean,
                            reset: Base_Types::Boolean,
                            count: Base_Types::Unsigned_32): Base_Types::Unsigned_32 :=
                    if reset?
                        0 [u32]
                    else if i?
                        count + 1 [u32]
                    else
                        count;

            initialize
                modifies counter, since_result;

                guarantee defaultCounterAndSince:
                    counter == 0 [u32] &
                    since_result == false;

            compute
                modifies counter, since_result, is_valid1, is_invalid2;

                guarantee counter_variable "G: counter set correctly":
                    counter == Counter(HasEvent(analysis_request),
                                       HasEvent(analysis_report_in),
                                       In(counter));

                guarantee since_result_variable "G: Internal variable since_result is equivalent to (not analysis_report_in event) Since (analysis_request event)":
                    since_result == GUMBO_PLTL::GUMBO__Library::AGREE_Since(
                        not HasEvent(analysis_report_in),
                        HasEvent(analysis_request),
                        In(since_result));

                guarantee valid1 "G: is_valid1 set correctly":
                    is_valid1 ==
                        (if (HasEvent(analysis_request) and HasEvent(analysis_report_in))?
                            true
                        else
                            (HasEvent(analysis_report_in) implies In(since_result)));

                guarantee invalid2 "G: is_invalid2 set correctly":
                    is_invalid2 == (counter >= 3 [u32]);

                guarantee Send_Alert "G: Send an alert if more than one report is received without a request or if 3 or more requests are received without a report.":
                    if ((HasEvent(analysis_report_in) and not is_valid1) or is_invalid2)?
                        MustSend(alert_out)
                    else
                        NoSend(alert_out);

                guarantee Forward_Report "G: Only forward a report if a valid request has been made and it is to a trusted destination.":
                    if (HasEvent(analysis_report_in) and is_valid1 and
                        not is_invalid2 and
                        MATRICS_Model_Transformations::GUMBO__Library::FOUND_IN_ALLOW_LIST(
                            analysis_report_in.header.client))?
                        (MustSend(analysis_report_out) &
                         analysis_report_out == analysis_report_in)
                    else
                        NoSend(analysis_report_out);
        }*/
    }

    part def Decryptor_t :> Periodic_Rust_Thread {
        port HMD_log_in: EventDataPort { in :>> type : Common::encryptedIncomingPayload_Impl; }
        port HMD_log_out: EventDataPort { out :>> type : Common::Log_Impl; }

        language "GUMBO" /*{
            compute
                guarantee Payload_Decrypted "Type-level interpretation of the AGREE expression":
                    true;
        }*/
    }

    part def Encryptor_t :> Periodic_Rust_Thread {
        port analysis_report_in: EventDataPort { in :>> type : Common::AnalysisReport_Impl; }
        port analysis_report_out: EventDataPort { out :>> type : Common::AnalysisReport_Impl; }

        language "GUMBO" /*{
            compute
                guarantee Payload_Encrypted "G: Outgoing payload is encrypted.":
                    analysis_report_out.payload != analysis_report_in.payload;

                guarantee Header_Unencrypted "G: Outgoing header is not encrypted.":
                    analysis_report_out.header == analysis_report_in.header;
        }*/
    }

    part def Firewall_t :> Periodic_Rust_Thread {
        port analysis_request_in: EventDataPort { in :>> type : Common::AnalysisRequest_Impl; }
        port analysis_request_out: EventDataPort { out :>> type : Common::AnalysisRequest_Impl; }

        language "GUMBO" /*{
            compute
                guarantee Forward_Request "G: Only forward a request if it is from a trusted source.":
                    if (HasEvent(analysis_request_in) and
                        MATRICS_Model_Transformations::GUMBO__Library::FOUND_IN_ALLOW_LIST(
                            analysis_request_in.header.client))?
                        (MustSend(analysis_request_out) &
                         analysis_request_out == analysis_request_in)
                    else
                        NoSend(analysis_request_out);
        }*/
    }

    ///////////////////////////////////////////////////////////////////////
    // Process wrappers
    ///////////////////////////////////////////////////////////////////////

    part def WifiDriverVM_p :> Process {
        port wifiRecvIn: EventDataPort { in :>> type : Common::IncomingWifiMessage_Impl; }
        port wifiRecvOut: EventDataPort { out :>> type : Common::IncomingWifiMessage_Impl; }
        port wifiSendIn: EventDataPort { in :>> type : Common::OutgoingWifiMessage_Impl; }
        port wifiSendOut: EventDataPort { out :>> type : Common::OutgoingWifiMessage_Impl; }

        part wifiDriver: WifiDriverVM_t;

        connection c1: PortConnection connect wifiRecvIn to wifiDriver.wifiRecvIn;
        connection c2: PortConnection connect wifiDriver.wifiRecvOut to wifiRecvOut;
        connection c3: PortConnection connect wifiSendIn to wifiDriver.wifiSendIn;
        connection c4: PortConnection connect wifiDriver.wifiSendOut to wifiSendOut;

        attribute :>> Domain = 2;
    }

    part def WifiDriver_p :> Process {
        port wifiRecv: EventDataPort { in :>> type : Common::IncomingWifiMessage_Impl; }
        port wifiSend: EventDataPort { out :>> type : Common::OutgoingWifiMessage_Impl; }
        port HMD_log: EventDataPort { out :>> type : Common::encryptedIncomingPayload_Impl; }
        port analysis_report: EventDataPort { in :>> type : Common::AnalysisReport_Impl; }
        port analysis_request: EventDataPort { out :>> type : Common::AnalysisRequest_Impl; }
        in port 'alert': EventPort;

        part wifiDriver: WifiDriver_t;

        connection c1: PortConnection connect wifiRecv to wifiDriver.wifiRecv;
        connection c2: PortConnection connect analysis_report to wifiDriver.analysis_report;
        connection c3: PortConnection connect wifiDriver.wifiSend to wifiSend;
        connection c4: PortConnection connect wifiDriver.HMD_log to HMD_log;
        connection c5: PortConnection connect wifiDriver.analysis_request to analysis_request;
        connection c6: PortConnection connect 'alert' to wifiDriver.alert_in;

        attribute :>> Domain = 3;
    }

    part def Decryptor_p :> Process {
        port HMD_log_in: EventDataPort { in :>> type : Common::encryptedIncomingPayload_Impl; }
        port HMD_log_out: EventDataPort { out :>> type : Common::Log_Impl; }

        part decryptor: Decryptor_t;

        connection c1: PortConnection connect HMD_log_in to decryptor.HMD_log_in;
        connection c2: PortConnection connect decryptor.HMD_log_out to HMD_log_out;

        attribute :>> Domain = 4;
    }

    part def Firewall_p :> Process {
        port analysis_request_in: EventDataPort { in :>> type : Common::AnalysisRequest_Impl; }
        port analysis_request_out: EventDataPort { out :>> type : Common::AnalysisRequest_Impl; }

        part firewall: Firewall_t;

        connection c1: PortConnection connect analysis_request_in to firewall.analysis_request_in;
        connection c2: PortConnection connect firewall.analysis_request_out to analysis_request_out;

        attribute :>> Domain = 5;
    }

    part def DataAnalysis_p :> Process {
        port request_log: EventDataPort { out :>> type : Common::Request_Impl; }
        port response_log: EventDataPort { in :>> type : Common::ResponseLog_Impl; }
        port analysis_report: EventDataPort { out :>> type : Common::AnalysisReport_Impl; }
        port analysis_request: EventDataPort { in :>> type : Common::AnalysisRequest_Impl; }

        part dataAnalysis: DataAnalysis_t;

        connection c1: PortConnection connect response_log to dataAnalysis.response_log;
        connection c2: PortConnection connect analysis_request to dataAnalysis.analysis_request;
        connection c3: PortConnection connect dataAnalysis.request_log to request_log;
        connection c4: PortConnection connect dataAnalysis.analysis_report to analysis_report;

        attribute :>> Domain = 6;
    }

    part def DataManager_p :> Process {
        port HMD_log: EventDataPort { in :>> type : Common::Log_Impl; }
        port request_log: EventDataPort { in :>> type : Common::Request_Impl; }
        port response_log: EventDataPort { out :>> type : Common::ResponseLog_Impl; }
        in port zeroize: EventPort;

        part dataManager: DataManager_t;

        connection c1: PortConnection connect HMD_log to dataManager.HMD_log;
        connection c2: PortConnection connect request_log to dataManager.request_log;
        connection c3: PortConnection connect dataManager.response_log to response_log;
        connection c4: PortConnection connect zeroize to dataManager.zeroize;

        attribute :>> Domain = 7;
    }

    part def LogMonitor_p :> Process {
        port request_log: EventDataPort { in :>> type : Common::Request_Impl; }
        port response_log_in: EventDataPort { in :>> type : Common::ResponseLog_Impl; }
        port response_log_out: EventDataPort { out :>> type : Common::ResponseLog_Impl; }
        out port 'alert': EventPort;

        part logMonitor: LogMonitor_t;

        connection c1: PortConnection connect request_log to logMonitor.request_log;
        connection c2: PortConnection connect response_log_in to logMonitor.response_log_in;
        connection c3: PortConnection connect logMonitor.response_log_out to response_log_out;
        connection c4: PortConnection connect logMonitor.alert_out to 'alert';

        attribute :>> Domain = 8;
    }

    part def Encryptor_p :> Process {
        port analysis_report_in: EventDataPort { in :>> type : Common::AnalysisReport_Impl; }
        port analysis_report_out: EventDataPort { out :>> type : Common::AnalysisReport_Impl; }

        part encryptor: Encryptor_t;

        connection c1: PortConnection connect analysis_report_in to encryptor.analysis_report_in;
        connection c2: PortConnection connect encryptor.analysis_report_out to analysis_report_out;

        attribute :>> Domain = 9;
    }

    part def ReportMonitor_p :> Process {
        port analysis_request: EventDataPort { in :>> type : Common::AnalysisRequest_Impl; }
        port analysis_report_in: EventDataPort { in :>> type : Common::AnalysisReport_Impl; }
        port analysis_report_out: EventDataPort { out :>> type : Common::AnalysisReport_Impl; }
        out port 'alert': EventPort;

        part reportMonitor: ReportMonitor_t;

        connection c1: PortConnection connect analysis_request to reportMonitor.analysis_request;
        connection c2: PortConnection connect analysis_report_in to reportMonitor.analysis_report_in;
        connection c3: PortConnection connect reportMonitor.analysis_report_out to analysis_report_out;
        connection c4: PortConnection connect reportMonitor.alert_out to 'alert';

        attribute :>> Domain = 10;
    }

    part def BtDriver_p :> Process {
        port btRecv: EventDataPort { in :>> type : Common::DummyMessage_Impl; }
        port btSend: EventDataPort { out :>> type : Common::DummyMessage_Impl; }

        part btDriver: BtDriver_t;

        connection c1: PortConnection connect btRecv to btDriver.btRecv;
        connection c2: PortConnection connect btDriver.btSend to btSend;

        attribute :>> Domain = 11;
    }

    part def UsbDriver_p :> Process {
        port usbRecv: EventDataPort { in :>> type : Common::DummyMessage_Impl; }
        port usbSend: EventDataPort { out :>> type : Common::DummyMessage_Impl; }

        part usbDriver: UsbDriver_t;

        connection c1: PortConnection connect usbRecv to usbDriver.usbRecv;
        connection c2: PortConnection connect usbDriver.usbSend to usbSend;

        attribute :>> Domain = 12;
    }

    ///////////////////////////////////////////////////////////////////////
    // Hardened software composition
    ///////////////////////////////////////////////////////////////////////

    part def WifiDriver_sys :> System {
        port wifiRecv: EventDataPort { in :>> type : Common::IncomingWifiMessage_Impl; }
        port wifiSend: EventDataPort { out :>> type : Common::OutgoingWifiMessage_Impl; }
        port HMD_log: EventDataPort { out :>> type : Common::encryptedIncomingPayload_Impl; }
        port analysis_report: EventDataPort { in :>> type : Common::AnalysisReport_Impl; }
        port analysis_request: EventDataPort { out :>> type : Common::AnalysisRequest_Impl; }
        in port 'alert': EventPort;

        part wifiDriver: WifiDriver_p;
        part wifiDriverVM: WifiDriverVM_p;

        connection c1: PortConnection connect wifiRecv to wifiDriverVM.wifiRecvIn;
        connection c2: PortConnection connect wifiDriverVM.wifiRecvOut to wifiDriver.wifiRecv;
        connection c3: PortConnection connect wifiDriver.wifiSend to wifiDriverVM.wifiSendIn;
        connection c4: PortConnection connect wifiDriverVM.wifiSendOut to wifiSend;
        connection c5: PortConnection connect wifiDriver.HMD_log to HMD_log;
        connection c6: PortConnection connect analysis_report to wifiDriver.analysis_report;
        connection c7: PortConnection connect wifiDriver.analysis_request to analysis_request;
        connection c8: PortConnection connect 'alert' to wifiDriver.'alert';
    }

    part def SW_seL4_hardened :> System {
        port wifiRecv: EventDataPort { in :>> type : Common::IncomingWifiMessage_Impl; }
        port wifiSend: EventDataPort { out :>> type : Common::OutgoingWifiMessage_Impl; }
        port btRecv: EventDataPort { in :>> type : Common::DummyMessage_Impl; }
        port btSend: EventDataPort { out :>> type : Common::DummyMessage_Impl; }
        port usbRecv: EventDataPort { in :>> type : Common::DummyMessage_Impl; }
        port usbSend: EventDataPort { out :>> type : Common::DummyMessage_Impl; }

        part wifiDriver: WifiDriver_sys;
        part btDriver: BtDriver_p;
        part usbDriver: UsbDriver_p;
        part dataManager: DataManager_p;
        part dataAnalysis: DataAnalysis_p;
        part decryptor: Decryptor_p;
        part encryptor: Encryptor_p;
        part logMonitor: LogMonitor_p;
        part reportMonitor: ReportMonitor_p;
        part firewall: Firewall_p;

        connection c1: PortConnection connect wifiRecv to wifiDriver.wifiRecv;
        connection c2: PortConnection connect wifiDriver.wifiSend to wifiSend;
        connection c5: PortConnection connect btRecv to btDriver.btRecv;
        connection c6: PortConnection connect btDriver.btSend to btSend;
        connection c7: PortConnection connect usbRecv to usbDriver.usbRecv;
        connection c8: PortConnection connect usbDriver.usbSend to usbSend;

        connection c9: PortConnection connect dataAnalysis.request_log to dataManager.request_log;
        connection c10: PortConnection connect wifiDriver.HMD_log to decryptor.HMD_log_in;
        connection c11: PortConnection connect decryptor.HMD_log_out to dataManager.HMD_log;
        connection c12: PortConnection connect dataAnalysis.analysis_report to encryptor.analysis_report_in;
        connection c13: PortConnection connect reportMonitor.analysis_report_out to wifiDriver.analysis_report;
        connection c14: PortConnection connect dataAnalysis.request_log to logMonitor.request_log;
        connection c15: PortConnection connect dataManager.response_log to logMonitor.response_log_in;
        connection c16: PortConnection connect logMonitor.response_log_out to dataAnalysis.response_log;
        connection c17: PortConnection connect logMonitor.'alert' to dataManager.zeroize;
        connection c18: PortConnection connect wifiDriver.analysis_request to reportMonitor.analysis_request;
        connection c19: PortConnection connect encryptor.analysis_report_out to reportMonitor.analysis_report_in;
        connection c20: PortConnection connect reportMonitor.'alert' to wifiDriver.'alert';
        connection c21: PortConnection connect wifiDriver.analysis_request to firewall.analysis_request_in;
        connection c22: PortConnection connect firewall.analysis_request_out to dataAnalysis.analysis_request;
    }

    ///////////////////////////////////////////////////////////////////////
    // HAMR code-generation root (GroundStation::GroundStation_Impl)
    ///////////////////////////////////////////////////////////////////////

    part def Proc :> Processor {
        attribute :>> Frame_Period = 1000 [ms];
        attribute :>> Clock_Period = 1 [ms];
        attribute :>> Max_Domain = 15;
    }

    part def virt_proc :> VirtualProcessor;

    part def GroundStation_Impl :> System {
        port wifiRecv: EventDataPort { in :>> type : Common::IncomingWifiMessage_Impl; }
        port wifiSend: EventDataPort { out :>> type : Common::OutgoingWifiMessage_Impl; }
        port btRecv: EventDataPort { in :>> type : Common::DummyMessage_Impl; }
        port btSend: EventDataPort { out :>> type : Common::DummyMessage_Impl; }
        port usbRecv: EventDataPort { in :>> type : Common::DummyMessage_Impl; }
        port usbSend: EventDataPort { out :>> type : Common::DummyMessage_Impl; }

        part cpu: Proc;
        part vcpu: virt_proc;

        // HAMR requires a flat SysML architecture. These usage names retain
        // the cpuSw_ prefixes in generated component names.
        part cpuSw_wifiDriver_wifiDriver: WifiDriver_p;
        part cpuSw_wifiDriver_wifiDriverVM: WifiDriverVM_p;
        part cpuSw_btDriver: BtDriver_p;
        part cpuSw_usbDriver: UsbDriver_p;
        part cpuSw_dataManager: DataManager_p;
        part cpuSw_dataAnalysis: DataAnalysis_p;
        part cpuSw_decryptor: Decryptor_p;
        part cpuSw_encryptor: Encryptor_p;
        part cpuSw_logMonitor: LogMonitor_p;
        part cpuSw_reportMonitor: ReportMonitor_p;
        part cpuSw_firewall: Firewall_p;

        // Wi-Fi traffic crosses the C-based VM boundary in both directions.
        connection c1: PortConnection connect wifiRecv to cpuSw_wifiDriver_wifiDriverVM.wifiRecvIn;
        connection c2: PortConnection connect cpuSw_wifiDriver_wifiDriverVM.wifiRecvOut to cpuSw_wifiDriver_wifiDriver.wifiRecv;
        connection c3: PortConnection connect cpuSw_wifiDriver_wifiDriver.wifiSend to cpuSw_wifiDriver_wifiDriverVM.wifiSendIn;
        connection c4: PortConnection connect cpuSw_wifiDriver_wifiDriverVM.wifiSendOut to wifiSend;

        connection c5: PortConnection connect btRecv to cpuSw_btDriver.btRecv;
        connection c6: PortConnection connect cpuSw_btDriver.btSend to btSend;
        connection c7: PortConnection connect usbRecv to cpuSw_usbDriver.usbRecv;
        connection c8: PortConnection connect cpuSw_usbDriver.usbSend to usbSend;

        connection c9: PortConnection connect cpuSw_dataAnalysis.request_log to cpuSw_dataManager.request_log;
        connection c10: PortConnection connect cpuSw_wifiDriver_wifiDriver.HMD_log to cpuSw_decryptor.HMD_log_in;
        connection c11: PortConnection connect cpuSw_decryptor.HMD_log_out to cpuSw_dataManager.HMD_log;
        connection c12: PortConnection connect cpuSw_dataAnalysis.analysis_report to cpuSw_encryptor.analysis_report_in;
        connection c13: PortConnection connect cpuSw_reportMonitor.analysis_report_out to cpuSw_wifiDriver_wifiDriver.analysis_report;
        connection c14: PortConnection connect cpuSw_dataAnalysis.request_log to cpuSw_logMonitor.request_log;
        connection c15: PortConnection connect cpuSw_dataManager.response_log to cpuSw_logMonitor.response_log_in;
        connection c16: PortConnection connect cpuSw_logMonitor.response_log_out to cpuSw_dataAnalysis.response_log;
        connection c17: PortConnection connect cpuSw_logMonitor.'alert' to cpuSw_dataManager.zeroize;
        connection c18: PortConnection connect cpuSw_wifiDriver_wifiDriver.analysis_request to cpuSw_reportMonitor.analysis_request;
        connection c19: PortConnection connect cpuSw_encryptor.analysis_report_out to cpuSw_reportMonitor.analysis_report_in;
        connection c20: PortConnection connect cpuSw_reportMonitor.'alert' to cpuSw_wifiDriver_wifiDriver.'alert';
        connection c21: PortConnection connect cpuSw_wifiDriver_wifiDriver.analysis_request to cpuSw_firewall.analysis_request_in;
        connection c22: PortConnection connect cpuSw_firewall.analysis_request_out to cpuSw_dataAnalysis.analysis_request;

        allocation vm_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_wifiDriver_wifiDriverVM to vcpu;

        allocation vcpu_binding: Deployment_Properties::Actual_Processor_Binding
            allocate vcpu to cpu;

        allocation wifi_driver_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_wifiDriver_wifiDriver to cpu;
        allocation bt_driver_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_btDriver to cpu;
        allocation usb_driver_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_usbDriver to cpu;
        allocation data_manager_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_dataManager to cpu;
        allocation data_analysis_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_dataAnalysis to cpu;
        allocation decryptor_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_decryptor to cpu;
        allocation encryptor_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_encryptor to cpu;
        allocation log_monitor_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_logMonitor to cpu;
        allocation report_monitor_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_reportMonitor to cpu;
        allocation firewall_binding: Deployment_Properties::Actual_Processor_Binding
            allocate cpuSw_firewall to cpu;

        attribute :>> Scheduling = MCS;

        language "GUMBO" /*{
            functions
                def IS_ZEROIZED(logs: Common::LogArray_Impl): Base_Types::Boolean :=
                    (0 .. size(logs) - 1) -> forAll { in i;
                        MATRICS_Model_Transformations::GUMBO__Library::IS_NULL_LOG(
                            logs#(i))
                    };

            composition agree_ground_truth {
                components
                    wifi_vm = cpuSw_wifiDriver_wifiDriverVM.wifiDriver;
                    wifi = cpuSw_wifiDriver_wifiDriver.wifiDriver;
                    decryptor = cpuSw_decryptor.decryptor;
                    firewall = cpuSw_firewall.firewall;
                    data_analysis = cpuSw_dataAnalysis.dataAnalysis;
                    data_manager = cpuSw_dataManager.dataManager;
                    log_monitor = cpuSw_logMonitor.logMonitor;
                    encryptor = cpuSw_encryptor.encryptor;
                    report_monitor = cpuSw_reportMonitor.reportMonitor;
                    bt_driver = cpuSw_btDriver.btDriver;
                    usb_driver = cpuSw_usbDriver.usbDriver;

                ports
                    firewall_request_out = firewall.analysis_request_out;
                    report_out = report_monitor.analysis_report_out;
                    report_in = report_monitor.analysis_report_in;
                    report_alert = report_monitor.alert_out;
                    wifi_send = wifi.wifiSend;
                    data_manager_request = data_manager.request_log;
                    data_manager_response = data_manager.response_log;
                    log_response_out = log_monitor.response_log_out;

                state
                    wifi_alert_cmd = wifi.alert_cmd;
                    data_manager_zeroize_cmd = data_manager.zeroize_cmd;
                    data_manager_cache = data_manager.cache;
                    log_historically_no_alert = log_monitor.historically_no_alert_cmd;

                schema {
                    wifi_vm;
                    wifi;
                    decryptor;
                    firewall;
                    data_analysis;
                    data_manager;
                    log_monitor;
                    encryptor;
                    report_monitor;
                    bt_driver;
                    usb_driver
                }

                property Firewall_Discharges_Trusted_Request
                    "The firewall establishes DataAnalysis.Trusted_Request" {

                    after firewall:
                        HasEvent(firewall_request_out) implies
                            MATRICS_Model_Transformations::GUMBO__Library::FOUND_IN_ALLOW_LIST(
                                firewall_request_out.header.client);

                    after data_analysis:
                        true;
                }

                property ReportMonitor_Establishes_Wifi_Assumptions
                    "The report monitor establishes both Wi-Fi assumptions for the next scheduled frame" {

                    after report_monitor:
                        (HasEvent(report_alert) implies not HasEvent(report_out)) &
                        (HasEvent(report_out) implies
                            MATRICS_Model_Transformations::GUMBO__Library::FOUND_IN_ALLOW_LIST(
                                report_out.header.client));

                    after bt_driver:
                        (HasEvent(report_alert) implies not HasEvent(report_out)) &
                        (HasEvent(report_out) implies
                            MATRICS_Model_Transformations::GUMBO__Library::FOUND_IN_ALLOW_LIST(
                                report_out.header.client));

                    after usb_driver:
                        (HasEvent(report_alert) implies not HasEvent(report_out)) &
                        (HasEvent(report_out) implies
                            MATRICS_Model_Transformations::GUMBO__Library::FOUND_IN_ALLOW_LIST(
                                report_out.header.client));

                    at END:
                        (HasEvent(report_alert) implies not HasEvent(report_out)) &
                        (HasEvent(report_out) implies
                            MATRICS_Model_Transformations::GUMBO__Library::FOUND_IN_ALLOW_LIST(
                                report_out.header.client));
                }

                property DataManager_Zeroization_Invariant
                    "A latched zeroize command keeps cache and requested response payloads zeroized" {

                    at START:
                        data_manager_zeroize_cmd implies
                            IS_ZEROIZED(data_manager_cache);

                    after data_manager:
                        (data_manager_zeroize_cmd implies
                            IS_ZEROIZED(data_manager_cache)) &
                        ((data_manager_zeroize_cmd and HasEvent(data_manager_request)) implies
                            IS_ZEROIZED(data_manager_response.payload));

                    after log_monitor:
                        data_manager_zeroize_cmd implies
                            IS_ZEROIZED(data_manager_cache);

                    after encryptor:
                        data_manager_zeroize_cmd implies
                            IS_ZEROIZED(data_manager_cache);

                    after report_monitor:
                        data_manager_zeroize_cmd implies
                            IS_ZEROIZED(data_manager_cache);

                    after bt_driver:
                        data_manager_zeroize_cmd implies
                            IS_ZEROIZED(data_manager_cache);

                    after usb_driver:
                        data_manager_zeroize_cmd implies
                            IS_ZEROIZED(data_manager_cache);

                    at END:
                        data_manager_zeroize_cmd implies
                            IS_ZEROIZED(data_manager_cache);
                }

                property LogMonitor_No_Forward_After_Alert
                    "Once log-monitor history records an alert, responses are not forwarded" {

                    after log_monitor:
                        not log_historically_no_alert implies
                            not HasEvent(log_response_out);
                }

            }
        }*/
    }

}
