package com.cshawn.codes.leetcodes.everyday;

/**
 * 等差数列划分
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * 通过次数41,427提交次数61,638
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/10 9:12 上午
 */
public class Q413 {
    // 方法1：双指针
    public int numberOfArithmeticSlices1(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int result = 0, pre = nums[1] - nums[0], start = 0, count = 0;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == pre) {
                if (i - start >= 2) {
                    result += ++count;
                }
            } else {
                start = i - 1;
                pre = diff;
                count = 0;
            }
        }
        return result;
    }

    // 方法2：动态规划
    public int numberOfArithmeticSlices2(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        // dp[i]表示以i结尾的等差数组个数
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int result = 0;
        for (int i : dp) {
            result += i;
        }
        return result;
    }

    // 方法3：优化动态规划
    public int numberOfArithmeticSlices3(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int dp_1 = 0, pre = nums[1] - nums[0], result = 0;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == pre) {
                result += dp_1 + 1;
                dp_1++;
            } else {
                dp_1 = 0;
            }
            pre = diff;
        }
        return result;
    }

    // 方法4：优化双指针
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int result = 0, pre = nums[1] - nums[0], count = 0;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == pre) {
                result += ++count;
            } else {
                pre = diff;
                count = 0;
            }
        }
        return result;
    }
}