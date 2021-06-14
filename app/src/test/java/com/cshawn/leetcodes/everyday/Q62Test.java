package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/6/14 1:15 下午
 */
class Q62Test {
    @ParameterizedTest
    @CsvSource({"3,7,28", "7,3,28", "3,2,3", "3,3,6", "23,12,193536720"})
    void uniquePaths(int m, int n, int result) {
        Assertions.assertEquals(result, new Q62().uniquePaths1(m, n));
        Assertions.assertEquals(result, new Q62().uniquePaths2(m, n));
        Assertions.assertEquals(result, new Q62().uniquePaths3(m, n));
        Assertions.assertEquals(result, new Q62().uniquePaths(m, n));
    }
}