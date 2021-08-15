package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.TreeNode;

/**
 * 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 * 提示：节点总数 <= 10000
 * 注意：本题与主站 104题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/23 9:13 下午
 */
public class Sword_55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 当前结点的深度=左子树和右子树较大的深度+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
