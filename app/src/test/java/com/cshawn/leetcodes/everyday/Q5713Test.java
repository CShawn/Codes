package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/28 12:44 下午
 */
class Q5713Test {

    @ParameterizedTest
    @CsvSource({"a123bc34d8ef34,3", "leet1234code234,2", "a1b01c001,1"})
    void numDifferentIntegers(String s, int result) {
        Assertions.assertEquals(result, new Q5713().numDifferentIntegers(s));
    }
}