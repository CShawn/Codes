package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/21 10:12 下午
 */
class Q8_1Test {

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,4", "4,7", "5,13", "1000000,746580045"})
    void waysToStep(int n, int result) {
        Assertions.assertEquals(result, new Q8_1().waysToStep(n));
    }
}