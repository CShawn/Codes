package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/8 10:20 上午
 */
class Q1137Test {
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,1", "3,2", "4,4",  "25,1389537"})
    void tribonacci(int n, int result) {
        Assertions.assertEquals(result, new Q1137().tribonacci(n));
    }
}