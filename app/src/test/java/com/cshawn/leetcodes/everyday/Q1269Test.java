package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/13 9:58 下午
 */
class Q1269Test {

    @ParameterizedTest
    @CsvSource({"3,2,4", "2,4,2", "4,2,8", "4,3,9"})
    void numWays(int steps, int arrLen, int result) {
        Assertions.assertEquals(result, new Q1269().numWays1(steps, arrLen));
        Assertions.assertEquals(result, new Q1269().numWays(steps, arrLen));
    }
}