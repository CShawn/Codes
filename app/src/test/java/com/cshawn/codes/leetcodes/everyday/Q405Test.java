package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/10/2 11:11 上午
 */
class Q405Test {

    @ParameterizedTest
    @CsvSource({"26,1a", "-1,ffffffff", "0,0", "9,9", "14,e"})
    void toHex(int num, String result) {
        assertEquals(result, new Q405().toHex(num));
    }
}