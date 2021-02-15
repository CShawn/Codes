package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/15 5:19 下午
 */
class Q7Test {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "-1,-1", "12,21", "-23,-32", "100,1", "-230,-32", "1463847412,2147483641", "746384741,147483647", "-746384741,-147483647", "1463847418,0", "-1463847418,0", "-1563847412,0"})
    void reverse(int x, int result) {
        Assertions.assertEquals(result, new Q7().reverse1(x));
        Assertions.assertEquals(result, new Q7().reverse(x));
    }
}