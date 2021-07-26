package com.cshawn.leetcodes.everyday;

/**
 * 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * 提示：
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 * 进阶：
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到O(n log(n)) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/26 5:02 下午
 */
public class Q300 {
    // 方法1：动态规划
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp[i] 表示以第i个数字结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            // 在i之前的数字中，存在比nums[j]小的数字都可以构成上升子序列，统计最大值
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 统计过程中出现的最大值
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // 方法2：贪心+二分
    // 贪心：为使上升子序列尽可能长，则子序列的结尾数字要尽可能小
    // 二分：当遇到小于当前序列结尾的数字时，需要在当前序列中二分查找比此数小的数字
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // tail用来存储上升子序列
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[end]) {
                // 当前数字比结尾大时，直接拼接
                tail[++end] = nums[i];
            } else {
                // 当前数字比结尾小，二分查找合适的位置以替换
                int left = 0, right = end;
                while (left < right) {
                    int mid = left + ((right - left) >> 1);
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        return end + 1;
    }
}