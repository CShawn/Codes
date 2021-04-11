package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/11 10:01 上午
 */
class Q264Test {

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "4,4", "5,5", "6,6", "7,8", "8,9", "9,10", "1407,536870912"})
    void nthUglyNumber(int n, int result) {
        Assertions.assertEquals(result, new Q264().nthUglyNumber1(n));
        Assertions.assertEquals(result, new Q264().nthUglyNumber(n));
    }
}