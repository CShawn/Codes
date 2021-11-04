package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/4 8:15 上午
 */
class Q367Test {

    @ParameterizedTest
    @CsvSource({"1,true", "2,false", "3,false", "4,true", "8,false", "9,true", "14,false","16,true", "808201,true"})
    void isPerfectSquare(int num, boolean result) {
        assertEquals(result, new Q367().isPerfectSquare(num));
    }
}