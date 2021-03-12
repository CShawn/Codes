package com.cshawn.leetcodes.crack;

import com.cshawn.leetcodes.sword.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * 示例 1:
 * 输入: root = [2,1,3], p = 1
 *   2
 *  / \
 * 1   3
 * 输出: 2
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 * 输出: null
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/12 4:34 下午
 */
public class Q4_6 {
    private boolean found = false;
    private TreeNode result = null;
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        inorder(root, p);
        return result;
    }

    private void inorder(TreeNode tree, TreeNode p) {
        if (tree == null) {
            return;
        }
        inorder(tree.left, p);
        // 中序遍历，找到后赋值
        if (found) {
            if (result == null) {
                result = tree;
            }
        } else if (tree == p) {
            found = true;
        }
        inorder(tree.right, p);
    }

    // 方法2：中序遍历后再依次查找
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> orders = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 中序遍历
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                orders.add(root);
                root = root.right;
            }
        }
        // 在中序遍历结果中查找目标
        Iterator<TreeNode> it = orders.iterator();
        while (it.hasNext()) {
            if (p == it.next()) {
                return it.hasNext() ? it.next() : null;
            }
        }
        return null;
    }

    // 方法3：二叉搜索树，利用排序
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else  {
            TreeNode node = inorderSuccessor(root.left, p);
            return node != null ? node : root;
        }
    }
}
