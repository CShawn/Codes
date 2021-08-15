package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/28 11:22 上午
 */
class Q5716Test {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2", "3,3", "5,6", "8,18", "18,729", "73,572712676", "99,527642103" , "109,995115582"})
    void maxNiceDivisors(int n, int result) {
        Assertions.assertEquals(result, new Q5716().maxNiceDivisors(n));
    }
}