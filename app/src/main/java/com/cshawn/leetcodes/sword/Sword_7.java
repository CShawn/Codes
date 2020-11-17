package com.cshawn.leetcodes.sword;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
 * 限制：0 <= 节点个数 <= 5000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/16 21:54
 */
public class Sword_7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRecursive(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int[] inorder,
        int preStart, int preEnd, int inStart, int inEnd) {
        if (preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        // 取preorder第一个元素
        int root = preorder[preStart];
        // 找出该结点在inorder中的位置
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
            }
        }
        // 在inorder中，此结点以左用以构造左子树，以右构造右子树
        if (index != -1) {
            // 取preorder第一个元素作为根节点构造一棵树
            TreeNode node = new TreeNode(root);
            // 计算左子树长度
            int length = index - inStart;
            // 定位左子树对应的两个数组的范围，并以之构造左子树
            node.left = length == 0 ? null : buildTreeRecursive(
                preorder, 
                inorder, 
                // 前序数组起始位置加1, 结束位置再加上左子树长度
                preStart + 1, 
                preStart + 1 + length, 
                // 中序数组起始位置不变，结束位置为index
                inStart, 
                index
            );
            // 定位右子树对应的两个数组的范围，并以之构造右子树
            node.right = inEnd - 1 == index ? null : buildTreeRecursive(
                preorder, 
                inorder, 
                // 前序数组起始位置在左子树结束位置后开始时，结束位置不变
                preStart + 1 + length, 
                preEnd, 
                // 中序数组起始位置为index加1, 结束位置不变
                index + 1, 
                inEnd
            );       
            return node;   
        }
        return null;
    }
}
