package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/3/6 10:59 下午
 */
class Q556Test {

    @ParameterizedTest
    @CsvSource({"1,-1", "12,21", "21,-1", "123,132", "132,213", "213,231", "231,312", "312,321", "321,-1", "2147483486,-1", "1999999999,-1"})
    void nextGreaterElement(int n, int result) {
        assertEquals(result, new Q556().nextGreaterElement(n));
    }
}