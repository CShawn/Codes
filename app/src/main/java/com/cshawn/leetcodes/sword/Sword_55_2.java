package com.cshawn.leetcodes.sword;

/**
 * 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回false 。
 * 限制：1 <= 树的结点个数 <= 10000
 * 注意：本题与主站 110题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/23 9:44 下午
 */
public class Sword_55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 深度优先遍历左右子树，自底向上，不平衡立即结束
        if (!isBalanced(root.left)) {
            return false;
        }
        if (!isBalanced(root.right)) {
            return false;
        }
        // 子树的深度差不大于1为平衡
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
    }

    // 获取树的深度
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 当前结点的深度=左子树和右子树较大的深度+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
