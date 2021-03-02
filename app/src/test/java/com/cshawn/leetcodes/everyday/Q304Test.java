package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/3/2 10:31 上午
 */
class Q304Test {

    @Test
    void test1() {
        Q304.NumMatrix test = new Q304().new NumMatrix(new int[0][]);
        assertEquals(0, test.sumRegion(0, 0, 0, 0));
        assertEquals(0, test.sumRegion(0, 0, 3, 4));
    }

    @Test
    void test2() {
        Q304.NumMatrix test = new Q304().new NumMatrix(new int[][]{new int[]{1}});
        assertEquals(1, test.sumRegion(0, 0, 0, 0));
        assertEquals(1, test.sumRegion(0, 0, 3, 4));
        assertEquals(0, test.sumRegion(0, 1, 3, 4));
        assertEquals(0, test.sumRegion(0, 4, 3, 0));
        assertEquals(0, test.sumRegion(3, 0, 0, 4));
    }

    @Test
    void test3() {
        Q304.NumMatrix test = new Q304().new NumMatrix(new int[][]{new int[]{1, 2, 3}});
        assertEquals(1, test.sumRegion(0, 0, 0, 0));
        assertEquals(3, test.sumRegion(0, 0, 0, 1));
        assertEquals(6, test.sumRegion(0, 0, 0, 2));
        assertEquals(6, test.sumRegion(0, 0, 0, 3));
        assertEquals(2, test.sumRegion(0, 1, 0, 1));
        assertEquals(5, test.sumRegion(0, 1, 0, 2));
    }

    @Test
    void test4() {
        Q304.NumMatrix test = new Q304().new NumMatrix(new int[][]{new int[]{1}, new int[]{2}, new int[]{3}});
        assertEquals(1, test.sumRegion(0, 0, 0, 0));
        assertEquals(3, test.sumRegion(0, 0, 1, 0));
        assertEquals(6, test.sumRegion(0, 0, 2, 0));
        assertEquals(2, test.sumRegion(1, 0, 1, 0));
        assertEquals(5, test.sumRegion(1, 0, 2, 0));
        assertEquals(5, test.sumRegion(1, 0, 3, 0));
    }

    @Test
    void test5() {
        Q304.NumMatrix test = new Q304().new NumMatrix(new int[][]{new int[]{1, 2}, new int[]{3,4}});
        assertEquals(1, test.sumRegion(0, 0, 0, 0));
        assertEquals(2, test.sumRegion(0, 1, 0, 1));
        assertEquals(3, test.sumRegion(1, 0, 1, 0));
        assertEquals(4, test.sumRegion(1, 1, 1, 1));
        assertEquals(3, test.sumRegion(0, 0, 0, 1));
        assertEquals(4, test.sumRegion(0, 0, 1, 0));
        assertEquals(10, test.sumRegion(0, 0, 1, 1));
        assertEquals(7, test.sumRegion(1, 0, 1, 1));
        assertEquals(6, test.sumRegion(0, 1, 1, 1));
    }
}