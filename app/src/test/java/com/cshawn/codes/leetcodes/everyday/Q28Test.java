package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/20 9:06 下午
 */
class Q28Test {

    @ParameterizedTest
    @CsvSource({"aaac,aac,1", "'','',0", "a,'',0", "'',a,-1", "a,b,-1", "aaa,aa,0", "aa,aaa,-1", "ab,cde,-1", "ab,ab,0", "abab,ab,0", "ababc,abc,2"})
    void strStr(String haystack, String needle, int index) {
        Assertions.assertEquals(index, new Q28().strStr1(haystack, needle));
        Assertions.assertEquals(index, new Q28().strStr(haystack, needle));
    }
}