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

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return build(preorder, inorder, null);
    }

    // 两个数组当前的位置
    private int preIndex = 0;
    private int inIndex = 0;
    private TreeNode build(int[] preorder, int[] inorder, TreeNode parent) {
        if (preIndex == preorder.length) {
            return null;
        }
        // 对于中序数组：
        // 创建左子树时，parent为左子树的父结点，若当前值前边没有其他值，只有父结点，则说明之前没有结点，即左子树为空
        // 创建左子树时，parent为父结点的父结点，若当前值后边没有其他值，只有祖父结点，则说明之后没有结点，即右子树为空
        if (parent != null && parent.val == inorder[inIndex]) {
            return null;
        }
        // 在前序数组中取一个值创建一个结点
        TreeNode node = new TreeNode(preorder[preIndex++]);
        // 将preIndex向右移动，并用以构造左子树，parent传入当前结点
        node.left = build(preorder, inorder, node);
        // 构造左子树后，将inIndex向右移动，以创建右子树，parent传入当前结点的父结点
        inIndex++;
        node.right = build(preorder, inorder, parent);
        return node;
    }
}
