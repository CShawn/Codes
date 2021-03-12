package com.cshawn.leetcodes.sword;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author C.Shawn
 * @date 2020/11/16 21:55
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public TreeNode(Integer[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        if (array[0] != null) {
            val = array[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (array.length > 1) {
            TreeNode node = array[1] != null ? new TreeNode(array[1]) : null;
            left = node;
            queue.add(node);
        }
        if (array.length > 2) {
            TreeNode node = array[2] != null ? new TreeNode(array[2]) : null;
            right = node;
            queue.add(node);
        }
        int index = 3;
        while (index < array.length) {
            TreeNode lNode = array[index] != null ? new TreeNode(array[index]) : null;
            queue.peek().left = lNode;
            index++;
            if (index < array.length) {
                TreeNode rNode = array[index] != null ? new TreeNode(array[index]) : null;
                queue.peek().right = rNode;
                index++;
            }
            queue.poll();
        }
        queue.clear();
    }

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