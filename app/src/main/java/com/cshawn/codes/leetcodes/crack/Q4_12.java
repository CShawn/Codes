package com.cshawn.codes.leetcodes.crack;


import com.cshawn.codes.TreeNode;

import java.util.List;
import java.util.ArrayList;

/**
 * 求和路径
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：节点总数 <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/16 21:40
 */
public class Q4_12 {
    private int result = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 前缀和
        List<Integer> sums = new ArrayList<>();
        dfs(root, sum, sums);
        return result;
    }

    // 深度优先遍历
    private void dfs(TreeNode root, int sum, List<Integer> sums) {
        // 将当前节点计算前缀和填入列表
        int total = root.val;
        if (sums.size() != 0) {
            total = sums.get(sums.size() - 1) + root.val;
        }
        sums.add(total);
        // 当前总和与目标值匹配
        if (total == sum) {
            result++;
        }
        // 分别计算子路径中是否与目标值匹配
        for (int i = 0; i < sums.size() - 1; i++) {
            if (total - sums.get(i) == sum) {
                result++;
            }
        }
        // 对其子树分别遍历
        if (root.left != null) {
            dfs(root.left, sum, sums);
            // 回溯
            sums.remove(sums.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sum, sums);
            // 回溯
            sums.remove(sums.size() - 1);
        }
    }
}
