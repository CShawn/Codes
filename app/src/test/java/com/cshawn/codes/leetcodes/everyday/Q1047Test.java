package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/9 7:13 下午
 */
class Q1047Test {

    @ParameterizedTest
    @CsvSource({",", "'',''", "a,a", "ab,ab", "aab,b", "aabb,''", "abb,a", "aba,aba", "abba,''", "abbbaac,abc", "abbacaasdasssssdddfaasddddkkkddssasasassa,csdasdfskasas"})
    void removeDuplicates(String s, String result) {
        Assertions.assertEquals(result, new Q1047().removeDuplicates1(s));
        Assertions.assertEquals(result, new Q1047().removeDuplicates(s));
    }
}