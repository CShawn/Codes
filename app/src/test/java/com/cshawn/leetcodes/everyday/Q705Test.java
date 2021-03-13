package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/3/13 10:43 上午
 */
class Q705Test {
    @Test
    void test() {
        Q705.MyHashSet myHashSet = new Q705().new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        Assertions.assertTrue(myHashSet.contains(1));
        Assertions.assertFalse(myHashSet.contains(3));
        myHashSet.add(2);
        Assertions.assertTrue(myHashSet.contains(2));
        myHashSet.remove(2);
        myHashSet.remove(9);
        Assertions.assertFalse(myHashSet.contains(2));
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(5);
        myHashSet.add(6);
        myHashSet.add(7);
        myHashSet.add(8);
        myHashSet.add(9);
        myHashSet.add(11);
        myHashSet.add(12);
        myHashSet.add(13);
        myHashSet.add(14);
        myHashSet.add(15);
        myHashSet.add(16);
        myHashSet.add(17);
        Assertions.assertTrue(myHashSet.contains(17));
    }
}