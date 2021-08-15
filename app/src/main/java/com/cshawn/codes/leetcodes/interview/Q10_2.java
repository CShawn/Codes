package com.cshawn.codes.leetcodes.interview;

import java.util.*;

/**
 * 变位词组
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/18 11:08 上午
 */
public class Q10_2 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] counter = new int[26];
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            Arrays.fill(counter, 0);
            sb.setLength(0);
            for (int i = 0; i < str.length(); i++) {
                counter[str.charAt(i) - 'a']++;
            }
            for (int c : counter) {
                sb.append(c).append(".");
            }
            String key = sb.toString();
            List<String> list = map.get(key);
            if (list == null) {
                list = new LinkedList<>();
                list.add(str);
                map.put(key, list);
            } else {
                list.add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(s, list);
                result.add(list);
            }
        }
        return result;
    }
}