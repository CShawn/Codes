package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/15 6:15 下午
 */
class Q8Test {

    @ParameterizedTest
    @CsvSource({",0", "'',0", "   ,0", "   1,1", "  -1  ,-1", "  4 3,4", "  - 3,0", " 4.5,4", "  e3,0", "23322324545545545,2147483647", "-23322324545545545,-2147483648"})
    void myAtoi(String s, int n) {
        Assertions.assertEquals(n, new Q8().myAtoi(s));
    }
}