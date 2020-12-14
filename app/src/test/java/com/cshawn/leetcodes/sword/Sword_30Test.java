package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: C.Shawn
 * @date: 2020/12/14 21:37
 */
class Sword_30Test {
    private final Sword_30 test = new Sword_30();
    @Test
    void test() {
        test.push(2);
        assertEquals(2, test.top());
        assertEquals(2, test.min());
        test.push(1);
        assertEquals(1, test.top());
        assertEquals(1, test.min());
        test.push(3);
        assertEquals(3, test.top());
        assertEquals(1, test.min());
        test.pop();
        assertEquals(1, test.top());
        assertEquals(1, test.min());
        test.pop();
        assertEquals(2, test.top());
        assertEquals(2, test.min());
    }
}