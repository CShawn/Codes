package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/23 1:08 下午
 */
class Q5765Test {

    @ParameterizedTest
    @CsvSource({"011010, 2, 3, true", "01101110, 2, 3, false"})
    void canReach(String s, int min, int max, boolean result) {
        Assertions.assertEquals(result, new Q5765().canReach1(s, min, max));
        Assertions.assertEquals(result, new Q5765().canReach(s, min, max));
    }
}