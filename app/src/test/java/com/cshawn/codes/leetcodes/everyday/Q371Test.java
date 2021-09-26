package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/9/26 4:04 下午
 */
class Q371Test {

    @ParameterizedTest
    @CsvSource({"1,1,2", "1,-1,0", "1,0,1", "1,-3,-2", "-1000,-1000,-2000", "1000,1000,2000"})
    void getSum(int a, int b, int result) {
        assertEquals(result, new Q371().getSum1(a, b));
        assertEquals(result, new Q371().getSum(a, b));
    }
}