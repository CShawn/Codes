package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/22 5:23 下午
 */
class Q191Test {
    @ParameterizedTest
    @CsvSource({"11,3", "128,1", "-1,32"})
    void hammingWeight(int n, int result) {
        Assertions.assertEquals(result, new Q191().hammingWeight(n));
    }
}