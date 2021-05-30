package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/30 12:06 下午
 */
class Q5772Test {

    @ParameterizedTest
    @CsvSource({"acb,cba,cdb,true", "aaa,a,aab,false", "aaa,a,aaaa,true"})
    void isSumEqual(String firstWord, String secondWord, String targetWord, boolean result) {
        Assertions.assertEquals(result, new Q5772().isSumEqual(firstWord, secondWord, targetWord));
    }
}