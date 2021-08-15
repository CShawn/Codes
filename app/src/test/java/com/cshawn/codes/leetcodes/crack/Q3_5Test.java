package com.cshawn.codes.leetcodes.crack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/3/1 9:07 下午
 */
class Q3_5Test {
    @Test
    void test() {
        Q3_5.SortedStack test = new Q3_5().new SortedStack();
        assertTrue(test.isEmpty());
        test.pop();
        assertEquals(-1, test.peek());
        test.push(1);
        test.push(2);
        assertEquals(1, test.peek());
        test.pop();
        assertEquals(2, test.peek());
        test.push(3);
        assertEquals(2, test.peek());
        assertFalse(test.isEmpty());
    }
}