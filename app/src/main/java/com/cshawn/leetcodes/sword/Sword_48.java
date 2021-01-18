package com.cshawn.leetcodes.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/18 3:33 下午
 */
public class Sword_48 {
    /**
     * 两个指针，分别指向子串的两端，不重复则将右边界右移，有重复则将左边界右移直到无重复
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        // 定义当前不重复子串的两侧边界和当前最大子串的长度
        int left = 0, right = 0, max = 0;
        // 遍历到右边界超出
        while (right < s.length()) {
            // 当前子串是否有重复字符
            boolean repeat = false;
            // 遍历当前子串
            for (int i = left; i < right; i++) {
                // 若有重复
                if (s.charAt(i) == s.charAt(right)) {
                    // 将左边界置为重复字符的后一个字符的位置
                    left = i + 1;
                    // 标记有重复
                    repeat = true;
                    break;
                }
            }
            // 无重复时才计算最大子串长度，有重复必然比之前的max要小
            if (!repeat) {
                // 当前子串长度
                int length = right - left + 1;
                // 更新最大值
                if (length > max) {
                    max = length;
                }
            }
            // 右侧边界向右移动
            right++;
        }
        return max;
    }

    // 查找子串是否有重复时，可以使用HashMap来优化速度
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        // 定义当前不重复子串的两侧边界和当前最大子串的长度
        int left = 0, right = 0, max = 0;
        // 存储字符出现的位置,字符集最多256个
        Map<Character, Integer> map = new HashMap<>(256);
        // 遍历到右边界超出
        while (right < s.length()) {
            int index = map.getOrDefault(s.charAt(right), -1);
            // 若有重复
            if (index >= left) {
                // 将左边界置为重复字符的后一个字符的位置
                left = index + 1;
            } else {
                // 无重复时才计算最大子串长度，有重复必然比之前的max要小
                // 当前子串长度
                int length = right - left + 1;
                // 更新最大值
                if (length > max) {
                    max = length;
                }
            }
            map.put(s.charAt(right), right);
            // 右侧边界向右移动
            right++;
        }
        return max;
    }

    /**
     * 动态规划
     * dp[i]表示以s[i]结尾的最大不重复子串
     * 查找s[i]是否出现过，出现位置记为j
     * 如果index在i - dp[i - 1]之前，则dp[i] = dp[i - 1] + 1
     * 如果在[i - dp[i], i]之间，则dp[i] = i - index
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 存储字符出现的位置,字符集最多256个
        Map<Character, Integer> map = new HashMap<>(256);
        int[] dp = new int[s.length()];
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            int index = map.getOrDefault(s.charAt(i), -1);
            if (index < i - dp[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = i - index;
            }
            map.put(s.charAt(i), i);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
