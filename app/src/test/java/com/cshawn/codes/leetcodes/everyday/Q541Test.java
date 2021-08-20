package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/20 4:35 下午
 */
class Q541Test {

    @ParameterizedTest
    @CsvSource({"abcdefg,2,bacdfeg", "abcd,2,bacd", "abcdefg,4,dcbaefg","abcdefghij,4,dcbaefghji"})
    void reverseStr(String s, int k, String result) {
        Assertions.assertEquals(result, new Q541().reverseStr(s, k));
    }
}