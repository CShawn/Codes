package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * 提示：
 * nums.length在1到 50,000 区间范围内。
 * nums[i]是一个在 0 到 49,999 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/20 6:16 下午
 */
public class Q697 {
    public int findShortestSubArray(int[] nums) {
        // 结果数据，数字个数
        int result = 0, count = 0;
        // <数字，[个数，起始位置，结束位置]>
        Map<Integer, int[]> map = new HashMap<>();
        int[] arr;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                arr = new int[]{1, i, i};
                map.put(nums[i], arr);
            } else {
                arr = map.get(nums[i]);
                arr[0]++;
                arr[2] = i;
            }
            if (arr[0] > count) {
                result = arr[2] - arr[1] + 1;
                count = arr[0];
            } else if (arr[0] == count) {
                // 数字个数相同时，需要获取较小的长度
                result = Math.min(result, arr[2] - arr[1] + 1);
            }
        }
        return result;
    }
}
