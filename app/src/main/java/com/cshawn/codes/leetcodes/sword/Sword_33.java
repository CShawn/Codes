package com.cshawn.codes.leetcodes.sword;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回     true，否则返回     false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 * 提示：数组长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/12/16 15:48
 */
public class Sword_33 {
    // 对于二叉搜索树，可知左子树小于根结点右孩子树大于根结点，从数组中切分出左右子树，递归判断
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return verify(postorder, 0, postorder.length - 1);
        // 可以继续优化，倒序遍历找左子树的根结点，之前的元素必须小于祖父根结点，之后的元素为右子树，必须小于祖父根结点
//        int leftRoot = postorder.length - 1;
//        int rightRoot = -1;
//        int root = -1;
//        for (int i = leftRoot - 1; i >= 0; i--) {
//
//
//
//            if (root != -1 && postorder[i] > postorder[root]) {
//                return false;
//            }
//            if (postorder[i] < postorder[leftRoot]) {
//                root = leftRoot;
//                leftRoot = i;
//            } else {
//                rightRoot = i;
//            }
//        }
//        return true;
    }

    /**
     * 为方便判断子树是否满足条件，不创建新数组，使用索引定义开始结束范围
     * @param postorder 原数组
     * @param start 开始索引
     * @param end 结束索引
     * @return 是否满足条件
     */
    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        //*
        int root = postorder[end];
        int left = -1;
        // 查找第一个小于根结点的元素位置，以左为左子树，以右为右子树
//        for (int i = end; i >= start; i--) {
//            if (postorder[i] < root) {
//                left = i;
//                break;
//            }
//        }
        /*
        // 判断当前树左右两侧是否满足大小关系
        for (int i = start; i <= end; i++) {
            // 判断左子树皆小于根结点
            if (i <= left && postorder[i] > root) {
                return false;
            }
            // 无需判断右子树皆大于根结点，因为left是遍历了右侧的数据大于根结点
//            if (i > left && postorder[i] < root) {
//                return false;
//            }
        }
        //*/
        // 以上优化为：
//        for (int i = start; i < left; i++) {
//            // 判断左子树皆小于根结点
//            if (postorder[i] > root) {
//                return false;
//            }
//        }
        //*/
        /* 那么第二个for循环就多余了，可优化为：
        for (int i = end; i >= start; i--) {
            if (left == -1) {
                if (postorder[i] < root) {
                    left = i;
                }
            } else if (postorder[i] > root) {
                return false;
            }
        }
        //*/
        // 奇葩不，写成while就通过了
        left = end - 1;
        while (left >= start && postorder[left] > root) {
            left--;
        }
        int temp = left;
        while (temp >= start) {
            if (postorder[temp--] > root) {
                return false;
            }
        }
        // 判断左子树及右孩子树是否满足条件
        return verify(postorder, start, left) && verify(postorder, left + 1, end - 1);
    }
}
