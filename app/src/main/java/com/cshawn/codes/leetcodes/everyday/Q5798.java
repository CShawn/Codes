package com.cshawn.codes.leetcodes.everyday;

/**
 * 循环轮转矩阵
 * 给你一个大小为 m x n 的整数矩阵 grid​​​ ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。
 * 矩阵由若干层组成, 矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。
 * 返回执行 k 次循环轮转操作后的矩阵。
 * 
 * 示例 1：
 * 输入：grid = [[40,10],[30,20]], k = 1
 * 输出：[[10,20],[40,30]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * 
 * 示例 2：
 * 输入：grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
 * 输出：[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * 
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 50
 * m 和 n 都是 偶数
 * 1 <= grid[i][j] <= 5000
 * 1 <= k <= 109
 */
public class Q5798 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int mid = Math.min(m, n) >> 1;
        for (int i = 0; i < mid; i++) {
            int h = m - (i << 1);
            int w = n - (i << 1);
            int size = (w + h - 2) << 1;
            // 将第i层转为一维数组
            int[] temp = new int[size];
            int index = 0;
            for (int a = 0; a < w - 1; a++) {
                temp[index++] = grid[i][i + a];
            }
            for (int a = 0; a < h - 1; a++) {
                temp[index++] = grid[i + a][n - i - 1];
            }
            for (int a = 0; a < w - 1; a++) {
                temp[index++] = grid[m - i - 1][n - i - 1 - a];
            }
            for (int a = 0; a < h - 1; a++) {
                temp[index++] = grid[m - i - 1 - a][i];
            }
            // 将一维数组旋转后存入原数组
            int count = k;
            for (int a = 0; a < w - 1; a++) {
                grid[i][i + a] = temp[(count++) % size];
            }
            for (int a = 0; a < h - 1; a++) {
                grid[i + a][n - i - 1] = temp[(count++) % size];
            }
            for (int a = 0; a < w - 1; a++) {
                grid[m - i - 1][n - i - 1 - a] = temp[(count++) % size];
            }
            for (int a = 0; a < h - 1; a++) {
                grid[m - i - 1 - a][i] = temp[(count++) % size];
            }
        }
        return grid;
    }
}
