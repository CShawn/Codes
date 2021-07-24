package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/7/24 10:51 上午
 */
class Q1736Test {

    @ParameterizedTest
    @CsvSource({"??:??,23:59", "1?:3?,19:39", "1?:?2,19:52", "2?:?0,23:50", "0?:3?,09:39", "1?:22,19:22"})
    void maximumTime(String time, String result) {
        Assertions.assertEquals(result, new Q1736().maximumTime(time));
    }
}