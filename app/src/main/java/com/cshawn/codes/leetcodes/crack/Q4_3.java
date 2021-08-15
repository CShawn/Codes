package com.cshawn.codes.leetcodes.crack;

import com.cshawn.codes.ListNode;
import com.cshawn.codes.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * 示例：
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/2 6:06 下午
 */
public class Q4_3 {
    public ListNode[] listOfDepth1(TreeNode tree) {
        List<ListNode> result = new LinkedList<>();
        if (tree != null) {
            // 用队列存储树结点
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(tree);
            ListNode list = new ListNode(0);
            // 记录上一层有几个节点
            int pre = 1;
            while (pre != 0) {
                int count = 0;
                list.next = null;
                ListNode aux = list;
                // 拿出之前层的几个节点
                for (int i = 0; i < pre; i++) {
                    TreeNode node = queue.poll();
                    // 存入链表
                    aux.next = new ListNode(node.val);
                    aux = aux.next;
                    // 队列加上左右节点
                    if (node.left != null) {
                        queue.add(node.left);
                        count++;
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        count++;
                    }
                }
                // 遍历完一层添加一次
                result.add(list.next);
                pre = count;
            }
        }
        return result.toArray(new ListNode[0]);
    }

    // 因要返回链表，所以可以选择中右左的遍历顺序，将链表倒过来
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> result = new LinkedList<>();
        listOfDepth(tree, 0, result);
        return result.toArray(new ListNode[0]);
    }

    private void listOfDepth(TreeNode tree, int depth, List<ListNode> listNodes){
        if (tree == null) {
            return;
        }
        ListNode node = new ListNode(tree.val);
        if (listNodes.size() == depth) {
            listNodes.add(node);
        } else {
            node.next = listNodes.get(depth);
            listNodes.set(depth, node);
        }
        listOfDepth(tree.right, depth + 1, listNodes);
        listOfDepth(tree.left, depth + 1, listNodes);
    }
}
