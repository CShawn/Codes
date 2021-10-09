package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/10/9 4:53 下午
 */
class Q352Test {
    @Test
    void test() {
        Q352.SummaryRanges test = new Q352.SummaryRanges();
        test.addNum(1);
        assertArrayEquals(new int[][]{{1,1}}, test.getIntervals());
        test.addNum(3);
        assertArrayEquals(new int[][]{{1,1}, {3,3}}, test.getIntervals());
        test.addNum(3);
        assertArrayEquals(new int[][]{{1,1}, {3,3}}, test.getIntervals());
        test.addNum(7);
        assertArrayEquals(new int[][]{{1,1}, {3,3}, {7,7}}, test.getIntervals());
        test.addNum(2);
        assertArrayEquals(new int[][]{{1,3}, {7,7}}, test.getIntervals());
        test.addNum(6);
        assertArrayEquals(new int[][]{{1,3}, {6,7}}, test.getIntervals());
    }
}