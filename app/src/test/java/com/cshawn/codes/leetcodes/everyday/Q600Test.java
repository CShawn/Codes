package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/9/11 10:24 上午
 */
class Q600Test {

    @ParameterizedTest
    @CsvSource({"1,2","2,3","3,3","4,4","5,5", "6,5","7,5","8,6","9,7","10,8",
            "11,8","12,8","13,8","14,8", "15,8","345,89","1000000000,2178309"})
    void findIntegers(int n, int result) {
        assertEquals(result, new Q600().findIntegers(n));
    }
}