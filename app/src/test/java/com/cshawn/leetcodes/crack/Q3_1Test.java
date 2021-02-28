package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3_1Test {
    
    @Test
    void test() {
        Q3_1.TripleInOne test = new Q3_1().new TripleInOne(0);
        test.push(0, 1);
        test.push(0, 2);
        Assertions.assertEquals(-1, test.pop(0));
        Assertions.assertEquals(-1, test.pop(0));
        Assertions.assertEquals(-1, test.pop(0));
        Assertions.assertEquals(true, test.isEmpty(0));
    }

    @Test
    void test1() {
        Q3_1.TripleInOne test = new Q3_1().new TripleInOne(1);
        test.push(0, 1);
        test.push(0, 2);
        Assertions.assertEquals(1, test.pop(0));
        Assertions.assertEquals(-1, test.pop(0));
        Assertions.assertEquals(-1, test.pop(0));
        Assertions.assertEquals(true, test.isEmpty(0));
    }
    
    @Test
    void test2() {
        Q3_1.TripleInOne test = new Q3_1().new TripleInOne(2);
        Assertions.assertEquals(true, test.isEmpty(0));
        test.push(0, 1);
        Assertions.assertEquals(false, test.isEmpty(0));
        Assertions.assertEquals(1, test.pop(0));
        Assertions.assertEquals(true, test.isEmpty(0));
        test.push(0, 1);
        test.push(0, 2);
        test.push(0, 3);
        Assertions.assertEquals(2, test.pop(0));
        Assertions.assertEquals(1, test.peek(0));
        Assertions.assertEquals(-1, test.peek(1));
        Assertions.assertEquals(1, test.pop(0));
        Assertions.assertEquals(-1, test.pop(0));
        Assertions.assertEquals(-1, test.pop(0));
        Assertions.assertEquals(true, test.isEmpty(0));
        test.push(1, 3);
        Assertions.assertEquals(false, test.isEmpty(1));
        Assertions.assertEquals(3, test.peek(1));
    }
}
