package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/11 10:52 上午
 */
class Q5727Test {

    @ParameterizedTest
    @CsvSource({"5,2,3", "6,5,1"})
    void findTheWinner(int n, int k, int result) {
        Assertions.assertEquals(result, new Q5727().findTheWinner1(n, k));
        Assertions.assertEquals(result, new Q5727().findTheWinner(n, k));
    }
}