package com.cshawn.codes.leetcodes.everyday;

/**
 * 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例：
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 提示：
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/2 9:55 上午
 */
public class Q304 {
    class NumMatrix {
        // 二维前缀和
        private int[][] sums;
        // 方法1
        public NumMatrix(int[][] matrix, int old) {
            if (matrix.length > 0) {
                sums = new int[matrix.length][matrix[0].length];
                sums[0][0] = matrix[0][0];
                for (int i = 1; i < matrix.length; i++) {
                    sums[i][0] = sums[i - 1][0] + matrix[i][0];
                }
                for (int i = 1; i < matrix[0].length; i++) {
                    sums[0][i] = sums[0][i - 1] + matrix[0][i];
                }
                for (int i = 1; i < matrix.length; i++) {
                    for (int j = 1; j < matrix[i].length; j++) {
                        sums[i][j] = matrix[i][j] + sums[i][j - 1] + sums[i - 1][j] - sums[i - 1][j - 1];
                    }
                }
            }
        }

        // 优化方法1
        public NumMatrix(int[][] matrix) {
            if (matrix.length > 0) {
                // 类似于链表的盲节点，将数组横列扩展一个宽高
                sums = new int[matrix.length + 1][matrix[0].length + 1];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        sums[i + 1][j + 1] = matrix[i][j] + sums[i + 1][j] + sums[i][j + 1] - sums[i][j];
                    }
                }
            }
        }

        public int sumRegion1(int row1, int col1, int row2, int col2) {
            if (sums == null || row1 > row2 || col1 > col2) {
                return 0;
            }
            if (row2 >= sums.length) {
                row2 = sums.length - 1;
            }
            if (col2 >= sums[0].length) {
                col2 = sums[0].length - 1;
            }
            if (row1 == 0 && col1 == 0) {
                return sums[row2][col2];
            }
            if (row1 == 0) {
                return sums[row2][col2] - sums[row2][col1 - 1];
            }
            if (col1 == 0) {
                return sums[row2][col2] - sums[row1 - 1][col2];
            }
            return sums[row2][col2] - sums[row2][col1 - 1] - sums[row1 - 1][col2] + sums[row1 - 1][col1 - 1];
        }

        // 优化方法1
        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sums == null || row1 > row2 || col1 > col2) {
                return 0;
            }
            if (row2 >= sums.length - 1) {
                row2 = sums.length - 2;
            }
            if (col2 >= sums[0].length - 1) {
                col2 = sums[0].length - 2;
            }
            return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
        }
    }
}
