package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/28 1:39 下午
 */
class Q343Test {

    @ParameterizedTest
    @CsvSource({"2,1", "4,4", "9,27", "10,36"})
    void integerBreak(int n, int result) {
        Assertions.assertEquals(result, new Q343().integerBreak1(n));
        Assertions.assertEquals(result, new Q343().integerBreak2(n));
        Assertions.assertEquals(result, new Q343().integerBreak(n));
    }
}