package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/6/18 9:13 下午
 */
class Q483Test {

    @ParameterizedTest
    @CsvSource({"3,2", "13,3", "4681,8", "1000000000000000000,999999999999999999"})
    void smallestGoodBase1(String n, String result) {
        Assertions.assertEquals(result, new Q483().smallestGoodBase1(n));
        Assertions.assertEquals(result, new Q483().smallestGoodBase(n));
        Assertions.assertEquals(result, new Q483().smallestGoodBase2(n));
    }
}