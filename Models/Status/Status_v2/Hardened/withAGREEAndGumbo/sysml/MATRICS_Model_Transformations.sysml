package MATRICS_Model_Transformations {

    language "GUMBO" /*{
        library
            functions
                def FOUND_IN_ALLOW_LIST(
                    src: Base_Types::Unsigned_32): Base_Types::Boolean :=
                    src == 3232235877 [u32] or
                    src == 3232235878 [u32] or
                    src == 3232235879 [u32] or
                    src == 3232235880 [u32];

                // A predicate is used because the current SysML/GUMBO backend
                // does not lower struct-valued library-function constructors.
                def IS_NULL_LOG(log: Common::Log_Impl): Base_Types::Boolean :=
                    log.timestamp == 0 [u32] &
                    log.userID == 0 [u32] &
                    log.numSuspects == 0 [u32] &
                    log.numSuspectsFlagged == 0 [u32] &
                    log.yaw == 0 [i32] &
                    log.pitch == 0 [i32] &
                    log.roll == 0 [i32];
    }*/
}
