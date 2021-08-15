package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.TreeNode;

/**
 * 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * 限制: 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/23 8:30 下午
 */
public class Sword_54 {
    // 二叉搜索树中序遍历是一个升序数组，倒着向前找到第k个
    // 但是，没人规定遍历二叉树要先左再右，如果先右再左，中序遍历得到的就是降序数组！只用遍历第k个就结束了
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    int n = 0, result;
    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.right, k);
        n++;
        if (n == k) {
            result = root.val;
            return;
        }
        dfs(root.left, k);
    }
}
