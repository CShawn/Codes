package com.cshawn.leetcodes.everyday;

/**
 * 矩阵置零
 * 给定一个m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 进阶：
 * 一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/21 10:26 上午
 */
public class Q73 {
    // 使用第0行存储要置0的列，第0列存储要置0的行，
    // [0,0]重叠，表示第0行是否需要置0，用额外一个值存储0列是否要置0
    public void setZeroes1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // 第0列是否要置0
        boolean zeroColumn = matrix[0][0] == 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                zeroColumn = true;
                break;
            }
        }
        // 记录0行是否需要变0
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                matrix[0][0] = 0;
                break;
            }
        }
        // 当前行是否要置0
        boolean zero;
        for(int i = 1; i < matrix.length; i++) {
            zero = matrix[i][0] == 0;
            for(int j = 1; j < matrix[i].length; j++) {
                // 遇到0
                if (matrix[i][j] == 0) {
                    // 将首行与首列元素置0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    // 将当前行之前的元素置0
                    if (!zero) {
                        for (int k = 1; k < j; k++) {
                            matrix[i][k] = 0;
                        }
                        zero = true;
                    }
                } else if (zero) {
                    // 遍历过程中，当前行需要置0且当前元素不为0则置0
                    matrix[i][j] = 0;
                }
            }
        }
        // 将列置0
        for(int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for(int i = 1; i < matrix.length; i++) {
                    if (matrix[i][0] != 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        // 第0行置0
        if (matrix[0][0] == 0) {
            for(int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        // 第0列置0
        if (zeroColumn) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 去掉中途置0
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // 第0列是否要置0
        boolean zeroColumn = matrix[0][0] == 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                zeroColumn = true;
                break;
            }
        }
        // 记录0行是否需要变0
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                matrix[0][0] = 0;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 置0
        for (int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 第0行置0
        if (matrix[0][0] == 0) {
            for(int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        // 第0列置0
        if (zeroColumn) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
