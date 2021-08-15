package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 例如:
 * 给定二叉树:    [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *     
 * 提示：节点总数 <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/12/16 14:55
 */
public class Sword_32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 参照Sword_32_2，同理
        addSubNodes(result, root, 0);
        return result;
    }

    /**
     * @param result 所有层结点的集合
     * @param node 当前结点
     * @param level 指定当前结点所在的层数，决定了添加到result的第几个list
     */
    private void addSubNodes(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        // 奇数层逆序，偶数层正序
        boolean reverse = (level & 1) != 0;
        if (level >= result.size()) {
            // 逆序使用链表向头部添加元素
            result.add(reverse ? new LinkedList<>() : new ArrayList<>());
        }
        if (reverse) {
            // 逆序向头部添加元素
            result.get(level).add(0, node.val);
        } else {
            result.get(level).add(node.val);
        }
        addSubNodes(result, node.left, level + 1);
        addSubNodes(result, node.right, level + 1);
    }
}
