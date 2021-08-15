package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 矩阵中战斗力最弱的 K 行
 * 给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。
 * 如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 * 示例 1：
 * 输入：mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]], 
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2 
 * 行 1 -> 4 
 * 行 2 -> 1 
 * 行 3 -> 2 
 * 行 4 -> 5 
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 *
 * 示例 2：
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]], 
 * k = 2
 * 输出：[0,2]
 * 解释： 
 * 每行中的军人数目：
 * 行 0 -> 1 
 * 行 1 -> 4 
 * 行 2 -> 1 
 * 行 3 -> 1 
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 *
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/1 4:07 下午
 */
public class Q1337 {

    // 方法1：计数 + 排序
    public int[] kWeakestRows1(int[][] mat, int k) {
        int[][] temp = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            temp[i] = new int[]{i,0};
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                temp[i][1] += mat[i][j];
            }
        }
        Arrays.sort(temp, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = temp[i][0];
        }
        return result;
    }

    // 方法2：二分 + 最小堆
    // 因为1都在0前边，所以可以二分
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
                o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]
        );
        for (int i = 0; i < mat.length; i++) {
            int left = 0, right = mat[i].length, j;
            while (left < right) {
                j = left + ((right - left) >> 1);
                if (mat[i][j] == 1) {
                    left = j + 1;
                } else {
                    right = j;
                }
            }
            queue.offer(new int[]{i, left});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
