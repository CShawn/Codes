package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/12/22 10:16 上午
 */
class Q686Test {

    @ParameterizedTest
    @CsvSource({"aaac,aac,1", "aabaa,aaab,2", "abcd,cdabcdab,3", "a,aa,2", "a,a,1", "a,b,-1", "abc,b,1", "abc,d,-1", "abc,wxyz,-1"})
    void repeatedStringMatch(String a, String b, int result) {
        assertEquals(result, new Q686().repeatedStringMatch1(a, b));
        assertEquals(result, new Q686().repeatedStringMatch(a, b));
    }
}