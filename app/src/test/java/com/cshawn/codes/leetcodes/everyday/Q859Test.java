package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/23 9:30 上午
 */
class Q859Test {

    @ParameterizedTest
    @CsvSource({"a,a,false", "ab,ba,true", "ab,ab,false", "aa,aa,true",
            "aaaaaaabc,aaaaaaacb,true", "abcdefghi,aecdbfghi,true",
            "aaaaaaaaaaaa,aaaaaaaaaaaa,true", "abac,abad,false", "a,abc,false"})
    void buddyStrings(String s, String goal, boolean result) {
        assertEquals(result, new Q859().buddyStrings(s, goal));
    }
}