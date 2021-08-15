package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/15 5:23 下午
 */
class Q205Test {

    @ParameterizedTest
    @CsvSource({"egg,add,true", "foo,bar,false", "a,a,true", "aa,ac,false", "12,34,true", "bae,bab,false", "badc,baba,false"})
    void isIsomorphic(String s, String t, boolean result) {
        Assertions.assertEquals(result, new Q205().isIsomorphic1(s, t));
        Assertions.assertEquals(result, new Q205().isIsomorphic(s, t));
    }
}