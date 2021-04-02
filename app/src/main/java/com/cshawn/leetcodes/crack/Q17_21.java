package com.cshawn.leetcodes.crack;

import java.util.Map;

/**
 * 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/2 4:03 下午
 */
public class Q17_21 {
    // 每个格子能存储的最大水量取决于左右两侧最大亮度的柱子
    // 方法1：动态规划
    public int trap1(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        // 记录每个格子左侧的最大亮度
        int[] leftMax = new int[height.length];
        // 记录每个格子右侧的最大亮度
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            // leftMax是递增的，i-1是i前边所有元素中最大的
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            // 每格的最大水量为左右两侧最高者的较小值减去当前格子高度
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }

    // 方法2：单调栈
    public int trap2(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int result = 0;
        // 单调递减栈，栈中存储的是索引，以方便求水的宽度
        int[] stack = new int[height.length];
        int top = -1;
        for (int i = 0; i < height.length; i++) {
            while (top >= 0 && height[i] > height[stack[top]]) {
                // 找到当前范围内的左右两侧最大值中的较小者
                int min = Math.min(height[stack[0]], height[i]);
                // 栈中只有一个值时，两个柱子，中间无法存水
                if (top > 0) {
                    // 可以存水的量，高度为min减去当前柱子的高度，宽度为从当前柱子到栈中前一个柱子的距离
                    result += (min - height[stack[top]]) * (stack[top] - stack[top - 1]);
                }
                top--;
            }
            stack[++top] = i;
        }
        return result;
    }

    // 方法3：双指针
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, result = 0, leftMax = 0, rightMax = 0;
        while (left < right) {
            // 更新左右两侧的最大值
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 根据左右两侧的最大值的大小，更新当前柱子可存储的水量
            if (height[left] < height[right]) {
                result += leftMax - height[left++];
            } else {
                result += rightMax - height[right--];
            }
        }
        return result;
    }
}
