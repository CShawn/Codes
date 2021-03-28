package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/28 11:18 上午
 */
class Q5715Test {

    @ParameterizedTest
    @CsvSource({"2,1", "4,2", "6,4"})
    void reinitializePermutation(int n, int result) {
        Assertions.assertEquals(result, new Q5715().reinitializePermutation(n));
    }
}