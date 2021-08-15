package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/3 11:59 下午
 */
class Q5706Test {
    @ParameterizedTest
    @CsvSource({
            "My name is Haley,My Haley,true",
            "of,A lot of words,false",
            "a b c,a,true",
            "a b c,c,true",
            "a b c,d,false"
    })
    void areSentencesSimilar(String s1, String s2, boolean result) {
        Assertions.assertEquals(result, new Q5706().areSentencesSimilar1(s1, s2));
        Assertions.assertEquals(result, new Q5706().areSentencesSimilar(s1, s2));
    }
}