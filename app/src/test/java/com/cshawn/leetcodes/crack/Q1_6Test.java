package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/24 10:27 上午
 */
class Q1_6Test {

    @ParameterizedTest
    @CsvSource({",", "'',''", "a,a", "aa,aa", "ab,ab", "aabcccccaaa,a2b1c5a3", "abbccd,abbccd"})
    void compressString(String s, String result) {
        Assertions.assertEquals(result, new Q1_6().compressString(s));
    }
}