package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/6 11:17 上午
 */
public class Q503 {
    // 方法1：暴力解，明显的N^2复杂度
    public int[] nextGreaterElements1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boolean find = false;
            // j加1后对长度取余，得到数组内的索引
            for (int j = (i + 1) % nums.length; j != i;) {
                if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    find = true;
                    break;
                }
                j = (j + 1) % nums.length;
            }
            if (!find) {
                result[i] = -1;
            }
        }
        return result;
    }

    // 当出现5,4,3,6,3这样的排列，找到第一个比5大的数字为6，
    // 4与3比5小，第一个比4、3大的数也是6，会重复查找。需要使用单调栈优化。
    // 维护一个单调递增栈，遇到第一个大于栈顶的元素时，更新栈中的元素对应的目标值
    public int[] nextGreaterElements(int[] nums) {
        int [] result = new int[nums.length];
        if (nums.length == 0) {
            return result;
        }
        Arrays.fill(result, -1);
        // 将数组扩展2倍但去掉最后一个元素（元素重复比较）
        int length = nums.length * 2 - 1;
        // 用数组实现栈，存入数字的索引
        int[] stack = new int[length + 1];
        int top = -1;
        for (int i = 0; i < length; i++) {
            int index = i % nums.length;
            // 栈不为空且当前元素比栈顶元素大，则将栈顶索引的位置存入当前元素并出栈
            while (top >= 0 && nums[index] > nums[stack[top]]) {
                result[stack[top--]] = nums[index];
            }
            // 存入当前元素的索引
            stack[++top] = index;
        }
        return result;
    }
}
