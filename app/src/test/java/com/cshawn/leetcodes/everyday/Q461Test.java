package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/27 10:41 上午
 */
class Q461Test {

    @ParameterizedTest
    @CsvSource({"1,4,2", "7,8,4", "9,0,2"})
    void hammingDistance(int x, int y, int result) {
        Assertions.assertEquals(result, new Q461().hammingDistance(x, y));
    }
}