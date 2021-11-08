package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/8 8:16 上午
 */
class Q299Test {

    @ParameterizedTest
    @CsvSource({"1807,7810,1A3B", "1123,0111,1A1B", "1,0,0A0B", "1,1,1A0B"})
    void getHint(String secret, String guess, String result) {
        assertEquals(result, new Q299().getHint1(secret, guess));
        assertEquals(result, new Q299().getHint(secret, guess));
    }
}