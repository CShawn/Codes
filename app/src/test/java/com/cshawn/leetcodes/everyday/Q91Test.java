package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/21 9:04 下午
 */
class Q91Test {

    @ParameterizedTest
    @CsvSource({"0,0", "01,0", "30,0", "1230,0", "1,1", "12,2", "123,3", "1223,5", "12323356232210,24"})
    void numDecodings(String s, int result) {
        Assertions.assertEquals(result, new Q91().numDecodings1(s));
        Assertions.assertEquals(result, new Q91().numDecodings2(s));
        Assertions.assertEquals(result, new Q91().numDecodings(s));
    }
}