package com.cshawn.codes.leetcodes.everyday;


import com.cshawn.codes.TreeNode;

/**
 * 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 *
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *
 * 提示：
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/27 5:18 下午
 */
public class Q671 {
    public int findSecondMinimumValue(TreeNode root) {
        // 当前结点无子结点则返回-1作为结束
        if (root == null || root.left == null) {
            return -1;
        }
        // 找到与根节点相同的子结点
        TreeNode same, other;
        if (root.left.val == root.val) {
            same = root.left;
            other = root.right;
        } else {
            same = root.right;
            other = root.left;
        }
        // 在相同的子结点中继续深入，每次深入的都是与根节点相同的值
        int second = findSecondMinimumValue(same);
        // 另外一个结点如果不同则不需要深入，如果也相同则继续深入
        int otherSecond = other.val == root.val ? findSecondMinimumValue(other) : other.val;
        // 两者都不为-1.则取较小者
        if (second != -1 && otherSecond != -1) {
            return Math.min(second, otherSecond);
        }
        // 取-1之外的另一个值，也可能为-1
        return second == -1 ? otherSecond : second;
    }
}
