package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/7/6 10:24 上午
 */
class Q10Test {

    @ParameterizedTest
    @CsvSource({"aa,a,false", "aa,a*,true", "ab,.*,true", "aab,c*a*b,true", "mississippi,mis*is*p*.,false"})
    void isMatch1(String s, String p, boolean result) {
        Assertions.assertEquals(result, new Q10().isMatch1(s, p));
        Assertions.assertEquals(result, new Q10().isMatch(s, p));
    }
}