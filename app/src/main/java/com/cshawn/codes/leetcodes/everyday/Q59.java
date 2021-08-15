package com.cshawn.codes.leetcodes.everyday;

/**
 * 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * 提示：1 <= n <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/16 9:02 上午
 */
public class Q59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int size = n * n;
        int num = 1;
        int circle = (n + 1) >> 1;
        for (int i = 0; i < circle; i++) {
            // 右
            for (int r = i; r < n - i && num <= size; r++) {
                result[i][r] = num++;
            }
            // 下
            for (int d = i + 1; d < n - i - 1 && num <= size; d++) {
                result[d][n - 1 - i] = num++;
            }
            // 左
            for (int l = n - 1 - i; l >= i && num <= size; l--) {
                result[n - 1 - i][l] = num++;
            }
            // 上
            for (int u = n - 2 - i; u > i && num <= size; u--) {
                result[u][i] = num++;
            }
        }
        return result;
    }
}
