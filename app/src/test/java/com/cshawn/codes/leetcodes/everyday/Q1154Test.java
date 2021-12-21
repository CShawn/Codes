package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/12/21 8:32 上午
 */
class Q1154Test {

    @ParameterizedTest
    @CsvSource({"2019-01-09,9", "2019-02-10,41", "2003-03-01,60", "2004-03-01,61"})
    void dayOfYear(String date, int result) {
        assertEquals(result, new Q1154().dayOfYear(date));
    }
}