package com.cshawn.leetcodes.everyday;

import java.util.LinkedList;
import java.util.List;

/**
 * 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/15 9:18 上午
 */
public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int size = rows * cols;
        int count = 0;
        // 总螺旋圈数
        int circle = (Math.min(rows, cols) + 1) >> 1;
        for (int i = 0; i < circle; i++) {
            // 右
            for (int r = i; r < cols - i && count < size; r++) {
                result.add(matrix[i][r]);
                count++;
            }
            // 下
                for (int d = i + 1; d < rows - i - 1 && count < size; d++) {
                result.add(matrix[d][cols - 1 - i]);
                count++;
            }
            // 左
            for (int l = cols - 1 - i; l >= i && count < size; l--) {
                result.add(matrix[rows - 1 - i][l]);
                count++;
            }
            // 上
            for (int u = rows - 2 - i; u >= i + 1 && count < size; u--) {
                result.add(matrix[u][i]);
                count++;
            }
        }
        return result;
    }
}
