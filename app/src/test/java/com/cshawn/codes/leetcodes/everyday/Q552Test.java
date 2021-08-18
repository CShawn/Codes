package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/18 3:50 下午
 */
class Q552Test {

    @ParameterizedTest
    @CsvSource({"1,3", "2,8", "10101,183236316"})
    void checkRecord(int n, int result) {
        Assertions.assertEquals(result, new Q552().checkRecord1(n));
        Assertions.assertEquals(result, new Q552().checkRecord(n));
    }
}