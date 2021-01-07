package com.cshawn.leetcodes.sword;

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * 限制：1 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/7 9:42 下午
 */
public class Sword_39 {
    /**
     * 方法1：使用Map存储数字出现次数
     * 方法2：排序，取中位数即为目标值
     * 方法3：摩尔投票法，将不同的数字两两抵消，最后剩余的数字即为目标值
     */
    public int majorityElement(int[] nums) {
        // 定义存储结果的数字，和数字出现的次数
        int num = 0, count = 0;
        for (int j : nums) {
            if (count == 0) {
                // 计数为0时，重新指定数字
                num = j;
                count++;
            } else if (j == num) {
                // 数字相同时，计数加1
                count++;
            } else {
                // 数字不同时，计数减1
                count--;
            }
        }
        return num;
    }
}
