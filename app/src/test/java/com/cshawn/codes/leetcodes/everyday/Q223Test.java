package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/9/30 10:44 上午
 */
class Q223Test {

    @ParameterizedTest
    @CsvSource({"-3,0,3,4,0,-1,9,2,45",
            "-2,-2,2,2,-2,-2,2,2,16",
            "0,0,2,2,0,0,1,1,4",
            "0,0,3,3,1,1,2,2,9",
            "-2,-2,2,2,-1,4,1,6,20",
            "0,0,1,1,0,1,1,2,2"})
    void computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2, int result) {
        Assertions.assertEquals(result, new Q223().computeArea1(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
        Assertions.assertEquals(result, new Q223().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}