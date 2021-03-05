package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/3/5 5:19 下午
 */
class Q232Test {
    @Test
    void test() {
        Q232.MyQueue queue = new Q232().new MyQueue();
        Assertions.assertTrue(queue.empty());
        queue.push(1);
        Assertions.assertFalse(queue.empty());
        queue.push(2);
        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.pop());
        queue.push(3);
        Assertions.assertEquals(2, queue.pop());
        Assertions.assertEquals(3, queue.pop());
        Assertions.assertTrue(queue.empty());
    }
}