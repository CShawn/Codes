package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/9/12 12:02 下午
 */
class Q678Test {

    @ParameterizedTest
    @CsvSource({"(),true", "(*),true", "(*)),true", ")(,false", "*(,false"})
    void checkValidString(String s, boolean result) {
        assertEquals(result, new Q678().checkValidString1(s));
        assertEquals(result, new Q678().checkValidString(s));
    }
}