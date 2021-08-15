package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/12 3:51 下午
 */
class Q576Test {

    @ParameterizedTest
    @CsvSource({"2,2,2,0,0,6", "1,3,3,0,1,12"})
    void findPaths(int m, int n, int maxMove, int startRow, int startColumn, int result) {
        Assertions.assertEquals(result, new Q576().findPaths(m, n, maxMove, startRow, startColumn));
    }
}