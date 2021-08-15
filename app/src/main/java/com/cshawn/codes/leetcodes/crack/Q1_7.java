package com.cshawn.codes.leetcodes.crack;

/**
 * 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 *
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/24 4:41 下午
 */
public class Q1_7 {
    // 一圈一圈遍历，将要旋转的4个元素两两交换
    public int[][] rotate1(int[][] matrix) {
        // 圈数
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix[i].length - i - 1; j++) {
                // 左上，右上
                matrix[i][j] ^= matrix[j][matrix[i].length - i - 1];
                matrix[j][matrix[i].length - i - 1] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][matrix[i].length - i - 1];
                // 左下，左上
                matrix[i][j] ^= matrix[matrix[i].length - j - 1][i];
                matrix[matrix[i].length - j - 1][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[matrix[i].length - j - 1][i];
                // 右下，左下
                matrix[matrix[i].length - i - 1][matrix[i].length - j - 1] ^= matrix[matrix[i].length - j - 1][i];
                matrix[matrix[i].length - j - 1][i] ^= matrix[matrix[i].length - i - 1][matrix[i].length - j - 1];
                matrix[matrix[i].length - i - 1][matrix[i].length - j - 1] ^= matrix[matrix[i].length - j - 1][i];
            }
        }
        return matrix;
    }

    // 先沿主对角线(左上到右下)翻转，再沿垂直对角线翻转，即可得到结果
    public int[][] rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                matrix[i][j] ^= matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][matrix[i].length - j - 1];
            }
        }
        return matrix;
    }
}
