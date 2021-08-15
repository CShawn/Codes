package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/10 8:44 下午
 */
class Q224Test {

    @ParameterizedTest
    @CsvSource({
            "1+2,3",
            "12+3,15",
            "2-1,1",
            "1+3-2,2",
            "(1+2)+3,6",
            "2+(3-1),4",
            "3+((2+3)+1),9",
            "(2+(6-3)-4)+5,6"
    })
    void calculate(String s, int result) {
        Assertions.assertEquals(result, new Q224().calculate(s));
    }
}