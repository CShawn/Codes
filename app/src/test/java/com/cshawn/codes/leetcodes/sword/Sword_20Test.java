package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/7/20 4:11 下午
 */
class Sword_20Test {

    @ParameterizedTest
    @CsvSource({"0", "2", "0089", ".1", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", "46.e3"})
    void isNumber(String s) {
        Assertions.assertTrue(new Sword_20().isNumber(s));
    }

    @ParameterizedTest
    @CsvSource({"abc", "1a", "1e", "e3", ".e3", "e", ".", "..", "99e2.5", "--6", "-+3", "95a54e53", "+."})
    void isNotNumber(String s) {
        Assertions.assertFalse(new Sword_20().isNumber(s));
    }
}