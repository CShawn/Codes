package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/7 11:18 上午
 */
class Q1486Test {

    @ParameterizedTest
    @CsvSource({"5,0,8", "4,3,8", "1,7,7", "10,5,2"})
    void xorOperation(int n, int start , int result) {
        Assertions.assertEquals(result, new Q1486().xorOperation(n, start));
    }
}