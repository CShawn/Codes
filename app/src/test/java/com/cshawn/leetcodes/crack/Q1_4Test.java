package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/23 5:58 下午
 */
class Q1_4Test {

    @ParameterizedTest
    @CsvSource({",false", "'',true", "ab,false", "aa,true", "aab,true", "aabc,false", "abcab,true"})
    void canPermutePalindrome(String s, boolean result) {
        Assertions.assertEquals(result, new Q1_4().canPermutePalindrome1(s));
        Assertions.assertEquals(result, new Q1_4().canPermutePalindrome(s));
    }
}