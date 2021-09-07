package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/9/7 12:49 下午
 */
class Q1221Test {

    @ParameterizedTest
    @CsvSource({"RLRRLLRLRL,4", "RLLLLRRRLR,3", "LLLLRRRR,1", "RLRRRLLRLL,2"})
    void balancedStringSplit(String s, int result) {
        assertEquals(result, new Q1221().balancedStringSplit(s));
    }
}