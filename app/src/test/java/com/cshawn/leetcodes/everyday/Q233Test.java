package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/13 4:13 下午
 */
class Q233Test {

    @ParameterizedTest
    @CsvSource({"0,0",  "1,1", "9,1", "10,2", "18,11", "520,212", "521,213", "512,205"})
    void countDigitOne(int n, int result) {
        Assertions.assertEquals(result, new Q233().countDigitOne(n));
    }
}