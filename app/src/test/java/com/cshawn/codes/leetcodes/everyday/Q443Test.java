package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/21 3:54 下午
 */
class Q443Test {

    @ParameterizedTest
    @CsvSource({"a,a","aa,a2", "ab,ab", "aaa,a3", "abc,abc", "abcc,abc2", "aabbccc,a2b2c3"})
    void compress(String str, String res) {
        char[] chars1 = str.toCharArray();
        int count1 = new Q443().compress1(chars1);
        Assertions.assertEquals(res, new String(chars1, 0, count1));
        char[] chars = str.toCharArray();
        int count = new Q443().compress(chars);
        Assertions.assertEquals(res, new String(chars, 0, count));
    }
}