package com.cshawn.codes.leetcodes.everyday;

import com.cshawn.codes.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 * 提示：
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值0 <= node.val <= 500。
 * 目标结点target是树上的结点。
 * 0 <= K <= 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/28 3:31 下午
 */
public class Q863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 根据结点的值范围，使用数组模拟哈希表
        TreeNode[] map = new TreeNode[501];
        dfs(map, root, null, target.val);
        List<Integer> list = new LinkedList<>();
        find(list, map, target, target, k);
        return list;
    }

    // dfs找到target，map中会存入target的父系结点(父结点及上层祖父结点)
    private boolean dfs(TreeNode[] map, TreeNode root, TreeNode parent, int target) {
        if (root == null) {
            return false;
        }
        map[root.val] = parent;
        if (root.val == target) {
            return true;
        }
        return dfs(map, root.left, root, target) || dfs(map, root.right, root, target);
    }

    // 查找距离node为k的结点,当前从from而来，不搜索from
    private void find(List<Integer> list, TreeNode[] map, TreeNode node, TreeNode from, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            list.add(node.val);
            return;
        }
        if (map[node.val] != from) {
            find(list, map, map[node.val], node, k - 1);
        }
        if (node.left != from) {
            find(list, map, node.left, node, k - 1);
        }
        if (node.right != from) {
            find(list, map, node.right, node, k - 1);
        }
    }
}
