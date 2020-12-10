package com.cshawn.leetcodes.sword;

/**
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @Date 2020/12/09 22:10
 */
public class Sword_26 {
    public boolean isSubStructure(TreeNode target, TreeNode pattern) {
        /*
        if (target == null || pattern == null) {
            return false;
        }
        if (target.val == pattern.val) {
            // 当两个结点值相同时
            // 比较以当前两个结点为根的两棵子树，pattern是否为target的子树
            if (compare(target, pattern)) {
                return true;
            } else {
                // 不成立时，继续比较pattern是否为target的左子树或右子树的子树
                return isSubStructure(target.left, pattern) || isSubStructure(target.right, pattern);
            }
        } else {
            // 当两个结点值不同时，比较pattern是否为target的左子树或右子树的子树
            return isSubStructure(target.left, pattern) || isSubStructure(target.right, pattern);
        }
        */
        /*
        // 但可见，compare中已经对两个结点值相等作出了判断，因此上述判断多余，可简化为：
        if (target == null || pattern == null) {
            return false;
        }
        if (compare(target, pattern)) {
            return true;
        } else {
            // 当两个结点值不同时，比较pattern是否为target的左子树或右子树的子树
            return isSubStructure(target.left, pattern) || isSubStructure(target.right, pattern);
        }
        */
        // 以上优化为一行代码
        return target != null && pattern != null && (compare(target, pattern) || isSubStructure(target.left, pattern) || isSubStructure(target.right, pattern));
    }

    private boolean compare(TreeNode tNode, TreeNode pNode) {
        /*
        // 当要比较的模板当前结点为空时，即不存在此结点，则不需要比较，直接返回匹配true，去匹配其他结点
        if (pNode == null) {
            return true;
        }
        // 当要比较的结点为空而模板结点不空时，不匹配；两个结点值不同时不匹配
        if (tNode == null || tNode.val != pNode.val) {
            return false;
        }
        // 当前两个结点匹配时，继续比较两个结点的左右子树
        return compare(tNode.left, pNode.left) && compare(tNode.right, pNode.right);
        */
        // 以上优化为一行代码
        return pNode == null || tNode != null && tNode.val == pNode.val && compare(tNode.left, pNode.left) && compare(tNode.right, pNode.right);
    }
}
