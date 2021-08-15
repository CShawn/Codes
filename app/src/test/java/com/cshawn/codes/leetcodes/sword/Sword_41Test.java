package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/10 9:31 下午
 */
class Sword_41Test {
    @Test
    void test() {
        Sword_41.MedianFinder finder = new Sword_41.MedianFinder();
        assertEquals(0, finder.findMedian());
        finder.addNum(4);
        assertEquals(4, finder.findMedian());
        finder.addNum(8);
        assertEquals(6, finder.findMedian());
        finder.addNum(5);
        assertEquals(5, finder.findMedian());
        finder.addNum(5);
        assertEquals(5, finder.findMedian());
        finder.addNum(7);
        assertEquals(5, finder.findMedian());
        finder.addNum(6);
        assertEquals(5.5, finder.findMedian());
    }
    @Test
    void test2() {
        Sword_41.MedianFinder finder = new Sword_41.MedianFinder();
        assertEquals(0, finder.findMedian());
        finder.addNum(-1);
        assertEquals(-1, finder.findMedian());
        finder.addNum(-2);
        assertEquals(-1.5, finder.findMedian());
        finder.addNum(-3);
        assertEquals(-2, finder.findMedian());
        finder.addNum(-4);
        assertEquals(-2.5, finder.findMedian());
        finder.addNum(-5);
        assertEquals(-3, finder.findMedian());
    }
}