package com.cshawn.codes.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/3/1 8:53 下午
 */
class Q3_4Test {

    @Test
    void test() {
        Q3_4.MyQueue test = new Q3_4().new MyQueue();
        assertTrue(test.empty());
        test.push(1);
        test.push(2);
        test.push(3);
        assertEquals(1, test.pop());
        assertEquals(2, test.pop());
        test.push(4);
        assertEquals(3, test.pop());
        assertEquals(4, test.peek());
        Assertions.assertFalse(test.empty());
        assertEquals(4, test.pop());
        Assertions.assertTrue(test.empty());
    }
}