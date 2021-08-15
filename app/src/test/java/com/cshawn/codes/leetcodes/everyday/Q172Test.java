package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/7/30 3:54 下午
 */
class Q172Test {

    @ParameterizedTest
    @CsvSource({"3,0", "5,1", "20,4", "30,7", "5649,1409", "8451,2132", "10000,2499"})
    void trailingZeroes(int n, int result) {
        Assertions.assertEquals(result, new Q172().trailingZeroes(n));
    }
}