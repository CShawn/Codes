package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数组中好对子的数目
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 * 示例 1：
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 *  - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 *  - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 *
 * 示例 2：
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * 提示：
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * @author C.Shawn
 * @date 2021/4/3 10:26 下午
 */
public class Q5708 {
    // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
    // 可以推出：num[i] - rev(nums[i]) = num[j] - rev(num[j])
    // 那么可以得到每个位置上num[i] - rev(nums[i])，用map统计相同数值的个数，再统计对数
    public int countNicePairs1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - rev(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            // 两个以上的数字可以成对
            if (value > 1) {
                // n个数字可成对数为1+2+...+(n-1) = n * (n - 1) / 2
                result += (((long)value * (long)value - value) >> 1) % 1000000007;
            }
        }
        return result;
    }

    // 优化方法1
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - rev(nums[i]);
            Integer preCount = map.getOrDefault(nums[i], 0);
            // 当又一次产生了一个已存在的数值时，这个i位置上的数可与之前的preCount个数产生preCount对目标值
            result += preCount;
            map.put(nums[i], preCount + 1);
        }
        return result;
    }

    private int rev(int n) {
        int result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n = n / 10;
        }
        return result;
    }
}
