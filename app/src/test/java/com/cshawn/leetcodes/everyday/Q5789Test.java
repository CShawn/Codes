package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/6/20 12:31 下午
 */
class Q5789Test {

    @ParameterizedTest
    @CsvSource({"00:01,00:00,95", "23:46,00:01,0", "00:01,00:29,0", "00:01,00:30,1", "00:01,00:44,1", "00:01,00:45,2"})
    void numberOfRounds(String startTime, String finishTime, int result) {
        Assertions.assertEquals(result, new Q5789().numberOfRounds1(startTime, finishTime));
        Assertions.assertEquals(result, new Q5789().numberOfRounds(startTime, finishTime));
    }
}