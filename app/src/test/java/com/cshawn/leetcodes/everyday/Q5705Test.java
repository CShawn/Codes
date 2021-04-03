package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/3 11:38 下午
 */
class Q5705Test {

    @ParameterizedTest
    @CsvSource({"a1,false", "a2,true", "h3,true"})
    void squareIsWhite(String s, boolean result) {
        Assertions.assertEquals(result, new Q5705().squareIsWhite(s));
    }
}