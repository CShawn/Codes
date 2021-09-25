package com.cshawn.codes.leetcodes.everyday;

/**
 * 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意:给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/20 11:34 上午
 */
public class Q673 {
    // 动态规划
    public int findNumberOfLIS(int[] nums) {
        int max = 0, result = 0;
        // dp[i]表示以nums[i]结尾的最长递增子序的长度
        int[] dp = new int[nums.length];
        // counts[i]表示以nums[i]结尾的最长递增子序的个数
        int[] counts = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        counts[i] = counts[j];
                        dp[i] = dp[j] + 1;
                    } else if (dp[j] + 1 == dp[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                result = counts[i];
            } else if (dp[i] == max) {
                result += counts[i];
            }
        }
        return result;
    }
}
