package com.cshawn.codes.leetcodes.sword;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 限制：0 <= s 的长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/18 9:57 下午
 */
public class Sword_50 {
    /**
     * 有序Hash表。LinkedHashMap<Character, Boolean>
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }
        for (Character c: map.keySet()) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 因题目中字符集只包括小写字母，那么，可以使用长度为26的数组
     */
    public char firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        // 遍历s，为保证字符顺序
        for (int i = 0; i < s.length(); i++) {
            // 找到出现1次的字符
            if (chars[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
