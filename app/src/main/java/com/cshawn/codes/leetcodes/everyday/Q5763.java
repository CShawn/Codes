package com.cshawn.codes.leetcodes.everyday;

/**
 * 哪种连续子字符串更长
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
 *
 * 示例 1：
 * 输入：s = "1101"
 * 输出：true
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："1101"
 * 由 0 组成的最长连续子字符串的长度是 1："1101"
 * 由 1 组成的子字符串更长，故返回 true 。
 *
 * 示例 2：
 * 输入：s = "111000"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 3："111000"
 * 由 0 组成的最长连续子字符串的长度是 3："111000"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 *
 * 示例 3：
 * 输入：s = "110100010"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："110100010"
 * 由 0 组成的最长连续子字符串的长度是 3："110100010"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 *
 * 提示：
 * 1 <= s.length <= 100
 * s[i] 不是 '0' 就是 '1'
 * @author C.Shawn
 * @date 2021/5/23 12:08 下午
 */
public class Q5763 {
    public boolean checkZeroOnes(String s) {
        int s0 = 0, s1 = 0, l0 = 0, l1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                s0++;
                s1 = 0;
            } else {
                s1++;
                s0 = 0;
            }
            l0 = Math.max(s0, l0);
            l1 = Math.max(s1, l1);
        }
        return l1 > l0;
    }
}