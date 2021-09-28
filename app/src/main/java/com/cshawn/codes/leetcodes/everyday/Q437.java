package com.cshawn.codes.leetcodes.everyday;

import com.cshawn.codes.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和 III
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 *
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 * 提示:
 * 二叉树的节点个数的范围是 [0,1000]
 * -109<= Node.val <= 109
 * -1000<= targetSum<= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/28 9:49 上午
 */
public class Q437 {
    // 方法1：DFS
    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = sum(root, targetSum);
        res += pathSum1(root.left, targetSum);
        res += pathSum1(root.right, targetSum);
        return res;
    }

    private int sum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res++;
        }
        res += sum(root.left, targetSum - root.val);
        res += sum(root.right, targetSum - root.val);
        return res;
    }

    // 方法2：DFS + 前缀和 + 回溯
    public int pathSum(TreeNode root, int targetSum) {
        // <前缀和,出现次数>
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, long curSum, int targetNum) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        // prefix中存在x = curSum - targetNum，则curSum-x即为targetNum
        int res = prefix.getOrDefault(curSum - targetNum, 0);
        prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);
        res += dfs(root.left, prefix, curSum, targetNum);
        res += dfs(root.right, prefix, curSum, targetNum);
        prefix.put(curSum, prefix.get(curSum) - 1);
        return res;
    }
}