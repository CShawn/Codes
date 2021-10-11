package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/10/10 12:06 下午
 */
class Q441Test {

    @ParameterizedTest
    @CsvSource({"1,1", "2,1", "3,2", "4,2","5,2", "6,3", "8,3", "274849553,23445"})
    void arrangeCoins(int n, int result) {
        assertEquals(result, new Q441().arrangeCoins1(n));
        assertEquals(result, new Q441().arrangeCoins(n));
    }
}