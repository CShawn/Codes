package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/10/12 8:31 上午
 */
class Q29Test {

    @ParameterizedTest
    @CsvSource({"10,3,3", "7,-3,-2", "15,3,5", "-2147483648,1,-2147483648", "-2147483648,-1,2147483647", "2147483647,-1,-2147483647"})
    void divide(int dividend, int divisor, int result) {
        Assertions.assertEquals(result, new Q29().divide1(dividend, divisor));
        Assertions.assertEquals(result, new Q29().divide(dividend, divisor));
    }
}