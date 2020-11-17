package com.cshawn.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * @author C.Shawn
 * @date 2020/11/15 20:11
 */
public class Sword_7Test {
    private Sword_7 test = new Sword_7();

    @Test
    public void buildTree_empty() {
        assertNull(test.buildTree(new int[0], new int[0]));
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    public void buildTree(TreeNode expected, int[] preorder, int[] inorder) {
        assertEquals(expected, test.buildTree(preorder, inorder));
    }

    @Test
    public void buildTree2_empty() {
        assertNull(test.buildTree2(new int[0], new int[0]));
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    public void buildTree2(TreeNode expected, int[] preorder, int[] inorder) {
        assertEquals(expected, test.buildTree2(preorder, inorder));
    }
}
