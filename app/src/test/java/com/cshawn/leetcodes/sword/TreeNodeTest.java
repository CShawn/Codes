package com.cshawn.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * @author C.Shawn
 * @date 2020/11/17 20:52
 */
public class TreeNodeTest {
    // private TreeNode test = new TreeNode();

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    public void preOrder(TreeNode treeNode, int[] preOrder, int[] inOrder, int[] sufOrder) {
        assertEquals(preOrder.length, treeNode != null ? treeNode.getCount() : 0);
        assertArrayEquals(preOrder, treeNode != null ? treeNode.preOrder() : new int[0]);
        assertArrayEquals(inOrder, treeNode != null ? treeNode.inOrder() : new int[0]);
        assertArrayEquals(sufOrder, treeNode != null ? treeNode.sufOrder() : new int[0]);
    }
}
