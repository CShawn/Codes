package com.cshawn.codes.leetcodes.crack;


import com.cshawn.codes.TreeNode;

/**
 * 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回false 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/8 9:22 下午
 */
public class Q4_4 {
    public boolean isBalanced1(TreeNode root) {
        int[] result = dfs(root);
        return result[0] == 1;
    }

    // 返回一个数组，两个元素，第1个为1表示当前树是否平衡，第2个表示当前树的层数
    private int[] dfs(TreeNode tree) {
        if (tree == null) {
            return new int[]{1, -1};
        }
        int[] left = dfs(tree.left);
        int[] right = dfs(tree.right);
        boolean isBalanced = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1;
        return new int[]{isBalanced ? 1 : 0, isBalanced ? Math.max(left[1], right[1]) + 1 : 0};
    }
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) >= 0;
    }

    // 当平衡时，返回树的高度，不平衡时返回-1
    private int dfsHeight(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int left = dfsHeight(tree.left);
        int right = dfsHeight(tree.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
