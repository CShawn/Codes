package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/12 5:02 下午
 */
class Q375Test {

    @ParameterizedTest
    @CsvSource({"1,0", "2,1", "10,16"})
    void getMoneyAmount(int n, int result) {
        assertEquals(result, new Q375().getMoneyAmount(n));
    }
}