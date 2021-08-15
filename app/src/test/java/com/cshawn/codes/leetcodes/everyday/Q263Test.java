package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/10 8:10 下午
 */
class Q263Test {

    @ParameterizedTest
    @CsvSource({"-3,false", "0,false", "1,true", "2,true", "3,true", "4,true", "5,true", "7,false"})
    void isUgly(int n, boolean isUgly) {
        Assertions.assertEquals(isUgly, new Q263().isUgly(n));
    }
}