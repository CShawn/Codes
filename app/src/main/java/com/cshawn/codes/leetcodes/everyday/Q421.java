package com.cshawn.codes.leetcodes.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中两个数的最大异或值
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 *
 * 示例 1：
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：nums = [2,4]
 * 输出：6
 *
 * 示例 4：
 * 输入：nums = [8,10,2]
 * 输出：10
 *
 * 示例 5：
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/16 9:00 下午
 */
public class Q421 {
    // 两两异或，复杂度为O(N^2), 必然超时
    // 按位运算，降为32N(int为32位)
    public int findMaximumXOR1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int x = 0;
        // 保留每个数字的高k位，判断是否含1
        for (int k = 30; k >= 0; k--) {
            set.clear();
            for (int num : nums) {
                set.add(num >> k);
            }
            // 将x右边添加一位1
            int xNext = (x << 1) | 1;
            boolean found = false;
            for (int num : nums) {
                // set包含xNext ^ (num >> k),意思是set中一个数异或num >> k，得到xNext
                // 也就是说，存在两个数异或后得到xNext
                if (set.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            // 存在时，可累计x；不存在时，末位取0
            x = found ? xNext : x << 1;
        }
        return x;
    }

    // 优化方法1，异或最大值必然为数组最大值和其中一个值的异或
    public int findMaximumXOR(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        Set<Integer> set = new HashSet<>();
        int x = 0;
        // 保留每个数字的高k位，判断是否含1
        for (int k = 31 - Integer.numberOfLeadingZeros(max); k >= 0; k--) {
            set.clear();
            x <<= 1;
            // 将x右边添加一位1
            int xNext = x | 1;
            for (int num : nums) {
                set.add(num >> k);
                // set包含xNext ^ (num >> k),意思是set中一个数异或num >> k，得到xNext
                // 也就是说，存在两个数异或后得到xNext
                if (set.contains(xNext ^ (num >> k))) {
                    x |= 1;
                    break;
                }
            }
        }
        return x;
    }
}
