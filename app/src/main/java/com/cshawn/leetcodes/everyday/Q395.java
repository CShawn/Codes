package com.cshawn.leetcodes.everyday;

/**
 * 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 * 示例 1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 * 示例 2：
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/27 8:38 下午
 */
public class Q395 {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return longestSubstring(s, k, 0, s.length());
    }

    private int longestSubstring(String s, int k, int start, int end) {
        // 长度不足k，返回0
        if (start == end || end - start < k) {
            return 0;
        }
        // 统计当前范围每个字符出现的次数
        int[] chars = new int[26];
        for (int i = start; i < end; i++) {
            chars[s.charAt(i) - 'a']++;
        }
        boolean match = true;
        // 标记是否满
        for (int i = 0; i < 26; i++) {
            // 复用此数组，用以存储不足k个的字符：将其赋值为1，其余字符赋值为0
            if (chars[i] > 0 && chars[i] < k) {
                chars[i] = 1;
                match = false;
            } else {
                chars[i] = 0;
            }
        }
        // 满足条件则为当前子串长度
        if (match) {
            return end - start;
        }
        // 当前子串中有不足k个的字符时，再进行切分，分治其子串
        int result = 0;
        int startIndex = start;
        for (int i = start; i < end; i++) {
            // 分治不足k个的字符之前的字符串
            if (chars[s.charAt(i) - 'a'] == 1) {
                int temp = longestSubstring(s, k, startIndex, i);
                startIndex = i + 1;
                if (temp > result) {
                    result = temp;
                }
            }
        }
        // 当最后一个字符>=k个时，需要将上一次切分的后半部分进行分治
        if (chars[s.charAt(end - 1) - 'a'] == 0) {
            int temp = longestSubstring(s, k, startIndex, end);
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }
}
