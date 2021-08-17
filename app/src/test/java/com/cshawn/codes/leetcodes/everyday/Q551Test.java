package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/17 9:32 上午
 */
class Q551Test {

    @ParameterizedTest
    @CsvSource({"PPALLP,true", "PPALLL,false", "LAPPLLPALLL,false", "LALL,true"})
    void checkRecord(String s, boolean result) {
        Assertions.assertEquals(result, new Q551().checkRecord(s));
    }
}