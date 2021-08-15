package com.cshawn.codes.leetcodes.crack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/3/1 9:31 下午
 */
class Q3_6Test {
    @Test
    void test() {
        Q3_6.AnimalShelf test = new Q3_6().new AnimalShelf();
        assertArrayEquals(new int[]{-1,-1}, test.dequeueCat());
        assertArrayEquals(new int[]{-1,-1}, test.dequeueDog());
        assertArrayEquals(new int[]{-1,-1}, test.dequeueAny());
        test.enqueue(new int[]{0,0});
        test.enqueue(new int[]{1,1});
        test.enqueue(new int[]{2,0});
        test.enqueue(new int[]{3,1});
        assertArrayEquals(new int[]{0,0}, test.dequeueAny());
        assertArrayEquals(new int[]{1,1}, test.dequeueDog());
        assertArrayEquals(new int[]{2,0}, test.dequeueCat());
        assertArrayEquals(new int[]{3,1}, test.dequeueAny());
        assertArrayEquals(new int[]{-1,-1}, test.dequeueAny());
    }
}