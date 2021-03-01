package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/3/1 8:30 下午
 */
class Q3_3Test {

    @Test
    void test0() {
        Q3_3.StackOfPlates test = new Q3_3().new StackOfPlates(0);
        Assertions.assertEquals(-1, test.pop());
        Assertions.assertEquals(-1, test.popAt(1));
        test.push(1);
        test.push(2);
        test.push(3);
        Assertions.assertEquals(-1, test.pop());
        Assertions.assertEquals(-1, test.popAt(0));
        Assertions.assertEquals(-1, test.popAt(1));
    }

    @Test
    void test1() {
        Q3_3.StackOfPlates test = new Q3_3().new StackOfPlates(1);
        Assertions.assertEquals(-1, test.pop());
        Assertions.assertEquals(-1, test.popAt(1));
        test.push(1);
        test.push(2);
        test.push(3);
        Assertions.assertEquals(3, test.pop());
        Assertions.assertEquals(2, test.pop());
        Assertions.assertEquals(1, test.pop());
        Assertions.assertEquals(-1, test.pop());
        test.push(1);
        test.push(2);
        test.push(3);
        Assertions.assertEquals(2, test.popAt(1));
        Assertions.assertEquals(3, test.popAt(1));
        Assertions.assertEquals(-1, test.popAt(1));
        Assertions.assertEquals(1, test.pop());
    }

    @Test
    void test2() {
        Q3_3.StackOfPlates test = new Q3_3().new StackOfPlates(2);
        test.push(1);
        test.push(2);
        test.push(3);
        Assertions.assertEquals(2, test.popAt(0));
        Assertions.assertEquals(1, test.popAt(0));
        Assertions.assertEquals(3, test.popAt(0));
        Assertions.assertEquals(-1, test.pop());
    }
}