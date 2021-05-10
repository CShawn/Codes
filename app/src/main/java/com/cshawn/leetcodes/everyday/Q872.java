package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 *
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 *
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 *
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 *
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *
 * 提示：
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/10 9:13 下午
 */
public class Q872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        dfs(root1, queue1);
        dfs(root2, queue2);
        if (queue1.size() != queue2.size()) {
            return false;
        }
        while (!queue1.isEmpty()) {
            if (queue1.poll().intValue() != queue2.poll().intValue()) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node, Queue<Integer> queue) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            queue.add(node.val);
        }
        dfs(node.left, queue);
        dfs(node.right, queue);
    }
}
