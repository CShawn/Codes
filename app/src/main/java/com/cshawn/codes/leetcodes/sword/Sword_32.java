package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树:  [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 * 提示：节点总数 <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/12/16 10:06
 */
public class Sword_32 {
    public int[] levelOrder(TreeNode root) {
        /*
        // 用列表存储各结点
        List<Integer> nodes = new ArrayList<>();
        // 用队列存储广度优先遍历的结点
        Queue<TreeNode> temp = new LinkedList<>();
        if (root != null) {
            temp.add(root);
        }
        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();
            // 取出临时存储的结点，将其值放入列表，遍历其子结点放入队列
            if (node.left != null) {
                temp.add(node.left);
            }
            if (node.right != null) {
                temp.add(node.right);
            }
            nodes.add(node.val);
        }
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }
        return result;
        */
        // 优化：其实用一个列表存储就已经足够了
        List<TreeNode> nodes = new ArrayList<>();
        if (root != null) {
            nodes.add(root);
        }
        addSubNodes(nodes, 0, nodes.size());
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i).val;
        }
        return result;
    }

    /**
     * 添加当前层所有结点的子结点
     * @param nodes 所有结点的集合
     * @param start 当前层开始的索引
     * @param count 当前层结点的个数
     */
    private void addSubNodes(List<TreeNode> nodes, int start, int count) {
        // 当前层无结点时结束
        if (count == 0) {
            return;
        }
        int levelCount = 0;
        for (int i = 0; i < count; i++) {
            TreeNode node = nodes.get(start + i);
            if (node.left != null) {
                nodes.add(node.left);
                levelCount++;
            }
            if (node.right != null) {
                nodes.add(node.right);
                levelCount++;
            }
        }
        // 从结束位置开始，继续添加下一层结点
        addSubNodes(nodes, start + count, levelCount);
    }
}
