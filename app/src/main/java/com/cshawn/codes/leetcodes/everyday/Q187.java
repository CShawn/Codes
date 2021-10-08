package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * 提示：
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/8 5:43 下午
 */
public class Q187 {
    // 哈希表
    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                result.add(sub);
            } else {
                set.add(sub);
            }
        }
        return new ArrayList<>(result);
    }

    // 哈希表 + 滑动窗口
    // 4个字符分别用00,01,10,11表示，10个字符共20个bit，用一个int表示
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};
        int L = 10;
        int n = s.length();
        if (n <= L) {
            return new ArrayList<>();
        }
        int x = 0;
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        for (int i = 0; i <= n - L; ++i) {
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            if (set.contains(x)) {
                result.add(s.substring(i, i + L));
            } else {
                set.add(x);
            }
        }
        return new ArrayList<>(result);
    }
}
