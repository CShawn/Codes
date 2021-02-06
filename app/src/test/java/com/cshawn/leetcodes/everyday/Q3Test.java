package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/6 1:57 下午
 */
class Q3Test {

    @ParameterizedTest
    @CsvSource({",0", "a,1", "ab,2", "aa,1", "abcabcbb,3", "bbbbb,1", "pwwkew,3", "abdsasdfcagabcberg3b,6"})
    void lengthOfLongestSubstring(String s, int n) {
        Assertions.assertEquals(n, new Q3().lengthOfLongestSubstring1(s));
        Assertions.assertEquals(n, new Q3().lengthOfLongestSubstring(s));
    }
}