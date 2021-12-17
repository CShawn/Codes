package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/12/17 9:28 上午
 */
class Q1518Test {

    @ParameterizedTest
    @CsvSource({"9,3,13", "15,4,19", "5,5,6", "2,3,2"})
    void numWaterBottles(int numBottles, int numExchange, int result) {
        assertEquals(result, new Q1518().numWaterBottles1(numBottles, numExchange));
        assertEquals(result, new Q1518().numWaterBottles2(numBottles, numExchange));
        assertEquals(result, new Q1518().numWaterBottles(numBottles, numExchange));
    }
}