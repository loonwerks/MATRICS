# GroundStation::GroundStation.Impl

## AADL Architecture
|System: [GroundStation::GroundStation.Impl]()|
|:--|

|Thread: GroundStation::btDriver |
|:--|
|Implementation: [btDriver](../../GroundStation.aadl#L179)|
|Periodic |

|Thread: GroundStation::usbDriver |
|:--|
|Implementation: [usbDriver](../../GroundStation.aadl#L191)|
|Periodic |

|Thread: GroundStation::dataManager |
|:--|
|Implementation: [dataManager](../../GroundStation.aadl#L99)<br>
GUMBO: [Subclause](../../GroundStation.aadl#L126)|
|Periodic |

|Thread: GroundStation::dataAnalysis |
|:--|
|Implementation: [dataAnalysis](../../GroundStation.aadl#L160)|
|Periodic |

|Thread: Hardened_SW::decryptor |
|:--|
|Implementation: [decryptor](../../Hardened_SW.aadl#L428)<br>
GUMBO: [Subclause](../../Hardened_SW.aadl#L443)|
|Periodic |

|Thread: Hardened_SW::encryptor |
|:--|
|Implementation: [encryptor](../../Hardened_SW.aadl#L474)<br>
GUMBO: [Subclause](../../Hardened_SW.aadl#L491)|
|Periodic |

|Thread: Hardened_SW::logMonitor |
|:--|
|Implementation: [logMonitor](../../Hardened_SW.aadl#L202)<br>
GUMBO: [Subclause](../../Hardened_SW.aadl#L238)|
|Periodic |

|Thread: Hardened_SW::reportMonitor |
|:--|
|Implementation: [reportMonitor](../../Hardened_SW.aadl#L303)<br>
GUMBO: [Subclause](../../Hardened_SW.aadl#L346)|
|Periodic |

|Thread: Hardened_SW::firewall |
|:--|
|Implementation: [firewall](../../Hardened_SW.aadl#L523)<br>
GUMBO: [Subclause](../../Hardened_SW.aadl#L540)|
|Periodic |

|Thread: GroundStation::wifiDriver |
|:--|
|Implementation: [wifiDriver](../../GroundStation.aadl#L49)<br>
GUMBO: [Subclause](../../GroundStation.aadl#L78)|
|Periodic |

|Thread: Hardened_SW::wifiDriverVM |
|:--|
|Implementation: [wifiDriverVM](../../Hardened_SW.aadl#L17)|
|Periodic : 150 ms|


## Rust Code


### Behavior Code
#### btDriver: GroundStation::btDriver

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_btDriver_btDriver/src/component/cpuSw_btDriver_btDriver_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_btDriver_btDriver/src/component/cpuSw_btDriver_btDriver_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L182'>btRecv</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Memory Map: Lines 11-15' href='microkit.system#L11'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_btDriver_btDriver/src/cpuSw_btDriver_btDriver.c#L9'>C var_addr</a> → <a title='C Interface: Lines 23-26' href='components/cpuSw_btDriver_btDriver/src/cpuSw_btDriver_btDriver.c#L23'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_btDriver_btDriver/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_btDriver_btDriver/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_btDriver_btDriver/src/bridge/cpuSw_btDriver_btDriver_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_btDriver_btDriver/src/bridge/cpuSw_btDriver_btDriver_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L183'>btSend</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_btDriver_btDriver/src/bridge/cpuSw_btDriver_btDriver_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_btDriver_btDriver/src/bridge/cpuSw_btDriver_btDriver_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_btDriver_btDriver/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_btDriver_btDriver/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 28-32' href='components/cpuSw_btDriver_btDriver/src/cpuSw_btDriver_btDriver.c#L28'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_btDriver_btDriver/src/cpuSw_btDriver_btDriver.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 16-20' href='microkit.system#L16'>Memory Map</a></td></tr>
    </table>


#### usbDriver: GroundStation::usbDriver

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_usbDriver_usbDriver/src/component/cpuSw_usbDriver_usbDriver_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_usbDriver_usbDriver/src/component/cpuSw_usbDriver_usbDriver_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L194'>usbRecv</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Memory Map: Lines 34-38' href='microkit.system#L34'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_usbDriver_usbDriver/src/cpuSw_usbDriver_usbDriver.c#L9'>C var_addr</a> → <a title='C Interface: Lines 23-26' href='components/cpuSw_usbDriver_usbDriver/src/cpuSw_usbDriver_usbDriver.c#L23'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/cpuSw_usbDriver_usbDriver_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/cpuSw_usbDriver_usbDriver_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L195'>usbSend</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/cpuSw_usbDriver_usbDriver_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/cpuSw_usbDriver_usbDriver_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_usbDriver_usbDriver/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 28-32' href='components/cpuSw_usbDriver_usbDriver/src/cpuSw_usbDriver_usbDriver.c#L28'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_usbDriver_usbDriver/src/cpuSw_usbDriver_usbDriver.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 39-43' href='microkit.system#L39'>Memory Map</a></td></tr>
    </table>


#### dataManager: GroundStation::dataManager

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L27)

    TimeTriggered: [Rust](crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L39)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L102'>HMD_log</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::Log.Impl</td><td><a title='Memory Map: Lines 67-71' href='microkit.system#L67'>Memory Map</a> → <a title='C Shared Memory Variable: Line 12' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L12'>C var_addr</a> → <a title='C Interface: Lines 46-49' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L46'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 20-30' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L20'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 79-88' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L79'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L103'>request_log</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::Request.Impl</td><td><a title='Memory Map: Lines 62-66' href='microkit.system#L62'>Memory Map</a> → <a title='C Shared Memory Variable: Line 10' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L10'>C var_addr</a> → <a title='C Interface: Lines 33-36' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L33'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 32-42' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L32'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 32-39' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L32'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 89-98' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L89'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L105'>zeroize</a></td>
        <td>In</td><td>Event</td>
        <td></td><td><a title='Memory Map: Lines 72-76' href='microkit.system#L72'>Memory Map</a> → <a title='C Shared Memory Variable: Line 14' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L14'>C var_addr</a> → <a title='C Interface: Lines 61-64' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L61'>C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='Rust/C Interface: Lines 44-49' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L44'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 42-49' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L42'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 99-108' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L99'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L104'>response_log</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::ResponseLog.Impl</td><td><a title='Rust/Verus API: Lines 64-75' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L64'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 51-56' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L51'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_dataManager_dataManager/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 19-23' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L19'>C Interface</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_dataManager_dataManager/src/cpuSw_dataManager_dataManager.c#L9'>C var_addr</a> → <a title='Memory Map: Lines 57-61' href='microkit.system#L57'>Memory Map</a></td></tr>
    </table>
- **GUMBO**

    <table>
    <tr><th colspan=3>State Variables</th></tr>
    <tr><td>cache</td>
    <td><a href=../../GroundStation.aadl#L128>GUMBO</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L11>Verus</a></td></tr>
    <tr><td>zeroize_cmd</td>
    <td><a href=../../GroundStation.aadl#L129>GUMBO</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L12>Verus</a></td></tr></table>
    <table>
    <tr><th colspan=4>Initialize</th></tr>
    <tr><td>guarantee defaultZeroize</td>
    <td><a href=../../GroundStation.aadl#L144>GUMBO</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L32>Verus</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_GUMBOX.rs#L33>GUMBOX</a></td>
    </tr></table>
    <table>
    <tr><th colspan=4>Compute</th></tr>
    <tr><td>guarantee zeroize_cmd_variable</td>
    <td><a href=../../GroundStation.aadl#L150>GUMBO</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L50>Verus</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_GUMBOX.rs#L74>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee Zeroize_Payload</td>
    <td><a href=../../GroundStation.aadl#L153>GUMBO</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L56>Verus</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_GUMBOX.rs#L95>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee Zeroize_Cache</td>
    <td><a href=../../GroundStation.aadl#L155>GUMBO</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L60>Verus</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_GUMBOX.rs#L112>GUMBOX</a></td>
    </tr></table>
    <table>
    <tr><th colspan=4>GUMBO Methods</th></tr>
    <tr><td>IS_ZEROIZED</td>
    <td><a href=../../GroundStation.aadl#L131>GUMBO</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/component/cpuSw_dataManager_dataManager_app.rs#L94>Verus</a></td>
    <td><a href=crates/cpuSw_dataManager_dataManager/src/bridge/cpuSw_dataManager_dataManager_GUMBOX.rs#L17>GUMBOX</a></td>
    </tr></table>


#### dataAnalysis: GroundStation::dataAnalysis

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_dataAnalysis_dataAnalysis/src/component/cpuSw_dataAnalysis_dataAnalysis_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_dataAnalysis_dataAnalysis/src/component/cpuSw_dataAnalysis_dataAnalysis_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L164'>response_log</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::ResponseLog.Impl</td><td><a title='Memory Map: Lines 100-104' href='microkit.system#L100'>Memory Map</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L11'>C var_addr</a> → <a title='C Interface: Lines 38-41' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L38'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 20-30' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L20'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 30-37' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L30'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 89-98' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L89'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L166'>analysis_request</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Memory Map: Lines 105-109' href='microkit.system#L105'>Memory Map</a> → <a title='C Shared Memory Variable: Line 13' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L13'>C var_addr</a> → <a title='C Interface: Lines 51-54' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L51'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 32-42' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L32'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 40-47' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L40'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 99-108' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L99'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L163'>request_log</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::Request.Impl</td><td><a title='Rust/Verus API: Lines 62-73' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L62'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 44-49' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L44'>Rust/C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='C Interface: Lines 18-22' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L18'>C Interface</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L9'>C var_addr</a> → <a title='Memory Map: Lines 90-94' href='microkit.system#L90'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L165'>analysis_report</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Rust/Verus API: Lines 74-85' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L74'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 20-25' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/cpuSw_dataAnalysis_dataAnalysis_api.rs#L20'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 51-56' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L51'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_dataAnalysis_dataAnalysis/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 24-28' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L24'>C Interface</a> → <a title='C Shared Memory Variable: Line 10' href='components/cpuSw_dataAnalysis_dataAnalysis/src/cpuSw_dataAnalysis_dataAnalysis.c#L10'>C var_addr</a> → <a title='Memory Map: Lines 95-99' href='microkit.system#L95'>Memory Map</a></td></tr>
    </table>


#### decryptor: Hardened_SW::decryptor

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_decryptor_decryptor/src/component/cpuSw_decryptor_decryptor_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_decryptor_decryptor/src/component/cpuSw_decryptor_decryptor_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L431'>HMD_log_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::Log.Impl</td><td><a title='Memory Map: Lines 128-132' href='microkit.system#L128'>Memory Map</a> → <a title='C Shared Memory Variable: Line 10' href='components/cpuSw_decryptor_decryptor/src/cpuSw_decryptor_decryptor.c#L10'>C var_addr</a> → <a title='C Interface: Lines 29-32' href='components/cpuSw_decryptor_decryptor/src/cpuSw_decryptor_decryptor.c#L29'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_decryptor_decryptor/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_decryptor_decryptor/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_decryptor_decryptor/src/bridge/cpuSw_decryptor_decryptor_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_decryptor_decryptor/src/bridge/cpuSw_decryptor_decryptor_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L432'>HMD_log_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::Log.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_decryptor_decryptor/src/bridge/cpuSw_decryptor_decryptor_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_decryptor_decryptor/src/bridge/cpuSw_decryptor_decryptor_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_decryptor_decryptor/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_decryptor_decryptor/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 15-19' href='components/cpuSw_decryptor_decryptor/src/cpuSw_decryptor_decryptor.c#L15'>C Interface</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_decryptor_decryptor/src/cpuSw_decryptor_decryptor.c#L9'>C var_addr</a> → <a title='Memory Map: Lines 123-127' href='microkit.system#L123'>Memory Map</a></td></tr>
    </table>
- **GUMBO**

    <table>
    <tr><th colspan=4>Compute</th></tr>
    <tr><td>guarantee Payload_Decrypted</td>
    <td><a href=../../Hardened_SW.aadl#L445>GUMBO</a></td>
    <td><a href=crates/cpuSw_decryptor_decryptor/src/component/cpuSw_decryptor_decryptor_app.rs#L41>Verus</a></td>
    <td><a href=crates/cpuSw_decryptor_decryptor/src/bridge/cpuSw_decryptor_decryptor_GUMBOX.rs#L24>GUMBOX</a></td>
    </tr></table>


#### encryptor: Hardened_SW::encryptor

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_encryptor_encryptor/src/component/cpuSw_encryptor_encryptor_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_encryptor_encryptor/src/component/cpuSw_encryptor_encryptor_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L477'>analysis_report_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Memory Map: Lines 146-150' href='microkit.system#L146'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_encryptor_encryptor/src/cpuSw_encryptor_encryptor.c#L9'>C var_addr</a> → <a title='C Interface: Lines 23-26' href='components/cpuSw_encryptor_encryptor/src/cpuSw_encryptor_encryptor.c#L23'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_encryptor_encryptor/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_encryptor_encryptor/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L478'>analysis_report_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_encryptor_encryptor/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_encryptor_encryptor/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 28-32' href='components/cpuSw_encryptor_encryptor/src/cpuSw_encryptor_encryptor.c#L28'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_encryptor_encryptor/src/cpuSw_encryptor_encryptor.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 151-155' href='microkit.system#L151'>Memory Map</a></td></tr>
    </table>
- **GUMBO**

    <table>
    <tr><th colspan=4>Compute</th></tr>
    <tr><td>guarantee Payload_Encrypted</td>
    <td><a href=../../Hardened_SW.aadl#L493>GUMBO</a></td>
    <td><a href=crates/cpuSw_encryptor_encryptor/src/component/cpuSw_encryptor_encryptor_app.rs#L41>Verus</a></td>
    <td><a href=crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_GUMBOX.rs#L24>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee Header_Unencrypted</td>
    <td><a href=../../Hardened_SW.aadl#L495>GUMBO</a></td>
    <td><a href=crates/cpuSw_encryptor_encryptor/src/component/cpuSw_encryptor_encryptor_app.rs#L44>Verus</a></td>
    <td><a href=crates/cpuSw_encryptor_encryptor/src/bridge/cpuSw_encryptor_encryptor_GUMBOX.rs#L38>GUMBOX</a></td>
    </tr></table>


#### logMonitor: Hardened_SW::logMonitor

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L29)

    TimeTriggered: [Rust](crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L43)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L205'>request_log</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::Request.Impl</td><td><a title='Memory Map: Lines 174-178' href='microkit.system#L174'>Memory Map</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L11'>C var_addr</a> → <a title='C Interface: Lines 39-42' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L39'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 20-30' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L20'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 28-35' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L28'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 85-94' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L85'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L206'>response_log_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::ResponseLog.Impl</td><td><a title='Memory Map: Lines 169-173' href='microkit.system#L169'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L9'>C var_addr</a> → <a title='C Interface: Lines 26-29' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L26'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 32-42' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L32'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 38-45' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L38'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 95-104' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L95'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L207'>response_log_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::ResponseLog.Impl</td><td><a title='Rust/Verus API: Lines 60-71' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L60'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 44-49' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L44'>Rust/C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='C Interface: Lines 44-48' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L44'>C Interface</a> → <a title='C Shared Memory Variable: Line 13' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L13'>C var_addr</a> → <a title='Memory Map: Lines 179-183' href='microkit.system#L179'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L208'>alert</a></td>
        <td>Out</td><td>Event</td>
        <td></td><td><a title='Rust/Verus API: Lines 72-81' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L72'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 20-23' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_api.rs#L20'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 51-56' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L51'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_logMonitor_logMonitor/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 50-56' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L50'>C Interface</a> → <a title='C Shared Memory Variable: Line 14' href='components/cpuSw_logMonitor_logMonitor/src/cpuSw_logMonitor_logMonitor.c#L14'>C var_addr</a> → <a title='Memory Map: Lines 184-188' href='microkit.system#L184'>Memory Map</a></td></tr>
    </table>
- **GUMBO**

    <table>
    <tr><th colspan=3>State Variables</th></tr>
    <tr><td>since_result</td>
    <td><a href=../../Hardened_SW.aadl#L240>GUMBO</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L11>Verus</a></td></tr>
    <tr><td>is_valid</td>
    <td><a href=../../Hardened_SW.aadl#L241>GUMBO</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L12>Verus</a></td></tr>
    <tr><td>historically_no_alert_cmd</td>
    <td><a href=../../Hardened_SW.aadl#L242>GUMBO</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L13>Verus</a></td></tr></table>
    <table>
    <tr><th colspan=4>Initialize</th></tr>
    <tr><td>guarantee defaultSince</td>
    <td><a href=../../Hardened_SW.aadl#L245>GUMBO</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L34>Verus</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_GUMBOX.rs#L22>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee defaultIsValid</td>
    <td><a href=../../Hardened_SW.aadl#L247>GUMBO</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L36>Verus</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_GUMBOX.rs#L32>GUMBOX</a></td>
    </tr></table>
    <table>
    <tr><th colspan=4>Compute</th></tr>
    <tr><td>guarantee is_valid_variable</td>
    <td><a href=../../Hardened_SW.aadl#L253>GUMBO</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L55>Verus</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_GUMBOX.rs#L83>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee since_result_variable</td>
    <td><a href=../../Hardened_SW.aadl#L259>GUMBO</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L62>Verus</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_GUMBOX.rs#L107>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee Alert</td>
    <td><a href=../../Hardened_SW.aadl#L263>GUMBO</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L65>Verus</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_GUMBOX.rs#L126>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee Forward_Response</td>
    <td><a href=../../Hardened_SW.aadl#L267>GUMBO</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/component/cpuSw_logMonitor_logMonitor_app.rs#L74>Verus</a></td>
    <td><a href=crates/cpuSw_logMonitor_logMonitor/src/bridge/cpuSw_logMonitor_logMonitor_GUMBOX.rs#L150>GUMBOX</a></td>
    </tr></table>


#### reportMonitor: Hardened_SW::reportMonitor

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L31)

    TimeTriggered: [Rust](crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L44)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L306'>analysis_request</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Memory Map: Lines 217-221' href='microkit.system#L217'>Memory Map</a> → <a title='C Shared Memory Variable: Line 13' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L13'>C var_addr</a> → <a title='C Interface: Lines 51-54' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L51'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 20-30' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L20'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 30-37' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L30'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 89-98' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L89'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L307'>analysis_report_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Memory Map: Lines 202-206' href='microkit.system#L202'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L9'>C var_addr</a> → <a title='C Interface: Lines 26-29' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L26'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 32-42' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L32'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 40-47' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L40'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 99-108' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L99'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L308'>analysis_report_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Rust/Verus API: Lines 62-73' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L62'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 44-49' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L44'>Rust/C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='C Interface: Lines 31-35' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L31'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 207-211' href='microkit.system#L207'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L309'>alert</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Rust/Verus API: Lines 74-85' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L74'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 20-25' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_api.rs#L20'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 51-56' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L51'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_reportMonitor_reportMonitor/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 37-41' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L37'>C Interface</a> → <a title='C Shared Memory Variable: Line 12' href='components/cpuSw_reportMonitor_reportMonitor/src/cpuSw_reportMonitor_reportMonitor.c#L12'>C var_addr</a> → <a title='Memory Map: Lines 212-216' href='microkit.system#L212'>Memory Map</a></td></tr>
    </table>
- **GUMBO**

    <table>
    <tr><th colspan=3>State Variables</th></tr>
    <tr><td>counter</td>
    <td><a href=../../Hardened_SW.aadl#L348>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L11>Verus</a></td></tr>
    <tr><td>since_result</td>
    <td><a href=../../Hardened_SW.aadl#L349>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L12>Verus</a></td></tr>
    <tr><td>is_valid1</td>
    <td><a href=../../Hardened_SW.aadl#L350>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L13>Verus</a></td></tr>
    <tr><td>is_invalid2</td>
    <td><a href=../../Hardened_SW.aadl#L351>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L14>Verus</a></td></tr></table>
    <table>
    <tr><th colspan=4>Initialize</th></tr>
    <tr><td>guarantee defaultCounterAndSince</td>
    <td><a href=../../Hardened_SW.aadl#L367>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L36>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L51>GUMBOX</a></td>
    </tr></table>
    <table>
    <tr><th colspan=4>Compute</th></tr>
    <tr><td>guarantee since_result_variable</td>
    <td><a href=../../Hardened_SW.aadl#L373>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L56>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L108>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee valid1</td>
    <td><a href=../../Hardened_SW.aadl#L376>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L59>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L126>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee invalid2</td>
    <td><a href=../../Hardened_SW.aadl#L381>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L66>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L149>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee Alert1</td>
    <td><a href=../../Hardened_SW.aadl#L384>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L69>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L165>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee Alert2</td>
    <td><a href=../../Hardened_SW.aadl#L388>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L76>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L184>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee Forward_Report</td>
    <td><a href=../../Hardened_SW.aadl#L392>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L83>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L204>GUMBOX</a></td>
    </tr></table>
    <table>
    <tr><th colspan=4>GUMBO Methods</th></tr>
    <tr><td>Counter</td>
    <td><a href=../../Hardened_SW.aadl#L353>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L124>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L17>GUMBOX</a></td>
    </tr>
    <tr><td>ALLOW_LIST</td>
    <td><a href=../../Hardened_SW.aadl#L361>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L140>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L33>GUMBOX</a></td>
    </tr>
    <tr><td>FOUND_IN_ALLOW_LIST</td>
    <td><a href=../../Hardened_SW.aadl#L362>GUMBO</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/component/cpuSw_reportMonitor_reportMonitor_app.rs#L145>Verus</a></td>
    <td><a href=crates/cpuSw_reportMonitor_reportMonitor/src/bridge/cpuSw_reportMonitor_reportMonitor_GUMBOX.rs#L38>GUMBOX</a></td>
    </tr></table>


#### firewall: Hardened_SW::firewall

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_firewall_firewall/src/component/cpuSw_firewall_firewall_app.rs#L21)

    TimeTriggered: [Rust](crates/cpuSw_firewall_firewall/src/component/cpuSw_firewall_firewall_app.rs#L30)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L526'>analysis_request_in</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Memory Map: Lines 240-244' href='microkit.system#L240'>Memory Map</a> → <a title='C Shared Memory Variable: Line 10' href='components/cpuSw_firewall_firewall/src/cpuSw_firewall_firewall.c#L10'>C var_addr</a> → <a title='C Interface: Lines 29-32' href='components/cpuSw_firewall_firewall/src/cpuSw_firewall_firewall.c#L29'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_firewall_firewall/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 18-28' href='crates/cpuSw_firewall_firewall/src/bridge/extern_c_api.rs#L18'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 22-29' href='crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_api.rs#L22'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 55-62' href='crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_api.rs#L55'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L527'>analysis_request_out</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Rust/Verus API: Lines 42-51' href='crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_api.rs#L42'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 30-35' href='crates/cpuSw_firewall_firewall/src/bridge/extern_c_api.rs#L30'>Rust/C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_firewall_firewall/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='C Interface: Lines 15-19' href='components/cpuSw_firewall_firewall/src/cpuSw_firewall_firewall.c#L15'>C Interface</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_firewall_firewall/src/cpuSw_firewall_firewall.c#L9'>C var_addr</a> → <a title='Memory Map: Lines 235-239' href='microkit.system#L235'>Memory Map</a></td></tr>
    </table>
- **GUMBO**

    <table>
    <tr><th colspan=4>Compute</th></tr>
    <tr><td>guarantee Forward_Request</td>
    <td><a href=../../Hardened_SW.aadl#L547>GUMBO</a></td>
    <td><a href=crates/cpuSw_firewall_firewall/src/component/cpuSw_firewall_firewall_app.rs#L41>Verus</a></td>
    <td><a href=crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_GUMBOX.rs#L36>GUMBOX</a></td>
    </tr></table>
    <table>
    <tr><th colspan=4>GUMBO Methods</th></tr>
    <tr><td>ALLOW_LIST</td>
    <td><a href=../../Hardened_SW.aadl#L542>GUMBO</a></td>
    <td><a href=crates/cpuSw_firewall_firewall/src/component/cpuSw_firewall_firewall_app.rs#L80>Verus</a></td>
    <td><a href=crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_GUMBOX.rs#L17>GUMBOX</a></td>
    </tr>
    <tr><td>FOUND_IN_ALLOW_LIST</td>
    <td><a href=../../Hardened_SW.aadl#L543>GUMBO</a></td>
    <td><a href=crates/cpuSw_firewall_firewall/src/component/cpuSw_firewall_firewall_app.rs#L85>Verus</a></td>
    <td><a href=crates/cpuSw_firewall_firewall/src/bridge/cpuSw_firewall_firewall_GUMBOX.rs#L22>GUMBOX</a></td>
    </tr></table>


#### wifiDriver: GroundStation::wifiDriver

 - **Entry Points**


    Initialize: [Rust](crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/component/cpuSw_wifiDriver_wifiDriver_wifiDriver_app.rs#L25)

    TimeTriggered: [Rust](crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/component/cpuSw_wifiDriver_wifiDriver_wifiDriver_app.rs#L37)


- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L52'>wifiRecv</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::IncomingWifiMessage.Impl</td><td><a title='Memory Map: Lines 283-287' href='microkit.system#L283'>Memory Map</a> → <a title='C Shared Memory Variable: Line 16' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L16'>C var_addr</a> → <a title='C Interface: Lines 73-76' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L73'>C Interface</a> → <a title='C Extern: Line 14' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L14'>C Extern</a> → <a title='Rust/C Interface: Lines 22-32' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L22'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 38-45' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L38'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 127-138' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L127'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L55'>analysis_report</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::AnalysisReport.Impl</td><td><a title='Memory Map: Lines 258-262' href='microkit.system#L258'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L9'>C var_addr</a> → <a title='C Interface: Lines 29-32' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L29'>C Interface</a> → <a title='C Extern: Line 15' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L15'>C Extern</a> → <a title='Rust/C Interface: Lines 34-44' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L34'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 48-55' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L48'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 139-150' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L139'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L57'>alert</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Memory Map: Lines 263-267' href='microkit.system#L263'>Memory Map</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L11'>C var_addr</a> → <a title='C Interface: Lines 42-45' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L42'>C Interface</a> → <a title='C Extern: Line 16' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L16'>C Extern</a> → <a title='Rust/C Interface: Lines 46-56' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L46'>Rust/C Interface</a> → <a title='Unverified Rust Interface: Lines 58-65' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L58'>Unverified Rust Interface</a> → <a title='Rust/Verus API: Lines 151-162' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L151'>Rust/Verus API</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L53'>wifiSend</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Rust/Verus API: Lines 82-95' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L82'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 12-17' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L12'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 58-63' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L58'>Rust/C Interface</a> → <a title='C Extern: Line 17' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L17'>C Extern</a> → <a title='C Interface: Lines 47-51' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L47'>C Interface</a> → <a title='C Shared Memory Variable: Line 13' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L13'>C var_addr</a> → <a title='Memory Map: Lines 268-272' href='microkit.system#L268'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L54'>HMD_log</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::Log.Impl</td><td><a title='Rust/Verus API: Lines 96-109' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L96'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 20-25' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L20'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 65-70' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L65'>Rust/C Interface</a> → <a title='C Extern: Line 18' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L18'>C Extern</a> → <a title='C Interface: Lines 53-57' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L53'>C Interface</a> → <a title='C Shared Memory Variable: Line 14' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L14'>C var_addr</a> → <a title='Memory Map: Lines 273-277' href='microkit.system#L273'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../GroundStation.aadl#L56'>analysis_request</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::AnalysisRequest.Impl</td><td><a title='Rust/Verus API: Lines 110-123' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L110'>Rust/Verus API</a> → <a title='Unverified Rust Interface: Lines 28-33' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_api.rs#L28'>Unverified Rust Interface</a> → <a title='Rust/C Interface: Lines 72-77' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L72'>Rust/C Interface</a> → <a title='C Extern: Line 19' href='crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/extern_c_api.rs#L19'>C Extern</a> → <a title='C Interface: Lines 59-63' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L59'>C Interface</a> → <a title='C Shared Memory Variable: Line 15' href='components/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/cpuSw_wifiDriver_wifiDriver_wifiDriver.c#L15'>C var_addr</a> → <a title='Memory Map: Lines 278-282' href='microkit.system#L278'>Memory Map</a></td></tr>
    </table>
- **GUMBO**

    <table>
    <tr><th colspan=3>State Variables</th></tr>
    <tr><td>alert_cmd</td>
    <td><a href=../../GroundStation.aadl#L80>GUMBO</a></td>
    <td><a href=crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/component/cpuSw_wifiDriver_wifiDriver_wifiDriver_app.rs#L11>Verus</a></td></tr></table>
    <table>
    <tr><th colspan=4>Initialize</th></tr>
    <tr><td>guarantee defaultAlert</td>
    <td><a href=../../GroundStation.aadl#L84>GUMBO</a></td>
    <td><a href=crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/component/cpuSw_wifiDriver_wifiDriver_wifiDriver_app.rs#L30>Verus</a></td>
    <td><a href=crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_GUMBOX.rs#L22>GUMBOX</a></td>
    </tr></table>
    <table>
    <tr><th colspan=4>Compute</th></tr>
    <tr><td>guarantee alert_cmd_variable</td>
    <td><a href=../../GroundStation.aadl#L90>GUMBO</a></td>
    <td><a href=crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/component/cpuSw_wifiDriver_wifiDriver_wifiDriver_app.rs#L50>Verus</a></td>
    <td><a href=crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_GUMBOX.rs#L67>GUMBOX</a></td>
    </tr>
    <tr><td>guarantee Process_Report</td>
    <td><a href=../../GroundStation.aadl#L93>GUMBO</a></td>
    <td><a href=crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/component/cpuSw_wifiDriver_wifiDriver_wifiDriver_app.rs#L56>Verus</a></td>
    <td><a href=crates/cpuSw_wifiDriver_wifiDriver_wifiDriver/src/bridge/cpuSw_wifiDriver_wifiDriver_wifiDriver_GUMBOX.rs#L88>GUMBOX</a></td>
    </tr></table>


#### wifiDriver: Hardened_SW::wifiDriverVM

 - **Entry Points**



- **APIs**

    <table>
    <tr><th>Port Name</th><th>Direction</th><th>Kind</th><th>Payload</th><th>Realizations</th></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L20'>wifiRecvIn</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::IncomingWifiMessage.Impl</td><td><a title='Memory Map: Lines 316-320' href='microkit.system#L316'>Memory Map</a> → <a title='C Shared Memory Variable: Line 12' href='components/cpuSw_wifiDriver_wifiDriverVM_wifiDriver/src/cpuSw_wifiDriver_wifiDriverVM_wifiDriver.c#L12'>C var_addr</a> → <a title='C Interface: Lines 45-48' href='components/cpuSw_wifiDriver_wifiDriverVM_wifiDriver/src/cpuSw_wifiDriver_wifiDriverVM_wifiDriver.c#L45'>C Interface</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L22'>wifiSendIn</a></td>
        <td>In</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='Memory Map: Lines 306-310' href='microkit.system#L306'>Memory Map</a> → <a title='C Shared Memory Variable: Line 9' href='components/cpuSw_wifiDriver_wifiDriverVM_wifiDriver/src/cpuSw_wifiDriver_wifiDriverVM_wifiDriver.c#L9'>C var_addr</a> → <a title='C Interface: Lines 26-29' href='components/cpuSw_wifiDriver_wifiDriverVM_wifiDriver/src/cpuSw_wifiDriver_wifiDriverVM_wifiDriver.c#L26'>C Interface</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L21'>wifiRecvOut</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::IncomingWifiMessage.Impl</td><td><a title='C Interface: Lines 31-35' href='components/cpuSw_wifiDriver_wifiDriverVM_wifiDriver/src/cpuSw_wifiDriver_wifiDriverVM_wifiDriver.c#L31'>C Interface</a> → <a title='C Shared Memory Variable: Line 11' href='components/cpuSw_wifiDriver_wifiDriverVM_wifiDriver/src/cpuSw_wifiDriver_wifiDriverVM_wifiDriver.c#L11'>C var_addr</a> → <a title='Memory Map: Lines 311-315' href='microkit.system#L311'>Memory Map</a></td></tr>
    <tr><td><a title='Model' href='../../Hardened_SW.aadl#L23'>wifiSendOut</a></td>
        <td>Out</td><td>Event Data</td>
        <td>Common::DummyMessage.Impl</td><td><a title='C Interface: Lines 50-54' href='components/cpuSw_wifiDriver_wifiDriverVM_wifiDriver/src/cpuSw_wifiDriver_wifiDriverVM_wifiDriver.c#L50'>C Interface</a> → <a title='C Shared Memory Variable: Line 14' href='components/cpuSw_wifiDriver_wifiDriverVM_wifiDriver/src/cpuSw_wifiDriver_wifiDriverVM_wifiDriver.c#L14'>C var_addr</a> → <a title='Memory Map: Lines 321-325' href='microkit.system#L321'>Memory Map</a></td></tr>
    </table>

