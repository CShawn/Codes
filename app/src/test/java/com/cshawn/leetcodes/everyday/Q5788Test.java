package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/6/20 12:26 下午
 */
class Q5788Test {

    @ParameterizedTest
    @CsvSource({"4,''", "52,5", "4206,''", "35427,35427", "35427666,35427"})
    void largestOddNumber(String num, String result) {
        Assertions.assertEquals(result, new Q5788().largestOddNumber(num));
    }
}