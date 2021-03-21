package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/18 9:52 下午
 */
class Q5_4Test {

    @ParameterizedTest
    @CsvSource({"2,4,1", "1,2,-1", "7,11,-1", "11,13,7", "9,10,6", "15,23,-1", "244,248,242"})
    void findClosedNumbers(int num ,int big, int small) {
        Assertions.assertArrayEquals(new int[]{big, small}, new Q5_4().findClosedNumbers(num));
    }
}