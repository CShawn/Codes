package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/31 20:22
 */
public class Q342Test {
    @ParameterizedTest
    @CsvSource({"-1,false", "0,false", "1,true", "2,false", "3,false", "4,true", "5,false", "8,false", "16,true"})
    void isPowerOfFour(int n, boolean result) {
        Assertions.assertEquals(result, new Q342().isPowerOfFour(n));
    }
}
