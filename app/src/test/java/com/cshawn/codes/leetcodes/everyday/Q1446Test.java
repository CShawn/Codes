package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/12/1 8:55 上午
 */
class Q1446Test {

    @ParameterizedTest
    @CsvSource({"leetcode,2", "abbcccddddeeeeedcba,5", "triplepillooooow,5", "hooraaaaaaaaaaay,11", "tourist,1", "a,1", "ab,1"})
    void maxPower(String s, int result) {
        assertEquals(result, new Q1446().maxPower(s));
    }
}