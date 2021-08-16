package com.cshawn.codes.leetcodes.everyday;

/**
 * 优美的排列
 * 假设有从 1 到 N 的N个整数，如果从这N个数字中成功构造出一个数组，使得数组的第 i位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。
 * 条件：
 * 1. 第i位的数字能被i整除
 * 2. i 能被第 i 位上的数字整除
 *
 *  现在给定一个整数 N，请问可以构造多少个优美的排列？
 *
 * 示例1:
 * 输入: 2
 * 输出: 2
 * 解释:
 *
 * 第 1 个优美的排列是 [1, 2]:
 *   第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
 *   第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
 *
 * 第 2 个优美的排列是 [2, 1]:
 *   第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
 *   第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
 * 说明:
 *
 * N 是一个正整数，并且不会超过15。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/beautiful-arrangement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/16 3:05 下午
 */
public class Q526 {
    // 方法1：回溯
    public int countArrangement1(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += backTracking(n, 2, 1 << i);
        }
        return result;
    }

    private int backTracking(int n, int index, int visited) {
        if (index == n + 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 当前数字i未被使用
            if ((visited & (1 << i)) == 0 && ((i + 1) % index == 0 || index % (i + 1) == 0)) {
                res += backTracking(n, index + 1, visited ^ (1 << i));
            }
        }
        return res;
    }

    // 方法2：动态规划
    public int countArrangement(int n) {
        int max = 1 << n;
        // dp[i]表示选择方式的mask为i的符合条件数量
        int[] dp = new int[max];
        dp[0] = 1;
        for (int mask = 1; mask < max; mask++) {
            // 1的个数即选择了几个数字，也即当前选择的位置是第几个
            int index = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && (index % (i + 1) == 0 || (i + 1) % index == 0)) {
                    dp[mask] += dp[mask ^ (1 << i)];
                }
            }
        }
        return dp[max - 1];
    }
}