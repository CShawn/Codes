package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树:   [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 提示：节点总数 <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/12/16 11:07 上午
 */
public class Sword_32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            /* 方法一：参照Sword_32，同理
            List<TreeNode> nodes = new ArrayList<>();
            nodes.add(root);
            addSubNodes(result, nodes, 0, nodes.size());
            */
            // 方法二：遍历二叉树，指定结点的层数，按层数将结点添加到第几个列表
            addSubNodes(result, root, 0);
        }
        return result;
    }

    /**
     * 添加当前层所有结点的子结点
     * @param result 所有层结点的集合
     * @param nodes 当前层结点的集合
     * @param start 当前层开始的索引
     * @param count 当前层结点的个数
     */
    private void addSubNodes(List<List<Integer>> result, List<TreeNode> nodes, int start, int count) {
        // 当前层无结点时结束
        if (count == 0) {
            return;
        }
        int levelCount = 0;
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            TreeNode node = nodes.get(start + i);
            level.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                levelCount++;
            }
            if (node.right != null) {
                nodes.add(node.right);
                levelCount++;
            }
        }
        result.add(level);
        // 从结束位置开始，继续添加下一层结点
        addSubNodes(result, nodes, start + count, levelCount);
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
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        addSubNodes(result, node.left, level + 1);
        addSubNodes(result, node.right, level + 1);
    }
}
