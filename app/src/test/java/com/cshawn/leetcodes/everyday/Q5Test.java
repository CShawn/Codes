package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/10 11:02 下午
 */
class Q5Test {

    @ParameterizedTest
    @CsvSource({
            ",",
            "'',''",
            "a,a",
            "ab,b",
            "aa,aa",
            "aba,aba",
            "babad,aba",
            "cbbasdbbbad,bbb",
            "cbbasdbbbadabbbwesdwewasdasfsadssaas,sdasfsads",
            "babadada,adada"
    })
    void longestPalindrome1(String s, String result) {
        Assertions.assertEquals(result, new Q5().longestPalindrome1(s));
    }

    @ParameterizedTest
    @CsvSource({
//            ",",
//            "'',''",
//            "a,a",
//            "ab,a",
//            "aa,aa",
//            "aba,aba",
//            "babad,bab",
//            "cbbasdbbbad,bbb",
//            "cbbasdbbbadabbbwesdwewasdasfsadssaas,bbbadabbb",
            "babadada,adada"
    })
    void longestPalindrome(String s, String result) {
        Assertions.assertEquals(result, new Q5().longestPalindrome(s));
    }
}