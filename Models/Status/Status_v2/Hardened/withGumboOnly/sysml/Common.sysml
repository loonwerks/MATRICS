// SysML v2 data definitions used by the Ground Station.

package Common {

    private import HAMR::*;

    // Private support type for the shared GUMBO allow-list functions. Keeping
    // it outside the library package avoids a Rust namespace collision between
    // a generated data module and the GUMBO library crate of the same name.
    part def AllowList_Impl :> Array {
        part :>> Base_Type : Base_Types::Unsigned_32;
        attribute :>> Dimensions = 4;
        attribute :>> Array_Size_Kind = Array_Size_Kinds::Fixed;
        attribute :>> Data_Size = 16 [byte];
    }

    part def MsgHeader_Impl :> Struct {
        part client: Base_Types::Unsigned_32;
    }

    part def Log_Impl :> Struct {
        part timestamp: Base_Types::Unsigned_32;
        part userID: Base_Types::Unsigned_32;
        part numSuspects: Base_Types::Unsigned_32;
        part numSuspectsFlagged: Base_Types::Unsigned_32;
        part yaw: Base_Types::Integer_32;
        part pitch: Base_Types::Integer_32;
        part roll: Base_Types::Integer_32;
    }

    part def Request_Impl :> Struct {
        part requestID: Base_Types::Integer_32;
        part analysisType: Base_Types::Integer_32;
        part userID: Base_Types::Integer_32;
        part startTime: Base_Types::Integer_32;
        part endTime: Base_Types::Integer_32;
    }

    part def AnalysisRequest_Impl :> Struct {
        part header: MsgHeader_Impl;
        part payload: Request_Impl;
    }

    part def ResponseHeader_Impl :> Struct {
        part requestID: Base_Types::Integer_32;
        part sequenceNumber: Base_Types::Integer_32;
        part totalParts: Base_Types::Integer_32;
    }

    part def LogArray_Impl :> Array {
        part :>> Base_Type : Log_Impl;
        attribute :>> Dimensions = 100;
        attribute :>> Array_Size_Kind = Array_Size_Kinds::Fixed;
        attribute :>> Data_Size = 100 [byte];
    }

    part def ResponseLog_Impl :> Struct {
        part header: ResponseHeader_Impl;
        part payload: LogArray_Impl;
    }

    part def OutgoingPayload_Impl :> Array {
        part :>> Base_Type : Base_Types::Unsigned_8;
        attribute :>> Dimensions = 32768;
        attribute :>> Array_Size_Kind = Array_Size_Kinds::Fixed;
        attribute :>> Data_Size = 32768 [byte];
    }

    part def AnalysisReport_Impl :> Struct {
        part header: MsgHeader_Impl;
        part payload: OutgoingPayload_Impl;
    }

    part def OutgoingWifiMessage_Impl :> AnalysisReport_Impl;

    part def DummyMessage_Impl :> Array {
        part :>> Base_Type : Base_Types::Unsigned_8;
        attribute :>> Dimensions = 100;
        attribute :>> Array_Size_Kind = Array_Size_Kinds::Fixed;
        attribute :>> Data_Size = 100 [byte];
    }

    part def encryptedIncomingPayload_Impl :> Array {
        part :>> Base_Type : Base_Types::Unsigned_8;
        attribute :>> Dimensions = 1024;
        attribute :>> Array_Size_Kind = Array_Size_Kinds::Fixed;
        attribute :>> Data_Size = 1024 [byte];
    }

    part def shortText :> Array {
        part :>> Base_Type : Base_Types::Character;
        attribute :>> Dimensions = 64;
        attribute :>> Array_Size_Kind = Array_Size_Kinds::Fixed;
        attribute :>> Data_Size = 64 [byte];
    }

    part def IncomingWifiHeader_Impl :> Struct {
        part route: shortText;
        part client: Base_Types::Unsigned_32;
    }

    part def IncomingWifiMessage_Impl :> Struct {
        part header: IncomingWifiHeader_Impl;
        part payload: encryptedIncomingPayload_Impl;
    }
}
