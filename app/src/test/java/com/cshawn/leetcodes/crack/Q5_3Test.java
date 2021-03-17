package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/17 11:16 下午
 */
class Q5_3Test {

    @ParameterizedTest
    @CsvSource({"1775,8", "7,4", "0,1", "1,2", "2,2"})
    void reverseBits(int num, int result) {
        Assertions.assertEquals(result, new Q5_3().reverseBits(num));
    }
}