package com.cshawn.leetcodes.everyday;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 矩形区域不超过 K 的最大数值和
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 * 示例 1：
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域[[0, 1], [-2, 3]]的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 *
 * 示例 2：
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 *
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/22 9:35 下午
 */
public class Q363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        // 存储每列的元素前缀和
        int[] colSum = new int[matrix[0].length];
        // 有序集合，存储二维前缀和
        TreeSet<Integer> sortedSum = new TreeSet<>();
        // 遍历行
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(colSum, 0);
            // 遍历下边界
            for (int j = i; j < matrix.length; j++) {
                // 统计[i,j]行之间每一列(l列)的元素前缀和
                for (int l = 0; l < matrix[0].length; l++) {
                    colSum[l] += matrix[j][l];
                }
                // 表示[0,0]到[j,l]之间所有元素的和
                int total = 0;
                // 则要求total-某前缀和x<=k的最大值,则x>=total-k，需要求最小的x
                // 每次只存储当前行元素位置的二维前缀和（之前的已计算过）
                sortedSum.clear();
                // 如果total比k小，则最大为total, 因此需要ceil为0，在sortedSum中添加0
                sortedSum.add(0);
                for (int sum : colSum) {
                    // 累计当前元素[j,l]位置的二维前缀和
                    total += sum;
                    // 二分查找比total-k大的最小值
                    Integer ceil = sortedSum.ceiling(total - k);
                    if (ceil != null) {
                        // 更新最大的result
                        result = Math.max(result, total - ceil);
                    }
                    // 将前级和加入有序集合中
                    sortedSum.add(total);
                }
            }
        }
        return result;
    }
}
