package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/8/27 8:50 上午
 */
class Q295Test {
    @Test
    void test1() {
        Q295.MedianFinder1 test = new Q295.MedianFinder1();
        test.addNum(1);
        assertEquals(1, test.findMedian());
        test.addNum(2);
        assertEquals(1.5, test.findMedian());
        test.addNum(3);
        assertEquals(2, test.findMedian());
        test.addNum(4);
        assertEquals(2.5, test.findMedian());
        test.addNum(0);
        assertEquals(2, test.findMedian());
        test.addNum(3);
        assertEquals(2.5, test.findMedian());
        test.addNum(3);
        assertEquals(3, test.findMedian());
    }
    @Test
    void test() {
        Q295.MedianFinder test = new Q295.MedianFinder();
        test.addNum(1);
        assertEquals(1, test.findMedian());
        test.addNum(2);
        assertEquals(1.5, test.findMedian());
        test.addNum(3);
        assertEquals(2, test.findMedian());
        test.addNum(4);
        assertEquals(2.5, test.findMedian());
        test.addNum(0);
        assertEquals(2, test.findMedian());
        test.addNum(3);
        assertEquals(2.5, test.findMedian());
        test.addNum(3);
        assertEquals(3, test.findMedian());
    }
}