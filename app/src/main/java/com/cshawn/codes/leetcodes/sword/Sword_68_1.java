package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/28 11:44 上午
 */
public class Sword_68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        // 记录两个结点的路径
        List<TreeNode> pList = new LinkedList<>();
        List<TreeNode> qList = new LinkedList<>();
        dfs(root, p, pList);
        dfs(root, q, qList);
        int i = 0;
        // 遍历两条路径
        while (i < pList.size() && i < qList.size()) {
            // 遇到不同的结点直接结束
            if (pList.get(i) != qList.get(i)) {
                break;
            }
            i++;
        }
        // 返回分岔点
        return pList.get(i - 1);
    }

    private void dfs(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            if (target.val < root.val) {
                dfs(root.left, target, list);
            } else if (target.val > root.val) {
                dfs(root.right, target, list);
            }
        }
    }

    // 方法2：遍历树，当前结点小于pq则向右；大于pq则向左；其他情况则分岔，直接返回
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        TreeNode temp = root;
        while (true) {
            if (p.val < temp.val && q.val < temp.val) {
                temp = temp.left;
            } else if (p.val > temp.val && q.val > temp.val) {
                temp = temp.right;
            } else {
                break;
            }
        }
        return temp;
    }
}
