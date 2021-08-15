package com.cshawn.codes.leetcodes.crack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/22 10:20 下午
 */
public class Q1_2 {
    // 哈希表统计字符出现次数，遍历第2个字符串并删除
    public boolean CheckPermutation1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        // <字符，出现的次数>
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int j = 0; j < s2.length(); j++) {
            if (map.get(s2.charAt(j)) == null) {
                // s1不存在s2当前字符，返回false
                return false;
            } else if (map.get(s2.charAt(j)) == 1) {
                // 只剩余一次时，删除当前字符
                map.remove(s2.charAt(j));
            } else {
                // 将次数减1
                map.put(s2.charAt(j), map.get(s2.charAt(j)) - 1);
            }
        }
        // map为空则刚好匹配
        return map.isEmpty();
    }

    // 可使用数组代替map
    public boolean CheckPermutation2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] aux = new char[128];
        for (int i = 0; i < s1.length(); i++) {
            aux[s1.charAt(i)]++;
        }
        for (int j = 0; j < s2.length(); j++) {
            if (aux[s2.charAt(j)] == 0) {
                // s1不存在s2当前字符，返回false
                return false;
            } else {
                // 将次数减1
                aux[s2.charAt(j)]--;
            }
        }
        for (int k = 0; k < aux.length; k++) {
            // 存在非零个数则不满足
            if (aux[k] != 0) {
                return false;
            }
        }
        return true;
    }

    // 将字符串排序，两者必然相同
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return new String(arr1).equals(new String(arr2));
    }
}
