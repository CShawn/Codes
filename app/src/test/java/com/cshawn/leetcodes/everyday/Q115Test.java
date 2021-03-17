package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/17 5:48 下午
 */
class Q115Test {

    @ParameterizedTest
    @CsvSource({"babgbag,bag,5", "rabbbit,rabbit,3", ",,0", "'','',1"})
    void numDistinct(String s, String t, int result) {
        Assertions.assertEquals(result, new Q115().numDistinct1(s, t));
        Assertions.assertEquals(result, new Q115().numDistinct(s, t));
    }
}