package com.cshawn.codes.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/18 10:34 下午
 */
class Q5_6Test {

    @ParameterizedTest
    @CsvSource({"-34,29,28", "1,1,0", "29,15,2"})
    void convertInteger(int a, int b, int result) {
        Assertions.assertEquals(result, new Q5_6().convertInteger1(a, b));
        Assertions.assertEquals(result, new Q5_6().convertInteger(a, b));
    }
}