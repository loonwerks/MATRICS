package MATRICS_Model_Transformations {

    language "GUMBO" /*{
        library
            functions
                def ALLOW_LIST(): Common::AllowList_Impl :=
                    Common::AllowList_Impl(
                        3232235877 [u32], 3232235878 [u32],
                        3232235879 [u32], 3232235880 [u32]);

                def FOUND_IN_ALLOW_LIST(
                    allow_list: Common::AllowList_Impl,
                    src: Base_Types::Unsigned_32): Base_Types::Boolean :=
                    (0 .. size(allow_list) - 1) -> exists {
                        i; allow_list#(i) == src
                    };

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
