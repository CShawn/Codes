package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/30 8:45 上午
 */
class Q400Test {

    @ParameterizedTest
    @CsvSource({"3,3", "11,0", "16,1", "196,1", "198,2", "1834594835,8"})
    void findNthDigit(int n, int result) {
        assertEquals(result, new Q400().findNthDigit1(n));
        assertEquals(result, new Q400().findNthDigit(n));
    }
}