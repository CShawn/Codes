package com.cshawn.codes.leetcodes.crack;


import com.cshawn.codes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉搜索树序列
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 * 示例：
 * 给定如下二叉树
 *
 *         2
 *        / \
 *       1   3
 * 返回：
 * [
 *    [2,1,3],
 *    [2,3,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bst-sequences-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/14 8:21 下午
 */
public class Q4_9 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path;

    // 要添加的节点只要父节点已被添加即可。回溯遍历所有可能。
    public List<List<Integer>> BSTSequences(TreeNode root) {
        path = new LinkedList<>();
        if(root == null) {
            result.add(path);
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        backtracking(queue);
        return result;
    }

    void backtracking(Deque<TreeNode> queue) {
        if (queue.isEmpty()) {
            result.add(new LinkedList<>(path));
            return;
        }
        // 当前层可选择的候选节点的个数
        int size = queue.size();
        while (size > 0) {
            TreeNode cur = queue.pollFirst();
            path.add(cur.val);
            // 添加并统计子节点数
            int children = 0;
            if (cur.left != null) {
                children++;
                queue.offerLast(cur.left);
            }
            if (cur.right != null) {
                children++;
                queue.offerLast(cur.right);
            }
            // 递归
            backtracking(queue);
            // 回溯队列
            while (children > 0) {
                queue.pollLast();
                children--;
            }
            queue.offerLast(cur);
            // 回溯路径
            path.removeLast();
            // 当前节点处理完毕，数量减一
            size--;
        }
    }
}
