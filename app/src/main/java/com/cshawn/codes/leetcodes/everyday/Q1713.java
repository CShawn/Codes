package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 得到子序列的最少操作次数
 * 给你一个数组target，包含若干 互不相同的整数，以及另一个整数数组arr，arr可能 包含重复元素。
 * 每一次操作中，你可以在 arr的任意位置插入任一整数。比方说，如果arr = [1,4,1,2]，那么你可以在中间添加 3得到[1,4,3,1,2]。你可以在数组最开始或最后面添加整数。
 * 请你返回 最少操作次数，使得target成为arr的一个子序列。
 * 一个数组的 子序列指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4]是[4,2,3,7,2,1,4]的子序列（加粗元素），但[2,4,2]不是子序列。
 *
 * 示例 1：
 * 输入：target = [5,1,3], arr = [9,4,2,3,4]
 * 输出：2
 * 解释：你可以添加 5 和 1 ，使得 arr 变为 [5,9,4,1,2,3,4] ，target 为 arr 的子序列。
 *
 * 示例 2：
 * 输入：target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
 * 输出：3
 *
 * 提示：
 * 1 <= target.length, arr.length <= 105
 * 1 <= target[i], arr[i] <= 109
 * target不包含任何重复元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/26 5:00 下午
 */
public class Q1713 {
    // 最长上升子序列: 贪心+二分
    // 题意为求最长公共子序列，但target不重复，则可先得到arr中元素在target中出现的位置（未出现的忽略）。
    // target中自身元素出现的位置为[0,1,2,3...]，假设arr在target中出现位置为[3,0,2,4...]
    // 则在这两个数组中查找公共子序列，又因为target递增，题意转化为在这第2个数组中查找最长上升子序列
    public int minOperations1(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        int[] tail = new int[target.length];
        int end = -1;
        for (int num : arr) {
            if (map.containsKey(num)) {
                int cur = map.get(num);
                if (end < 0) {
                    tail[++end] = cur;
                } else {
                    if (tail[end] < cur) {
                        tail[++end] = cur;
                    } else {
                        int left = 0, right = end, mid;
                        while (left < right) {
                            mid = left + ((right - left) >> 1);
                            if (tail[mid] < cur) {
                                left = mid + 1;
                            } else {
                                right = mid;
                            }
                        }
                        tail[left] = cur;
                    }
                }
            }
        }
        // 结果为target长度-最长上升子序列长度
        return target.length - ++end;
    }

    // 优化判断条件
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        int[] tail = new int[target.length + 1];
        int end = 0;
        for (int num : arr) {
            if (map.containsKey(num)) {
                int cur = map.get(num);
                int left = 0, right = end, pos = 0, mid;
                while (left <= right) {
                    mid = left + ((right - left) >> 1);
                    if (tail[mid] < cur) {
                        left = mid + 1;
                        pos = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                tail[pos + 1] = cur;
                end = Math.max(pos + 1, end);
            }
        }
        // 结果为target长度-最长上升子序列长度
        return target.length - end;
    }
}
