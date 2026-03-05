# GroundStation::GroundStation.Impl

## AADL Architecture
|System: [GroundStation::GroundStation.Impl]()|
|:--|

|Thread: GroundStation::wifiDriver |
|:--|
|Implementation: [wifiDriver](../../GroundStation.aadl#L44)|
|Periodic |

|Thread: GroundStation::btDriver |
|:--|
|Implementation: [btDriver](../../GroundStation.aadl#L121)|
|Periodic |

|Thread: GroundStation::usbDriver |
|:--|
|Implementation: [usbDriver](../../GroundStation.aadl#L133)|
|Periodic |

|Thread: GroundStation::dataManager |
|:--|
|Implementation: [dataManager](../../GroundStation.aadl#L74)|
|Periodic |

|Thread: GroundStation::dataAnalysis |
|:--|
|Implementation: [dataAnalysis](../../GroundStation.aadl#L102)|
|Periodic |

|Thread: Hardened_SW::decryptor |
|:--|
|Implementation: [decryptor](../../Hardened_SW.aadl#L292)|
|Periodic |

|Thread: Hardened_SW::encryptor |
|:--|
|Implementation: [encryptor](../../Hardened_SW.aadl#L333)|
|Periodic |

|Thread: Hardened_SW::logMonitor |
|:--|
|Implementation: [logMonitor](../../Hardened_SW.aadl#L157)|
|Periodic |

|Thread: Hardened_SW::reportMonitor |
|:--|
|Implementation: [reportMonitor](../../Hardened_SW.aadl#L218)|
|Periodic |

|Thread: Hardened_SW::firewall |
|:--|
|Implementation: [firewall](../../Hardened_SW.aadl#L375)|
|Periodic |


## Rust Code


### Behavior Code
#### wifiDriver: GroundStation::wifiDriver

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_wifiDriver_wifiDriver/src/component/cpuSw_wifiDriver_wifiDriver_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_wifiDriver_wifiDriver/src/component/cpuSw_wifiDriver_wifiDriver_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L47'>wifiRecv</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Memory Map: Lines 21-25' href='microkit.system#L21'>Memory Map</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L11'>C var_addr</a> → <a title='C Interface: Lines 41-44' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L41'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 22-32' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L22'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 38-45' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L38'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 127-138' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L127'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L50'>analysis_report</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Memory Map: Lines 31-35' href='microkit.system#L31'>Memory Map</a> → <a title='C Shared Memory Variable: Line 14' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L14'>C var_addr</a> → <a title='C Interface: Lines 60-63' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L60'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 34-44' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L34'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 48-55' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L48'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 139-150' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L139'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L52'>alert</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Memory Map: Lines 36-40' href='microkit.system#L36'>Memory Map</a> → <a title='C Shared Memory Variable: Line 16' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L16'>C var_addr</a> → <a title='C Interface: Lines 73-76' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L73'>C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='Rust/C Interface: Lines 46-56' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L46'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 58-65' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L58'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 151-162' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L151'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L48'>wifiSend</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Rust/Verus API: Lines 82-95' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L82'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 58-63' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L58'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 46-50' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L46'>C Interface</a> → <a title='C Shared Memory Variable: Line 13' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L13'>C var_addr</a> → <a title='Memory Map: Lines 26-30' href='microkit.system#L26'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L49'>HMD_log</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::Log.Impl</td><td><a title='Rust/Verus API: Lines 96-109' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L96'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 20-25' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L20'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 65-70' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L65'>Rust/C Interface</a> → <a title='C Extern: Line 18' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L18'>C Extern</a> → <a title='C Interface: Lines 21-25' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L21'>C Interface</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L9'>C var_addr</a> → <a title='Memory Map: Lines 11-15' href='microkit.system#L11'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L51'>analysis_request</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Rust/Verus API: Lines 110-123' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L110'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 28-33' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_api.rs#L28'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 72-77' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L72'>Rust/C Interface</a> → <a title='C Extern: Line 19' href='crates/cpuSw_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L19'>C Extern</a> → <a title='C Interface: Lines 27-31' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L27'>C Interface</a> → <a title='C Shared Memory Variable: Line 10' href='components/cpuSw_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver.c#L10'>C var_addr</a> → <a title='Memory Map: Lines 16-20' href='microkit.system#L16'>Memory Map</a></td></tr>
    </table>


#### btDriver: GroundStation::btDriver

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_btDriver_btDriver/src/component/cpuSw_btDriver_btDriver_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_btDriver_btDriver/src/component/cpuSw_btDriver_btDriver_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L124'>btRecv</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Memory Map: Lines 54-58' href='microkit.system#L54'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_btDriver_btDriver/src/cpuSw_btDriver_btDriver.c#L9'>C var_addr</a> → <a title='C Interface: Lines 23-26' href='components/cpuSw_btDriver_btDriver/src/cpuSw_btDriver_btDriver.c#L23'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_btDriver_btDriver/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_btDriver_btDriver/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_btDriver_btDriver/src/bridge/cpuSw_btDriver_btDriver_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_btDriver_btDriver/src/bridge/cpuSw_btDriver_btDriver_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L125'>btSend</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_btDriver_btDriver/src/bridge/cpuSw_btDriver_btDriver_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_btDriver_btDriver/src/bridge/cpuSw_btDriver_btDriver_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_btDriver_btDriver/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_btDriver_btDriver/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 28-32' href='components/cpuSw_btDriver_btDriver/src/cpuSw_btDriver_btDriver.c#L28'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_btDriver_btDriver/src/cpuSw_btDriver_btDriver.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 59-63' href='microkit.system#L59'>Memory Map</a></td></tr>
    </table>


#### usbDriver: GroundStation::usbDriver

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_usbDriver_usbDriver/src/component/cpuSw_usbDriver_usbDriver_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_usbDriver_usbDriver/src/component/cpuSw_usbDriver_usbDriver_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L136'>usbRecv</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Memory Map: Lines 77-81' href='microkit.system#L77'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_usbDriver_usbDriver/src/cpuSw_usbDriver_usbDriver.c#L9'>C var_addr</a> → <a title='C Interface: Lines 23-26' href='components/cpuSw_usbDriver_usbDriver/src/cpuSw_usbDriver_usbDriver.c#L23'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/cpuSw_usbDriver_usbDriver_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/cpuSw_usbDriver_usbDriver_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L137'>usbSend</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/cpuSw_usbDriver_usbDriver_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/cpuSw_usbDriver_usbDriver_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 28-32' href='components/cpuSw_usbDriver_usbDriver/src/cpuSw_usbDriver_usbDriver.c#L28'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_usbDriver_usbDriver/src/cpuSw_usbDriver_usbDriver.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 82-86' href='microkit.system#L82'>Memory Map</a></td></tr>
    </table>


#### dataManager: GroundStation::dataManager

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L77'>HMD_log</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::Log.Impl</td><td><a title='Memory Map: Lines 110-114' href='microkit.system#L110'>Memory Map</a> → <a title='C Shared Memory Variable: Line 12' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L12'>C var_addr</a> → <a title='C Interface: Lines 46-49' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L46'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 20-30' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L20'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 77-86' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L77'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L78'>request_log</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::Request.Impl</td><td><a title='Memory Map: Lines 105-109' href='microkit.system#L105'>Memory Map</a> → <a title='C Shared Memory Variable: Line 10' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L10'>C var_addr</a> → <a title='C Interface: Lines 33-36' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L33'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 32-42' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L32'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 32-39' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L32'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 87-96' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L87'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L80'>zeroize</a></td>
        <td>In</td><td>Event</td>
        <td></td><td><a title='Memory Map: Lines 115-119' href='microkit.system#L115'>Memory Map</a> → <a title='C Shared Memory Variable: Line 14' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L14'>C var_addr</a> → <a title='C Interface: Lines 61-64' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L61'>C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='Rust/C Interface: Lines 44-49' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L44'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 42-47' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L42'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 97-106' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L97'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L79'>response_log</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::ResponseLog.Impl</td><td><a title='Rust/Verus API: Lines 62-73' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L62'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 51-56' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L51'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 19-23' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L19'>C Interface</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L9'>C var_addr</a> → <a title='Memory Map: Lines 100-104' href='microkit.system#L100'>Memory Map</a></td></tr>
    </table>


#### dataAnalysis: GroundStation::dataAnalysis

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_dataAnalysis_dataAnalysis/src/component/cpuSw_dataAnalysis_dataAnalysis_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_dataAnalysis_dataAnalysis/src/component/cpuSw_dataAnalysis_dataAnalysis_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L106'>response_log</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::ResponseLog.Impl</td><td><a title='Memory Map: Lines 143-147' href='microkit.system#L143'>Memory Map</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L11'>C var_addr</a> → <a title='C Interface: Lines 38-41' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L38'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 20-30' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L20'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 30-37' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L30'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 89-98' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L89'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L108'>analysis_request</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Memory Map: Lines 148-152' href='microkit.system#L148'>Memory Map</a> → <a title='C Shared Memory Variable: Line 13' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L13'>C var_addr</a> → <a title='C Interface: Lines 51-54' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L51'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 32-42' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L32'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 40-47' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L40'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 99-108' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L99'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L105'>request_log</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::Request.Impl</td><td><a title='Rust/Verus API: Lines 62-73' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L62'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 44-49' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L44'>Rust/C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='C Interface: Lines 18-22' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L18'>C Interface</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L9'>C var_addr</a> → <a title='Memory Map: Lines 133-137' href='microkit.system#L133'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L107'>analysis_report</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Rust/Verus API: Lines 74-85' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L74'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 20-25' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L20'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 51-56' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L51'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 24-28' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L24'>C Interface</a> → <a title='C Shared Memory Variable: Line 10' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L10'>C var_addr</a> → <a title='Memory Map: Lines 138-142' href='microkit.system#L138'>Memory Map</a></td></tr>
    </table>


#### decryptor: Hardened_SW::decryptor

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_decryptor_decryptor/src/component/cpuSw_decryptor_decryptor_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_decryptor_decryptor/src/component/cpuSw_decryptor_decryptor_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L295'>HMD_log_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::Log.Impl</td><td><a title='Memory Map: Lines 166-170' href='microkit.system#L166'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_decryptor_decryptor/src/cpuSw_decryptor_decryptor.c#L9'>C var_addr</a> → <a title='C Interface: Lines 23-26' href='components/cpuSw_decryptor_decryptor/src/cpuSw_decryptor_decryptor.c#L23'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_decryptor_decryptor/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_decryptor_decryptor/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_decryptor_decryptor/src/bridge/cpuSw_decryptor_decryptor_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_decryptor_decryptor/src/bridge/cpuSw_decryptor_decryptor_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L296'>HMD_log_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::Log.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_decryptor_decryptor/src/bridge/cpuSw_decryptor_decryptor_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_decryptor_decryptor/src/bridge/cpuSw_decryptor_decryptor_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_decryptor_decryptor/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_decryptor_decryptor/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 28-32' href='components/cpuSw_decryptor_decryptor/src/cpuSw_decryptor_decryptor.c#L28'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_decryptor_decryptor/src/cpuSw_decryptor_decryptor.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 171-175' href='microkit.system#L171'>Memory Map</a></td></tr>
    </table>


#### encryptor: Hardened_SW::encryptor

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_encryptor_encryptor/src/component/cpuSw_encryptor_encryptor_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_encryptor_encryptor/src/component/cpuSw_encryptor_encryptor_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L336'>analysis_report_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Memory Map: Lines 189-193' href='microkit.system#L189'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_encryptor_encryptor/src/cpuSw_encryptor_encryptor.c#L9'>C var_addr</a> → <a title='C Interface: Lines 23-26' href='components/cpuSw_encryptor_encryptor/src/cpuSw_encryptor_encryptor.c#L23'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_encryptor_encryptor/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_encryptor_encryptor/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L337'>analysis_report_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_encryptor_encryptor/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_encryptor_encryptor/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 28-32' href='components/cpuSw_encryptor_encryptor/src/cpuSw_encryptor_encryptor.c#L28'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_encryptor_encryptor/src/cpuSw_encryptor_encryptor.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 194-198' href='microkit.system#L194'>Memory Map</a></td></tr>
    </table>


#### logMonitor: Hardened_SW::logMonitor

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L160'>request_log</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::Request.Impl</td><td><a title='Memory Map: Lines 217-221' href='microkit.system#L217'>Memory Map</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L11'>C var_addr</a> → <a title='C Interface: Lines 39-42' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L39'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 20-30' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L20'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 28-35' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L28'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 87-96' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L87'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L161'>response_log_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::ResponseLog.Impl</td><td><a title='Memory Map: Lines 212-216' href='microkit.system#L212'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L9'>C var_addr</a> → <a title='C Interface: Lines 26-29' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L26'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 32-42' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L32'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 38-45' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L38'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 97-106' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L97'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L162'>response_log_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::ResponseLog.Impl</td><td><a title='Rust/Verus API: Lines 60-71' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L60'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 44-49' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L44'>Rust/C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='C Interface: Lines 44-48' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L44'>C Interface</a> → <a title='C Shared Memory Variable: Line 13' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L13'>C var_addr</a> → <a title='Memory Map: Lines 222-226' href='microkit.system#L222'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L163'>alert</a></td>
        <td>Out</td><td>Event</td>
        <td></td><td><a title='Rust/Verus API: Lines 72-83' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L72'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 20-23' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L20'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 51-56' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L51'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 50-56' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L50'>C Interface</a> → <a title='C Shared Memory Variable: Line 14' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L14'>C var_addr</a> → <a title='Memory Map: Lines 227-231' href='microkit.system#L227'>Memory Map</a></td></tr>
    </table>


#### reportMonitor: Hardened_SW::reportMonitor

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L221'>analysis_request</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Memory Map: Lines 245-249' href='microkit.system#L245'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L9'>C var_addr</a> → <a title='C Interface: Lines 26-29' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L26'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 20-30' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L20'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 30-37' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L30'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 89-98' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L89'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L222'>analysis_report_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Memory Map: Lines 250-254' href='microkit.system#L250'>Memory Map</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L11'>C var_addr</a> → <a title='C Interface: Lines 39-42' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L39'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 32-42' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L32'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 40-47' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L40'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 99-108' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L99'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L223'>analysis_report_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Rust/Verus API: Lines 62-73' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L62'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 44-49' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L44'>Rust/C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='C Interface: Lines 44-48' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L44'>C Interface</a> → <a title='C Shared Memory Variable: Line 13' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L13'>C var_addr</a> → <a title='Memory Map: Lines 255-259' href='microkit.system#L255'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L224'>alert</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Rust/Verus API: Lines 74-85' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L74'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 20-25' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L20'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 51-56' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L51'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 50-54' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L50'>C Interface</a> → <a title='C Shared Memory Variable: Line 14' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L14'>C var_addr</a> → <a title='Memory Map: Lines 260-264' href='microkit.system#L260'>Memory Map</a></td></tr>
    </table>


#### firewall: Hardened_SW::firewall

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_firewall_firewall/src/component/cpuSw_firewall_firewall_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_firewall_firewall/src/component/cpuSw_firewall_firewall_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L378'>analysis_request_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Memory Map: Lines 278-282' href='microkit.system#L278'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_firewall_firewall/src/cpuSw_firewall_firewall.c#L9'>C var_addr</a> → <a title='C Interface: Lines 23-26' href='components/cpuSw_firewall_firewall/src/cpuSw_firewall_firewall.c#L23'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_firewall_firewall/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_firewall_firewall/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L379'>analysis_request_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_firewall_firewall/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_firewall_firewall/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 28-32' href='components/cpuSw_firewall_firewall/src/cpuSw_firewall_firewall.c#L28'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_firewall_firewall/src/cpuSw_firewall_firewall.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 283-287' href='microkit.system#L283'>Memory Map</a></td></tr>
    </table>

