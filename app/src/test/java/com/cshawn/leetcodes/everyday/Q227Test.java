package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/11 6:33 下午
 */
class Q227Test {

    @ParameterizedTest
    @CsvSource({"3+2* 2,7", " 3/2 ,1", " 3+5 / 2 ,5"})
    void calculate(String s, int result) {
        Assertions.assertEquals(result, new Q227().calculate(s));
    }
}