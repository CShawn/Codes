package com.cshawn.codes.leetcodes.everyday;


import com.cshawn.codes.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * 提示：
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/13 11:30
 */
public class Q783 {
    // 方法1：中序遍历成list，再顺序遍历计算每两个相邻数值之差
    public int minDiffInBST1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        dfs(root, list);
        int result = Integer.MAX_VALUE;
        Iterator<Integer> iterator = list.listIterator();
        int pre = iterator.next();
        while (iterator.hasNext()) {
            int cur = iterator.next();
            result = Math.min(result, cur - pre);
            pre = cur;
        }
        return result;
    }

    private void dfs(TreeNode tree, List<Integer> list) {
        if (tree == null) {
            return;
        }
        dfs(tree.left, list);
        list.add(tree.val);
        dfs(tree.right, list);
    }

    private int pre = -1;
    private int result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfsAndCompare(root);
        return result;
    }

    private void dfsAndCompare(TreeNode tree) {
        if (tree == null) {
            return;
        }
        dfsAndCompare(tree.left);
        // 找到最小节点时，只赋值不计算result
        if (pre != -1) {
            result = Math.min(result, Math.abs(pre - tree.val));
        }
        // 记录当前值，亦即下次遍历的前一个值
        pre = tree.val;
        dfsAndCompare(tree.right);
    }
}