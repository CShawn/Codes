package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author C.Shawn
 * @date 2020/11/25 11:15
 */
class Sword_19Test {
    private final Sword_19 test = new Sword_19();

    @ParameterizedTest(name = "case {index}: s = {0}, p = {1}, match = {2}")
    @CsvSource({
            "aa, a, false",
            "aa, a*, true",
            "ab, .*, true",
            "aaa, a*a, true",
            "aab, c*a*b, true",
            "mississippi, mis*is*p*., false",
            "ab, a*b*p*, true",
            "ab, c*ab*c*, true",
            "ab, .*c, false",
            "bbbba, .*a*a, true",
            "'','',true"
    })
    void isMatch(String s, String p, boolean expected) {
        assertEquals(expected, test.isMatch1(s, p));
        assertEquals(expected, test.isMatch(s, p));
    }
}