package com.cshawn.leetcodes.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回: [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 提示：节点总数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/12/21 22:48
 */
public class Sword_34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        pathTree(list, new ArrayList<>(), root, sum);
        return list;
    }

    /**
     * 遍历树，在符合条件时创建list添加到集合中
     * @param list 最后返回的list
     * @param origin 从根结点创建一个list，遍历时依次添加元素
     * @param node 当前结点
     * @param remain sum减去之前所有结点的数，剩余的和
     * @return 返回origin是否添加了元素，如果添加了回溯时需要删除最后一个添加的元素，如果未添加则无需处理
     */
    private boolean pathTree(List<List<Integer>> list, List<Integer> origin, TreeNode node, int remain) {
        if (node == null) {
            return false;
        }
        // 当前结点的值正好符合条件，且该结点没有子树（该结点为终点）
        if (node.val == remain && node.left == null && node.right == null) {
            // 根据之前的结点创建一个新的list，添加到最终的集合中
            List<Integer> path = new ArrayList<>(origin);
            path.add(node.val);
            list.add(path);
            return false;
        } else {
            // 不是终点时，将当前结点添加到传入的集合中
            origin.add(node.val);
            // 继续遍历左子树
            if (pathTree(list, origin, node.left, remain - node.val)) {
                // 如果左子树的遍历过程中添加了元素，则此时回溯删除最后一个添加的元素
                origin.remove(origin.size() - 1);
            }
            // 继续遍历右子树
            if (pathTree(list, origin, node.right, remain - node.val)) {
                // 如果右子树的遍历过程中添加了元素，则此时回溯删除最后一个添加的元素
                origin.remove(origin.size() - 1);
            }
            // 因为添加了当前结点，返回true
            return true;
        }
    }
}
