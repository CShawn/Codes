package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
/**
 * @author C.Shawn
 * @date 2021/1/31 2:17 下午
 */
class Sword_49Test {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2", "3,3", "4,4", "5,5", "6,6", "7,8", "15,24"})
    void nthUglyNumber(int n, int num) {
        Assertions.assertEquals(num, new Sword_49().nthUglyNumber(n));
    }
}