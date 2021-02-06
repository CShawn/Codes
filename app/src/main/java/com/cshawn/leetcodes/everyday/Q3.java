package com.cshawn.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/6 1:55 下午
 */
public class Q3 {
    // 滑动窗口，判断是否重复使用Hash表存储
    public int lengthOfLongestSubstring1(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        // 定义左右指针及结果数据（最小为单个字符1）
        int left = 0, right = 0, result = 1;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 包含当前字符，已重复
            if (map.containsKey(c)) {
                // 将重复字符出现之前的字符从map中删除
                int repeat = map.get(c);
                while (left < repeat) {
                    map.remove(s.charAt(left++));
                }
                // 更新重复字符的位置为当前right
                map.put(c, right);
                // 更新左指针为重复字符后一个字符
                left = repeat + 1;
                // 右移右指针
                right++;
            } else {
                // 未重复时，放入map，右移右指针并更新result
                map.put(c, right++);
                result = Math.max(result, right - left);
            }
        }
        return result;
    }

    // 涉及到字符集，可使用128数组提高速度
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        int result = 1;
        // 字符集，初始为0，为方便，不初始化为-1，存储元素的位置为index+1
        int[] set = new int[128];
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            // 更新左指针位置为重复字符的下一个位置
            start = Math.max(start, set[c]);
            // 更新结果为较大长度
            result = Math.max(result, i - start + 1);
            // 存储当前字符的位置为i+1而不是i
            set[c] = i + 1;
        }
        return result;
    }
}