package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/24 8:48 下午
 */
class Q1_9Test {

    @ParameterizedTest
    @CsvSource({",,false", "'','',true", "a,'',false", "'',a,false", "a,a,true",
            "ab,ba,true", "abc,baa,false", "abcd,cdab,true", "a,abc,false",
            "abc,a,false", "abababc,abcabab,true"})
    void isFlipedString(String s1, String s2, boolean result) {
        Assertions.assertEquals(result, new Q1_9().isFlipedString1(s1, s2));
        Assertions.assertEquals(result, new Q1_9().isFlipedString2(s1, s2));
        Assertions.assertEquals(result, new Q1_9().isFlipedString(s1, s2));
    }
}