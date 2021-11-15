package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/15 8:35 上午
 */
class Q319Test {

    @ParameterizedTest
    @CsvSource({"1,1", "2,1", "3,1", "4,2", "9,3", "10,3", "100,10"})
    void bulbSwitch(int n, int result) {
        assertEquals(result, new Q319().bulbSwitch(n));
    }
}