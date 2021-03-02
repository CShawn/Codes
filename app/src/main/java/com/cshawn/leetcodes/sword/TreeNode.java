package com.cshawn.leetcodes.sword;

import java.util.Objects;

/**
 * @author C.Shawn
 * @date 2020/11/16 21:55
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public TreeNode left(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode right(TreeNode right) {
        this.right = right;
        return this;
    }

    public int[] preOrder() {
        int[] result = new int[getCount(this)];
        preOrder(this, result, -1);
        return result;
    }

    private int preOrder(TreeNode node, int[] array, int index) {
        if (node != null) {
            array[++index] = node.val;
            index = preOrder(node.left, array, index);
            index = preOrder(node.right, array, index);
        }
        return index;
    }

    public int[] inOrder() {
        int[] result = new int[getCount(this)];
        inOrder(this, result, -1);
        return result;
    }

    private int inOrder(TreeNode node, int[] array, int index) {
        if (node != null) {
            index = inOrder(node.left, array, index);
            array[++index] = node.val;
            index = inOrder(node.right, array, index);
        }
        return index;
    }

    public int[] sufOrder() {
        int[] result = new int[getCount(this)];
        sufOrder(this, result, -1);
        return result;
    }

    private int sufOrder(TreeNode node, int[] array, int index) {
        if (node != null) {
            index = sufOrder(node.left, array, index);
            index = sufOrder(node.right, array, index);
            array[++index] = node.val;
        }
        return index;
    }

    public int getCount() {
        return getCount(this);
    }

    private int getCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getCount(node.left) + getCount(node.right);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode) {
            TreeNode node = (TreeNode) obj;
            boolean leftEquals = Objects.equals(this.left, node.left);
            boolean rightEquals = Objects.equals(this.right, node.right);
            return this.val == node.val && leftEquals && rightEquals;
        }
        return super.equals(obj);
    }
}