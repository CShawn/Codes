package com.cshawn.codes.leetcodes.everyday;

/**
 * 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 *
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/24 9:13 上午
 */
public class Q832 {
    public int[][] flipAndInvertImage1(int[][] A) {
        int end;
        for (int i = 0; i < A.length; i++) {
            end = A[i].length / 2;
            // 只遍历一半长度
            for (int j = 0; j < end; j++) {
                // 首尾数值不同则无需操作（翻转再反转，原数据不变）
                if((A[i][j] ^ A[i][A[i].length - j - 1]) == 0) {
                    // 首尾数值相同，则直接反转(翻转再反转，相当于把原数据取反)
                    A[i][j] ^= 1;
                    A[i][A[i].length - j - 1] ^= 1;
                }
            }
            // 数组长度为奇数时，需要把中位数取反
            if ((A[i].length & 1) == 1) {
                // 长度为奇数时，end为中位数
                A[i][end] ^= 1;
            }
        }
        return A;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0) {
            return A;
        }
        int end = (A[0].length + 1) / 2;
        int temp;
        for (int i = 0; i < A.length; i++) {
            // 只遍历一半长度
            for (int j = 0; j < end; j++) {
                temp = A[i][j] ^= 1;
                A[i][j] = A[i][A[i].length - j - 1] ^= 1;
                A[i][A[i].length - j - 1] = temp;
            }
        }
        return A;
    }
}
