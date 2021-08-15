package com.cshawn.codes.leetcodes.everyday;

import java.util.PriorityQueue;

/**
 * 下降路径最小和  II
 * 给你一个整数方阵arr，定义「非零偏移下降路径」为：
 * 从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * 请你返回非零偏移下降路径数字和的最小值。
 *
 * 示例 1：
 * 输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是[1,5,7] ，所以答案是13 。
 *
 * 提示：
 * 1 <= arr.length == arr[i].length <= 200
 * -99 <= arr[i][j] <= 99
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/22 2:54 下午
 */
public class Q1289 {
    // 动态规划 + 最小堆
    public int minFallingPathSum1(int[][] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[][] dp = new int[2][arr[0].length];
        System.arraycopy(arr[0], 0, dp[0], 0, arr[0].length);
        for (int i = 1; i < arr.length; i++) {
            int index = i & 1, pre = index ^ 1;
            heap.clear();
            for (int j = 0; j < dp[pre].length; j++) {
                heap.offer(dp[pre][j]);
            }
            for (int j = 0; j < dp[pre].length; j++) {
                heap.remove(dp[pre][j]);
                dp[index][j] = heap.peek() + arr[i][j];
                heap.offer(dp[pre][j]);
            }
        }
        int min = dp[(arr.length - 1) & 1][0];
        for (int j = 1; j < dp[0].length; j++) {
            min = Math.min(min, dp[(arr.length - 1) & 1][j]);
        }
        return min;
    }

    // 优化空间
    public int minFallingPathSum2(int[][] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] dp = new int[arr[0].length];
        System.arraycopy(arr[0], 0, dp, 0, arr[0].length);
        for (int i = 1; i < arr.length; i++) {
            heap.clear();
            for (int k : dp) {
                heap.offer(k);
            }
            for (int j = 0; j < dp.length; j++) {
                int cur = dp[j];
                heap.remove(cur);
                dp[j] = heap.peek() + arr[i][j];
                heap.offer(cur);
            }
        }
        int min = dp[0];
        for (int j = 1; j < dp.length; j++) {
            min = Math.min(min, dp[j]);
        }
        return min;
    }

    // 只记录最小值与次小值
    // 只有最小值下一行的元素选择的是上一行的次小值，其余的元素都选择的是最小值，因此只用记录两个值即可
    public int minFallingPathSum3(int[][] arr) {
        int[] dp = new int[arr[0].length];
        System.arraycopy(arr[0], 0, dp, 0, arr[0].length);
        for (int i = 1; i < arr.length; i++) {
            int min1Index = -1, min2Index = -1;
            for (int k = 0; k < dp.length; k++) {
                if (dp[k] < (min1Index == -1 ? Integer.MAX_VALUE : dp[min1Index])) {
                    min2Index = min1Index;
                    min1Index = k;
                } else if (dp[k] < (min2Index == -1 ? Integer.MAX_VALUE : dp[min2Index])) {
                    min2Index = k;
                }
            }
            int min1Value = dp[min1Index], min2Value = dp[min2Index];
            for (int j = 0; j < dp.length; j++) {
                dp[j] = arr[i][j] + (j == min1Index ? min2Value : min1Value);
            }
        }
        int min = dp[0];
        for (int j = 1; j < dp.length; j++) {
            min = Math.min(min, dp[j]);
        }
        return min;
    }

    // 优化空间，只存储最小次小两个值，及最终值
    public int minFallingPathSum(int[][] arr) {
        // 记录上一行的最小次数值
        int preMinIndex = -1, preMin1 = 0, preMin2 = 0;
        for (int[] nums : arr) {
            // 统计当前行的最小次小值
            int tempMin1 = Integer.MAX_VALUE;
            int tempMin2 = Integer.MAX_VALUE;
            int tempMin1Index = -1;
            for (int j = 0; j < nums.length; j++) {
                // 当前行的最小次小值为当前行得到的下降和的最小次小值
                int sum = nums[j] + (j == preMinIndex ? preMin2 : preMin1);
                if (sum < tempMin1) {
                    tempMin2 = tempMin1;
                    tempMin1 = sum;
                    tempMin1Index = j;
                } else if (sum < tempMin2) {
                    tempMin2 = sum;
                }
            }
            // 更新此行的最值
            preMin1 = tempMin1;
            preMin2 = tempMin2;
            preMinIndex = tempMin1Index;
        }
        return preMin1;
    }
}
