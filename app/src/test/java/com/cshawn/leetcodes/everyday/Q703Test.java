package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q703Test {

    @Test
    void test() {
        Q703.KthLargest q = new Q703.KthLargest(2, new int[]{1,2});
        Assertions.assertEquals(1, q.add(1));
        Assertions.assertEquals(1, q.add(1));
        Assertions.assertEquals(2, q.add(2));
        Assertions.assertEquals(2, q.add(3));
        Assertions.assertEquals(2, q.add(2));
        Assertions.assertEquals(2, q.add(2));
        Assertions.assertEquals(3, q.add(4));
    }

    @Test
    void test2() {
        Q703.KthLargest q = new Q703.KthLargest(3, new int[]{4,5,8,2});
        Assertions.assertEquals(4, q.add(3));
        Assertions.assertEquals(5, q.add(5));
        Assertions.assertEquals(5, q.add(10));
        Assertions.assertEquals(8, q.add(9));
        Assertions.assertEquals(8, q.add(4));
    }

    @Test
    void test3() {
        Q703.KthLargest q = new Q703.KthLargest(3, new int[0]);
        Assertions.assertEquals(-1, q.add(3));
        Assertions.assertEquals(-1, q.add(5));
        Assertions.assertEquals(3, q.add(10));
        Assertions.assertEquals(5, q.add(9));
        Assertions.assertEquals(5, q.add(4));
    }

    @Test
    void test4() {
        Q703.KthLargest q = new Q703.KthLargest(3, new int[]{1,1});
        Assertions.assertEquals(1, q.add(1));
        Assertions.assertEquals(1, q.add(1));
        Assertions.assertEquals(1, q.add(3));
        Assertions.assertEquals(1, q.add(3));
        Assertions.assertEquals(3, q.add(3));
        Assertions.assertEquals(3, q.add(4));
        Assertions.assertEquals(3, q.add(4));
        Assertions.assertEquals(4, q.add(4));
    }
}
