package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/10/15 2:50 下午
 */
class Q38Test {

    @ParameterizedTest
    @CsvSource({"1,1", "2,11", "3,21", "4,1211", "10,13211311123113112211"})
    void countAndSay(int n, String result) {
        assertEquals(result, new Q38().countAndSay1(n));
        assertEquals(result, new Q38().countAndSay(n));
    }
}