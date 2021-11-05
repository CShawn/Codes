package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 * 示例 1：
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 *
 * 示例 2：
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 *
 * 示例 3：
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 * 提示：
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/5 10:04 上午
 */
public class Q1218 {
    // 动态规划 + 哈希表, 写的是个啥玩意
    public int longestSubsequence1(int[] arr, int difference) {
        // dp[i]表示以arr[i]结尾的子序列中最长的定差子序列
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        // 存储<数字，[对应索引]>
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int exist = arr[i] - difference;
            if (map.containsKey(exist)) {
                List<Integer> indexes = map.get(exist);
                for (int j : indexes) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            List<Integer> indexes = map.getOrDefault(arr[i], new ArrayList<>());
            indexes.add(i);
            map.put(arr[i], indexes);
        }
        int result = 1;
        for (int res : dp) {
            result = Math.max(res, result);
        }
        return result;
    }

    // 动态规划 + 哈希表
    public int longestSubsequence(int[] arr, int difference) {
        int result = 1;
        // 存储以某数字结尾的最长等差子序列
        Map<Integer, Integer> dp = new HashMap<>();
        for (int n : arr) {
            int count = dp.getOrDefault(n - difference, 0) + 1;
            dp.put(n, count);
            result = Math.max(result, count);
        }
        return result;
    }
}
