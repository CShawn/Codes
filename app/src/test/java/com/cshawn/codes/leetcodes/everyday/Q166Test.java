package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/10/3 11:41 上午
 */
class Q166Test {

    @ParameterizedTest
    @CsvSource({"1,2,0.5", "2,1,2", "2,3,0.(6)", "4,333,0.(012)", "1,-5,-0.2", "-1,-2147483648,0.0000000004656612873077392578125"})
    void fractionToDecimal(int numerator, int denominator, String result) {
        assertEquals(result, new Q166().fractionToDecimal(numerator, denominator));
    }
}