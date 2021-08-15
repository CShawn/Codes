package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/12 3:14 下午
 */
class Q516Test {

    @ParameterizedTest
    @CsvSource({"a,1", "ab,1","bb,2","cbbd,2", "bbbab,4"})
    void longestPalindromeSubseq(String s, int result) {
        Assertions.assertEquals(result, new Q516().longestPalindromeSubseq(s));
    }
}