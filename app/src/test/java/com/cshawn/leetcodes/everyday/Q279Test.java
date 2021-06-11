package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/6/11 9:16 下午
 */
class Q279Test {

    @ParameterizedTest
    @CsvSource({"12,3", "13,2", "5,2"})
    void numSquares(int n, int result) {
        Assertions.assertEquals(result, new Q279().numSquares1(n));
        Assertions.assertEquals(result, new Q279().numSquares(n));
    }
}