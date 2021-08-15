package com.cshawn.codes.leetcodes.sword;

/**
 * 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/11 8:58 下午
 */
public class Sword_42 {
    /**
     * 动态规划
     * dp[i]: 以nums[i]结尾的连续子数组的最大和。必须以nums[i]结尾才能保证形成连续子数组
     * dp[i - 1] > 0 -> dp[i] = dp[i - 1] + num[i]
     * else -> dp[i] = nums[i]
     * dp[0] = nums[0]
     * dp[i]只取决于dp[i - i]，只用存储一个数值，空间复杂度为O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 存储dp[i - 1]，即上一次的值
        int pre = 0;
        // 定义最终的最大值
        int max = nums[0];
        for (int num : nums) {
            if (pre > 0) {
                pre += num;
            } else {
                pre = num;
            }
            if (pre > max) {
                max = pre;
            }
        }
        return max;
    }

    /**
     * 利用前缀和，那么[i,j]最大和为sum[j]-sum[i]，
     * 取巧在于，遍历时，sum[j]减去哪一个数sum[x]得到的值最大，当然是sum[x]最小时。
     * 用一个数存储左侧最小的sum[x]，一次遍历即可。
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 存储最小的和
        int minSum = Math.min(0, nums[0]);
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum - minSum, max);
            minSum = Math.min(sum, minSum);
        }
        return max;
    }
}
