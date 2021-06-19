package com.cshawn.leetcodes.everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 串联字符串的最大长度
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，
 * 如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。请返回所有可行解 s 中最长长度。
 *
 * 示例 1：
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 *
 * 示例 2：
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 *
 * 示例 3：
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 *
 * 提示：
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i]中只含有小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/19 10:09 上午
 */
public class Q1239 {
    private int result = 0;
    // 回溯
    // 1 <= arr[i].length <= 26，可将arr[i]转为一个int值，每个字母为对应位置的1
    // 两个单词含不同字母则相与为0，相或后再与其他单词与或
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        for (String s : arr) {
            int num = 0;
            for (int j = 0; j < s.length(); j++) {
                int c = 1 << (s.charAt(j) - 'a');
                if ((num & c) != 0) {
                    num = 0;
                    break;
                }
                num |= c;
            }
            if (num != 0) {
                list.add(num);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
//        backTracking1(array, 0, 0);
        backTracking(array, 0, 0);
        return result;
    }

    private void backTracking1(int[] arr, int index, int pre) {
        if (index == arr.length) {
            // 最终统计或运算结果，1的个数既为原字符串的长度
            result = Math.max(result, Integer.bitCount(pre));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if ((pre & arr[i]) == 0) {
                // 与当前字符串可拼接时，继续判断下一字符串
                backTracking(arr, i + 1, pre | arr[i]);
            }
            // 不与当前字符串拼接，继续判断下一字符串
            backTracking(arr, i + 1, pre);
        }
    }

    // 优化回溯方法
    private void backTracking(int[] arr, int index, int pre) {
        if (index == arr.length) {
            // 最终统计或运算结果，1的个数既为原字符串的长度
            result = Math.max(result, Integer.bitCount(pre));
            return;
        }
        if ((pre & arr[index]) == 0) {
            // 与当前字符串可拼接时，继续判断下一字符串
            backTracking(arr, index + 1, pre | arr[index]);
        }
        // 不与当前字符串拼接，继续判断下一字符串
        backTracking(arr, index + 1, pre);
    }
}
