package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/26 10:22 下午
 */
class Q1190Test {

    @ParameterizedTest
    @CsvSource({"'',''", "(abcd),dcba", "(u(love)i),iloveu", "(ed(et(oc))el),leetcode", "a(bcdefghijkl(mno)p)q,apmnolkjihgfedcbq", "((ab)c(d)e),edcab"})
    void reverseParentheses(String s, String result) {
        Assertions.assertEquals(result, new Q1190().reverseParentheses(s));
    }
}