package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 子数组最小乘积的最大值
 * 一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
 * 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
 * 给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
 * 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
 * 子数组 定义为一个数组的 连续 部分。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 *
 * 示例 2：
 * 输入：nums = [2,3,3,1,2]
 * 输出：18
 * 解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
 * 3 * (3+3) = 3 * 6 = 18 。
 *
 * 示例 3：
 * 输入：nums = [3,1,5,6,4,2]
 * 输出：60
 * 解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
 * 4 * (5+6+4) = 4 * 15 = 60 。
 *
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 107
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray-min-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/9 11:11 上午
 */
public class Q5752 {
    // 方法1：直接计算，超时
    public int maxSumMinProduct1(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                sum += nums[j];
                result = Math.max(result, min * sum);
            }
        }
        return (int) (result % 1000000007);
    }

    // 在min变化后才计算，但仍超时
    public int maxSumMinProduct2(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                int temp = Math.min(min, nums[j]);
                if (temp != min) {
                    result = Math.max(result, min * sum);
                    min = temp;
                    sum += nums[j];
                    result = Math.max(result, min * sum);
                } else {
                    sum += nums[j];
                }
            }
            result = Math.max(result, min * sum);
        }
        return (int) (result % 1000000007);
    }

    // 单调栈+前缀和
    // 求每个以第i个数为最小值的子数组的最小乘积
    public int maxSumMinProduct3(int[] nums) {
        // 单调栈，存储的是索引位置
        int[] stack = new int[nums.length];
        int top = -1;
        // 记录i左侧第一个比i小的位置
        int[] left = new int[nums.length];
        // 记录i右侧第一个比i小的位置
        int[] right = new int[nums.length];
        // right[i]是非严格较小，即小于等于，初始值为最后一个元素
        Arrays.fill(right, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            while (top >= 0 && nums[i] <= nums[stack[top]]) {
                // 当前数字比栈顶元素小时，则栈顶元素对应位置的右侧第一个比它小的元素位置为当前元素位置
                right[stack[top]] = i - 1;
                // 出栈，维护栈的单调性
                top--;
            }
            // 当栈不为空时，说明存在比当前元素小的元素，当前元素左侧第一个比它小的元素位置为栈顶元素对应位置
            if (top >= 0) {
                left[i] = stack[top] + 1;
            }
            // 入栈
            stack[++top] = i;
        }
        // 前缀和
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, (sum[right[i] + 1] - sum[left[i]]) * nums[i]);
        }
        return (int) (result % 1000000007);
    }

    // 方法4：一次遍历
    public int maxSumMinProduct4(int[] nums) {
        int[] numss = new int[nums.length + 1];
        System.arraycopy(nums, 0, numss, 0, nums.length);
        numss[nums.length] = -1;
        int[] stack = new int[numss.length];
        long[] sum = new long[numss.length + 1];
        long result = 0;
        int top = -1;
        for (int i = 0; i < numss.length; i++) {
            sum[i + 1] = sum[i] + numss[i];
            while (top >= 0 && numss[i] < numss[stack[top]]) {
                int temp = numss[stack[top--]];
                int left = top < 0 ? 0 : stack[top] + 1;
                int right = i - 1;
                result = Math.max(result, temp * (sum[right + 1] - sum[left]));
            }
            stack[++top] = i;
        }
        return (int) (result % 1000000007);
    }
}