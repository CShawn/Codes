package com.cshawn.codes.leetcodes.everyday;

import java.util.TreeSet;

/**
 * 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/6 10:02 下午
 */
public class Q414 {
    // 方法1：优先级队列
    public int thirdMax1(int[] nums) {
        TreeSet<Integer> queue = new TreeSet<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > 3) {
                queue.remove(queue.first());
            }
        }
        return queue.size() == 3 ? queue.first() : queue.last();
    }

    // 方法2：依次赋值
    public int thirdMax2(int[] nums) {
        long max = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max3 = max2;
                max2 = max;
                max = num;
            } else if (num < max && num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num < max2 && num > max3) {
                max3 = num;
            }
        }
        return max3 == Long.MIN_VALUE ? (int) max : (int) max3;
    }

    // 方法3:优化方法2
    public int thirdMax(int[] nums) {
        Integer max = null, max2 = null, max3 = null;
        for (int num : nums) {
            if (max == null || num > max) {
                max3 = max2;
                max2 = max;
                max = num;
            } else if (num < max && (max2 == null || num > max2)) {
                max3 = max2;
                max2 = num;
            } else if (max2 != null && num < max2 && (max3 == null || num > max3)) {
                max3 = num;
            }
        }
        return max3 == null ? max : max3;
    }
}
