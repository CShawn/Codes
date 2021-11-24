package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 从英文中重建数字
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 * 示例 1：
 * 输入：s = "owoztneoer"
 * 输出："012"
 *
 * 示例 2：
 * 输入：s = "fviefuro"
 * 输出："45"
 *
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/24 3:15 下午
 */
public class Q423 {
    // 找规律
    // z, w, u, x, g 都只在 0, 2, 4, 6, 8中出现一次
    // h出现在3,8中，f出现在4,5中，s出现在6,7中
    // o 只在 0, 1, 2, 4中出现
    // 9 就可以通过 n, i, e 中的任一字符计算得到了,使用i 进行计算
    public String originalDigits1(String s) {
        int[] counts = new int[10];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        counts[0] = map.getOrDefault('z', 0);
        counts[2] = map.getOrDefault('w', 0);
        counts[4] = map.getOrDefault('u', 0);
        counts[6] = map.getOrDefault('x', 0);
        counts[8] = map.getOrDefault('g', 0);

        counts[3] = map.getOrDefault('h', 0) - counts[8];
        counts[5] = map.getOrDefault('f', 0) - counts[4];
        counts[7] = map.getOrDefault('s', 0) - counts[6];

        counts[1] = map.getOrDefault('o', 0) - counts[0] - counts[2] - counts[4];
        counts[9] = map.getOrDefault('i', 0) - counts[5] - counts[6] - counts[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    // 优化Map
    public String originalDigits(String s) {
        int[] counts = new int[10];
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
        }
        counts[0] = map['z' - 'a'];
        counts[2] = map['w' - 'a'];
        counts[4] = map['u' - 'a'];
        counts[6] = map['x' - 'a'];
        counts[8] = map['g' - 'a'];

        counts[3] = map['h' - 'a'] - counts[8];
        counts[5] = map['f' - 'a'] - counts[4];
        counts[7] = map['s' - 'a'] - counts[6];

        counts[1] = map['o' - 'a'] - counts[0] - counts[2] - counts[4];
        counts[9] = map['i' - 'a'] - counts[5] - counts[6] - counts[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
