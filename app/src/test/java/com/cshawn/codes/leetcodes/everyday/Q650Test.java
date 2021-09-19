package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/9/19 1:33 下午
 */
class Q650Test {

    @ParameterizedTest
    @CsvSource({"1,0", "2,2", "3,3", "4,4", "5,5", "6,5", "7,7","8,6", "9,6", "27,9", "1000,21"})
    void minSteps(int n, int result) {
        Assertions.assertEquals(result, new Q650().minSteps(n));
    }
}