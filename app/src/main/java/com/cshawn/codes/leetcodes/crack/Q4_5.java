package com.cshawn.codes.leetcodes.crack;


import com.cshawn.codes.TreeNode;

/**
 * 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/8 10:04 下午
 */
public class Q4_5 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root.left, null, root.val) && isValidBST(root.right, root.val, null);
    }

    // 限制当前节点的最大最小值
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        // 对于左子树，最大不能超过当前值，最小不能比当前的最小范围小
        // 对于右子树，最小不能小于当前值，最大不能超过当前的最大范围
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
