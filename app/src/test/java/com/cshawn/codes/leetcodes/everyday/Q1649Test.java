package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/23 9:31 上午
 */
class Q1649Test {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,1", "3,2", "20,7"})
    void getMaximumGenerated(int n, int result) {
        Assertions.assertEquals(result, new Q1649().getMaximumGenerated(n));
    }
}