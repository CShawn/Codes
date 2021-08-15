package com.cshawn.codes.leetcodes.crack;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/23 10:27 下午
 */
class Q1_5Test {

    @ParameterizedTest
    @CsvSource({",,false", ",'',false", "'',,false", "aa,ab,true", "ab,acd,false", "abc,abd,true"})
    void oneEditAway(String first, String second, boolean result) {
        Assertions.assertEquals(result, new Q1_5().oneEditAway(first, second));
    }
}