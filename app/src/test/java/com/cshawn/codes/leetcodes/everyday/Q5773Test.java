package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/30 10:53 上午
 */
class Q5773Test {

    @ParameterizedTest
    @CsvSource({"99,9,999", "364,3,3643", "-24,6,-246", "-14,2,-124", "-34,2,-234", "-132,3,-1323"})
    void maxValue(String n, int x, String result) {
        Assertions.assertEquals(result, new Q5773().maxValue(n, x));
    }
}