package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/16 9:49 下午
 */
class Q87Test {

    @ParameterizedTest
    @CsvSource({"great,rgeat,true", "abcde,caebd,false", "a,a,true", "a,b,false"})
    void isScramble(String s1, String s2, boolean result) {
        Assertions.assertEquals(result, new Q87().isScramble(s1, s2));
    }
}