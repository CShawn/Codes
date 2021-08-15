package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 同构字符串
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 *
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 * 提示：
 * 可以假设s和 t 长度相同。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/15 5:22 下午
 */
public class Q205 {
    // 方法1：哈希表
    public boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> maps = new HashMap<>();
        Set<Character> mapt = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!maps.containsKey(s.charAt(i)) && !mapt.contains(t.charAt(i))) {
                maps.put(s.charAt(i), t.charAt(i));
                mapt.add(t.charAt(i));
            } else {
                if (maps.get(s.charAt(i)) == null || t.charAt(i) != maps.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    // 方法2：数组模拟哈希表
    public boolean isIsomorphic(String s, String t) {
        char[] maps = new char[128];
        boolean[] mapt = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            if (maps[s.charAt(i)] == '\0' && !mapt[t.charAt(i)]) {
                maps[s.charAt(i)] = t.charAt(i);
                mapt[t.charAt(i)] = true;
            } else {
                if (maps[s.charAt(i)] == '\0' || maps[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
