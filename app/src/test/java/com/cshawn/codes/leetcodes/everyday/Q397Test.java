package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/19 5:41 下午
 */
class Q397Test {

    @ParameterizedTest
    @CsvSource({"1,0", "2,1", "3,2","4,2", "7,4", "8,3"})
    void integerReplacement(int n, int result) {
        assertEquals(result, new Q397().integerReplacement1(n));
        assertEquals(result, new Q397().integerReplacement(n));
    }
}