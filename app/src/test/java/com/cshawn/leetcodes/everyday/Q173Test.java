package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/3/28 10:38 上午
 */
class Q173Test {

    @Test
    void test() {
        TreeNode tree = new TreeNode(new Integer[]{7, 3, 15, null, null, 9, 20});
        Q173.BSTIterator bSTIterator = new Q173.BSTIterator(tree);
        Assertions.assertEquals(3, bSTIterator.next());
        Assertions.assertEquals(7, bSTIterator.next());
        Assertions.assertTrue(bSTIterator.hasNext());
        Assertions.assertEquals(9, bSTIterator.next());
        Assertions.assertTrue(bSTIterator.hasNext());
        Assertions.assertEquals(15, bSTIterator.next());
        Assertions.assertTrue(bSTIterator.hasNext());
        Assertions.assertEquals(20, bSTIterator.next());
        Assertions.assertFalse(bSTIterator.hasNext());
    }
}