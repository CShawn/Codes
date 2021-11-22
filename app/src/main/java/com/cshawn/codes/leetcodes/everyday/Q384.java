package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * 实现 Solution class:
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * 示例：
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 * 提示：
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 104 次 reset 和 shuffle
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/22 8:17 上午
 */
public class Q384 {
    static class Solution {
        private int[] origin;
        private int[] nums;
        Random random = new Random();
        public Solution(int[] nums) {
            origin = new int[nums.length];
            this.nums = new int[nums.length];
            System.arraycopy(nums, 0, origin, 0, nums.length);
            System.arraycopy(nums, 0, this.nums, 0, nums.length);
        }

        public int[] reset() {
            int[] reset = new int[origin.length];
            System.arraycopy(origin, 0, reset, 0, origin.length);
            return reset;
        }

        // 从origin中随机选一个数，放入新数组中
        // 为保证不重复，将origin放入list,每个选择数字后其删除
        public int[] shuffle1() {
            List<Integer> list = new ArrayList<>(origin.length);
            for (int k : origin) {
                list.add(k);
            }
            for (int i = 0; i < nums.length; i++) {
                int j = random.nextInt(list.size());
                nums[i] = list.remove(j);
            }
            return nums;
        }

        // 从list中删除元素比较浪费时间，将其与最后一个元素交换，则可以删除最后一个元素
        // 那么进一步，可以使用数组，不删除元素，只是与最后一个元素交换即可
        public int[] shuffle2() {
            int size = nums.length, temp;
            for (int i = 0; i < nums.length; i++) {
                int j = random.nextInt(size--);
                temp = nums[j];
                nums[j] = nums[size];
                nums[size] = temp;
            }
            return nums;
        }

        // 同理，可以交换当前位置与随机位置的数字
        public int[] shuffle() {
            int size = nums.length, temp;
            for (int i = 0; i < nums.length; i++) {
                int j = random.nextInt(size - i);
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return nums;
        }
    }
}
