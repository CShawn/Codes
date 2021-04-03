package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/3 12:26 下午
 */
class Q1143Test {

    @ParameterizedTest
    @CsvSource({"abcde,ace,3", "abc,abc,3", "aa,aaaaa,2", "ab,ce,0"})
    void longestCommonSubsequence(String s1, String s2, int result) {
        Assertions.assertEquals(result, new Q1143().longestCommonSubsequence1(s1, s2));
        Assertions.assertEquals(result, new Q1143().longestCommonSubsequence2(s1, s2));
        Assertions.assertEquals(result, new Q1143().longestCommonSubsequence(s1, s2));
    }
}