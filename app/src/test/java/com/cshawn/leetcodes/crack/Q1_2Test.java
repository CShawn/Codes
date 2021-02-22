package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/22 10:29 下午
 */
class Q1_2Test {

    @ParameterizedTest
    @CsvSource({",,false", "'','',true", ",'',false", "'',,false", "a,b,false", "a,a,true", "ab,ba,true", "ab,ac,false"})
    void checkPermutation(String s1, String s2, boolean result) {
        Assertions.assertEquals(result, new Q1_2().CheckPermutation(s1, s2));
        Assertions.assertEquals(result, new Q1_2().CheckPermutation1(s1, s2));
        Assertions.assertEquals(result, new Q1_2().CheckPermutation2(s1, s2));
    }
}