package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/9/27 12:23 下午
 */
class Q639Test {

    @ParameterizedTest
    @CsvSource({"*,9", "1*,18", "2*,15", "*0,2", "11106,2", "7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*,196465252"})
    void numDecodings(String s, int result) {
        assertEquals(result, new Q639().numDecodings(s));
    }
}