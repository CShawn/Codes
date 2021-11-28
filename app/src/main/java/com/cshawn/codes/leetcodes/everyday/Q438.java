package com.cshawn.codes.leetcodes.everyday;

import java.util.LinkedList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 提示:
 * 1 <= s.length, p.length <= 3 * 104
 * s和p仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/28 11:19 上午
 */
public class Q438 {
    // 方法1：哈希表 + 滑动窗口
    // 方法2稍慢但简单，未实现：固定滑动窗口大小，每次增加right减去left对应的字符，统计是两数组否匹配
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        int[] target = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        boolean match;
        int[] cur = new int[26];
        int index;
        while (right < s.length()) {
            index = s.charAt(right) - 'a';
            cur[index]++;
            if (cur[index] == target[index]) {
                match = true;
                for (int i = 0; i < 26; i++) {
                    if (cur[i] != target[i]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(left);
                    cur[s.charAt(left++) - 'a']--;
                }
            } else if (cur[index] > target[index]) {
                while (cur[index] > target[index] && left <= right) {
                    cur[s.charAt(left++) - 'a']--;
                }
            }
            right++;
        }
        return result;
    }
}
