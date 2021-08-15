package com.cshawn.codes.leetcodes.sword;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例  1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例  2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * 限制：数组长度为 5，数组的数取值为 [0, 13] .
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/26 3:52 下午
 */
public class Sword_61 {
    // 1.排序；2.非0数字相差小于5；3.无重复数字
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        // 记录第一个非0数字
        int not0 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                not0 = i + 1;
                continue;
            }
            // 两个数字重复返回false
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        // 第一个非0数与最后一个相差小于5则保证了连续
        return nums[nums.length - 1] - nums[not0] < 5;
    }

    // 方法2：不排序，判断不重复且最大最小值相差小于5
    public boolean isStraight2(int[] nums) {
        // 存储出现过的数字
        boolean[] n = new boolean[14];
        // 最值
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            // 数字重复
            if (n[num]) {
                return false;
            }
            // 存储出现过的数字
            n[num] = true;
            // 更新最值
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        // 最值相差小于5
        return max - min < 5;
    }
}
