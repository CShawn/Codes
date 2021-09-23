package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/9/23 9:10 上午
 */
class Q326Test {

    @ParameterizedTest
    @CsvSource({"0,false", "1,true", "2,false", "3,true", "6,false", "9,true","18,false","27,true", "-1,false", "-3,false", "243,true"})
    void isPowerOfThree(int n, boolean result) {
        Assertions.assertEquals(result, new Q326().isPowerOfThree1(n));
        Assertions.assertEquals(result, new Q326().isPowerOfThree2(n));
        Assertions.assertEquals(result, new Q326().isPowerOfThree(n));
    }
}