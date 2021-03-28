package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/28 7:10 下午
 */
class Q8_5Test {

    @ParameterizedTest
    @CsvSource({"3,4,12", "1,4,4", "0,4,0", "2,0,0", "3,1,3", "5,8,40"})
    void multiply(int a, int b, int result) {
        Assertions.assertEquals(result, new Q8_5().multiply1(a, b));
        Assertions.assertEquals(result, new Q8_5().multiply(a, b));
    }
}