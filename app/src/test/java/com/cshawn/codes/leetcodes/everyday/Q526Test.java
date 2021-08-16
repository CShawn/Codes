package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/16 3:06 下午
 */
class Q526Test {

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "4,8", "15,24679"})
    void countArrangement(int n, int result) {
        Assertions.assertEquals(result, new Q526().countArrangement1(n));
        Assertions.assertEquals(result, new Q526().countArrangement(n));
    }
}