package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/27 11:03 下午
 */
class Q395Test {

    @ParameterizedTest
    @CsvSource({"aaabb,3,3", "ababbc,2,5", "abacabab,2,4"})
    void longestSubstring(String s, int k, int result) {
        Assertions.assertEquals(result, new Q395().longestSubstring(s, k));
    }
}