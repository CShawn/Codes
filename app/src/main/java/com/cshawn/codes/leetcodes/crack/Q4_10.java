package com.cshawn.codes.leetcodes.crack;


import com.cshawn.codes.TreeNode;

/**
 * 检查子树
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * 注意：此题相对书上原题略有改动。
 * 示例1:
 *  输入：t1 = [1, 2, 3], t2 = [2]
 *  输出：true
 *
 * 示例2:
 *  输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 *  输出：false
 * 提示:树的节点数目范围为[0, 20000]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-subtree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/16 4:55 下午
 */
public class Q4_10 {
    // 只适用于两个相同对象
    public boolean checkSubTree1(TreeNode t1, TreeNode t2) {
        return t1 == t2 || (t1 != null && (checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2)));
    }

    // 题意为判断两个节点值相同
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == t2) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        // 找到相同的点，则dfs去判断是否完全相同
        if (t1.val == t2.val && check(t1, t2)) {
            return true;
        }
        // 若非完全相同，则继续查找
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2 == null;
        }
        if (t2 == null || t1.val != t2.val) {
            return false;
        }
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }
}
