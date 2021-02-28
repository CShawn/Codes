package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/2/28 22:41
 */
public class Q3_2Test {
    
    @Test
    void test1() {
        Q3_2.MinStack1 minStack = new Q3_2().new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(0, minStack.top());
        Assertions.assertEquals(minStack.getMin(), -2);
    }

    @Test
    void test() {
        Q3_2.MinStack minStack = new Q3_2().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(0, minStack.top());
        Assertions.assertEquals(minStack.getMin(), -2);
    }
}
