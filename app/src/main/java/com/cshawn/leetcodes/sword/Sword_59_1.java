package com.cshawn.leetcodes.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/25 6:50 下午
 */
public class Sword_59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 1) {
            return nums;
        }
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 定义双向队列，存储当前滑动窗口内的最大值，降序
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            add(nums[i], queue);
        }
        // 取出第一个滑动窗口的最大值
        result[0] = queue.peekFirst();
        // 从第2个滑动窗口开始
        for (int i = k; i < nums.length; i++) {
            // 当前要出滑动窗口的元素与当前最大值相等时，删除队列最大值
            if (nums[i - k] == queue.peekFirst()) {
                queue.pollFirst();
            }
            add(nums[i], queue);
            // 获取当前最大值并放入结果数组
            result[i - k + 1] = queue.peekFirst();
        }
        return result;
    }

    // 向滑动窗口中添加元素
    private void add(int num, Deque<Integer> queue) {
        // 当前元素比当前最大值大时，将双向队列清除
        if (!queue.isEmpty() && num > queue.peekFirst()) {
            queue.clear();
        }
        // 当前元素比当前最小值大时，无断删除比它小的元素
        while (!queue.isEmpty() && queue.peekLast() < num) {
            queue.pollLast();
        }
        // 最后加入当前元素
        queue.add(num);
    }
}
