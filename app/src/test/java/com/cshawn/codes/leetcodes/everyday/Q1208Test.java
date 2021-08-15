package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/5 11:01 上午
 */
class Q1208Test {

    @ParameterizedTest
    @CsvSource({",,4,0", "abcd,bcdf,3,3", "abcd,cdef,3,1", "abcd,acde,0,1", "abc,bcd,0,0", "krrgw,zjxss,19,2", "pxezla,loewbi,25,4"})
    void equalSubstring(String s, String t, int maxCost, int length) {
        Assertions.assertEquals(length, new Q1208().equalSubstring(s, t, maxCost));
    }
}