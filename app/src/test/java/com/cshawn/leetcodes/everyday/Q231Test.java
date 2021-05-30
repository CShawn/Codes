package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/30 12:18 下午
 */
class Q231Test {

    @ParameterizedTest
    @CsvSource({"0,false", "-1,false", "1,true", "2,true", "3,false", "8,true"})
    void isPowerOfTwo(int num, boolean result) {
        Assertions.assertEquals(result, new Q231().isPowerOfTwo1(num));
        Assertions.assertEquals(result, new Q231().isPowerOfTwo(num));
    }
}