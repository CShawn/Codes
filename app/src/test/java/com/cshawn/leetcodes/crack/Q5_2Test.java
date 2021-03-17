package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/17 10:43 下午
 */
class Q5_2Test {

    @ParameterizedTest
    @CsvSource({"0.5,0.1", "0.75,0.11", "0.125,0.001", "0.3,ERROR"})
    void printBin(double num, String result) {
        Assertions.assertEquals(result, new Q5_2().printBin(num));
    }
}