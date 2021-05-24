package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/24 9:56 下午
 */
class Q664Test {

    @ParameterizedTest
    @CsvSource({"aaabbb,2", "aba,2", "abab,3"})
    void strangePrinter(String s, int result) {
        Assertions.assertEquals(result, new Q664().strangePrinter(s));
    }
}