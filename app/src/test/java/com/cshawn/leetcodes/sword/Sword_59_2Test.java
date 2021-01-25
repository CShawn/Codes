package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/1/25 10:03 下午
 */
class Sword_59_2Test {
    @Test
    void test() {
        Sword_59_2.MaxQueue maxQueue = new Sword_59_2.MaxQueue();
        Assertions.assertEquals(-1, maxQueue.max_value());
        Assertions.assertEquals(-1, maxQueue.pop_front());
        maxQueue.push_back(3);
        Assertions.assertEquals(3, maxQueue.max_value());
        maxQueue.push_back(3);
        Assertions.assertEquals(3, maxQueue.max_value());
        maxQueue.push_back(2);
        Assertions.assertEquals(3, maxQueue.max_value());
        maxQueue.push_back(42);
        Assertions.assertEquals(42, maxQueue.max_value());
        Assertions.assertEquals(3, maxQueue.pop_front());
        Assertions.assertEquals(3, maxQueue.pop_front());
        Assertions.assertEquals(2, maxQueue.pop_front());
        Assertions.assertEquals(42, maxQueue.max_value());
    }
}