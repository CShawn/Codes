package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/1 8:10 下午
 */
class Q1006Test {

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,6", "4,7", "5,7", "6,8", "7,6", "8,9", "9,11", "10,12", "11,10"})
    void clumsy(int n, int result) {
        Assertions.assertEquals(result, new Q1006().clumsy1(n));
        Assertions.assertEquals(result, new Q1006().clumsy2(n));
        Assertions.assertEquals(result, new Q1006().clumsy3(n));
        Assertions.assertEquals(result, new Q1006().clumsy(n));
    }
}