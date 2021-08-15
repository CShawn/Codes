package com.cshawn.codes.leetcodes.sword;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：[2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3 
 * 限制：2 <= n <= 100000
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 */
public class Sword_3 {
    // 因为数字在0~n-1范围内，所以可以将每个数字放到其值对应的位置，
    // 若在同一位置重复放置则视为重复
    public int findRepeatNumber(int[] nums) {
        // 临时存储用于交换
        int temp;
        for (int i = 0; i < nums.length;) {
            if (i != nums[i]) {
                // 在同一位置重复放置相同数字，视为重复
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 将i位置的元素与其中数字对应的位置nums[i]中的数字交换
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            } else {
                // 当数值与位置对应后，进入下一个位置比较，
                // 否则不进行i++，一直在i位置比较并交换
                i++;
            }
        }
        // 返回无效值
        return -1;
    }
}