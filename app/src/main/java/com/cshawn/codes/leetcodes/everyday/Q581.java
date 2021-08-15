package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/3 5:00 下午
 */
public class Q581 {
    // 方法1：排序
    public int findUnsortedSubarray1(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                left = i;
                break;
            }
        }
        if (left == -1) {
            return 0;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != temp[i]) {
                right = i;
                break;
            }
        }
        return right - left + 1;
    }

    // 方法2：一次遍历
    // 查找需要排序的边界left,right；left必然小于其右侧的所有数字，right必然大于其左侧的所有数字
    public int findUnsortedSubarray(int[] nums) {
        int left = -1, right = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 逆向遍历查找较小值
            int index = nums.length - 1 - i;
            if (nums[index] <= min) {
                min = nums[index];
            } else {
                // 当出现大于当前最小值的数字时，可能为左边界
                left = index;
            }
            // 正向遍历查找较大值，
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                // 当出现小于当前最大值的数字时，可能为右边界
                right = i;
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
