package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/9 5:22 下午
 */
class Q1201Test {

    @ParameterizedTest
    @CsvSource({"3,2,3,5,4", "4,2,3,4,6", "5,2,11,13,10", "1000000000,2,217983653,336916467,1999999984"})
    void nthUglyNumber(int n, int a, int b, int c, int result) {
        Assertions.assertEquals(result, new Q1201().nthUglyNumber1(n, a, b, c));
        Assertions.assertEquals(result, new Q1201().nthUglyNumber(n, a, b, c));
    }
}