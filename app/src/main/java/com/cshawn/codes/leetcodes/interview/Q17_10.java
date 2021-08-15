package com.cshawn.codes.leetcodes.interview;

/**
 * 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
 * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 *
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/9 2:52 下午
 */
public class Q17_10 {
    // 投票算法
    // 将不同的数字两两抵消，剩余的就可能是大多数，需要再检验一次
    public int majorityElement(int[] nums) {
        int result = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
                count++;
            } else {
                if (num == result) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        // 完全抵消时，返回-1
        if (count == 0) {
            return -1;
        }
        // 再检验一次剩余的数字是否是大多数
        count = 0;
        for (int num : nums) {
            if (num == result) {
                count++;
            }
        }
        return (count << 1) > nums.length ? result : -1;
    }
}
