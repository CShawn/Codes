package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/23 12:11 下午
 */
class Q5763Test {

    @ParameterizedTest
    @CsvSource({"1101, true", "111000, false", "110100010, false"})
    void checkZeroOnes(String s, boolean result) {
        Assertions.assertEquals(result, new Q5763().checkZeroOnes(s));
    }
}