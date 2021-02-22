package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/22 10:56 下午
 */
class Q1_3Test {

    @ParameterizedTest
    @CsvSource({",3,", ",0,", "'',3,''", "'1  2    ',4,1%20%202", "'    ',2,%20%20"})
    void replaceSpaces1(String s, int count, String result) {
        Assertions.assertEquals(result, new Q1_3().replaceSpaces1(s, count));
    }

    @ParameterizedTest
    @CsvSource({"'1  2     ',4,1%20%202", "'       ',2,%20%20"})
    void replaceSpaces(String s, int count, String result) {
        Assertions.assertEquals(result, new Q1_3().replaceSpaces(s, count));
    }
}