package com.cshawn.codes.leetcodes.everyday;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/3 8:42 上午
 */
public class Q42 {
    // 单调栈
    public int trap1(int[] height) {
        int result = 0;
        // 单调栈中存储元素索引，栈底到栈顶索引对应的高度递减
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 当前可能可以积水的柱子
                int target = stack.pop();
                // 没有左边界，无法积水
                if (stack.isEmpty()) {
                    break;
                }
                // 找到左边界
                int left = stack.peek();
                // 计算当前可积水量
                result += (Math.min(height[left], height[i]) - height[target]) * (i - left - 1);
            }
            stack.push(i);
        }
        return result;
    }

    // 双指针
    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
