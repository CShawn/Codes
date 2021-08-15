package com.cshawn.codes.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/22 10:25 下午
 */
class Q1_1Test {

    @ParameterizedTest
    @CsvSource({",true", "'',true", "a,true", "aa,false", "abc, true", "aba,false"})
    void isUnique(String s, boolean result) {
        Assertions.assertEquals(result, new Q1_1().isUnique(s));
    }
}