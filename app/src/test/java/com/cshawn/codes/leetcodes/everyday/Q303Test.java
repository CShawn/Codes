package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/3/1 9:52 上午
 */
class Q303Test {

    @Test
    void test() {
        int[] array = new int[]{-2, 0, 3, -5, 2, -1};
        Q303.NumArray test = new Q303().new NumArray(array);
        Assertions.assertEquals(-3, test.sumRange(0, 9));
        Assertions.assertEquals(-3, test.sumRange(-9, 9));
        Assertions.assertEquals(1, test.sumRange(-9, 2));
        Assertions.assertEquals(-1, test.sumRange(2, 9));
        Assertions.assertEquals(1, test.sumRange(0, 2));
        Assertions.assertEquals(-1, test.sumRange(2, 5));
        Assertions.assertEquals(-3, test.sumRange(0, 5));
        Assertions.assertArrayEquals(new int[]{-2, 0, 3, -5, 2, -1}, array);
    }
}