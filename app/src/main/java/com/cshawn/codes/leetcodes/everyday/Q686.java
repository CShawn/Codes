package com.cshawn.codes.leetcodes.everyday;

/**
 * 重复叠加字符串匹配
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 * 示例 1：
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 *
 * 示例 2：
 * 输入：a = "a", b = "aa"
 * 输出：2
 *
 * 示例 3：
 * 输入：a = "a", b = "a"
 * 输出：1
 *
 * 示例 4：
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *
 * 提示：
 * 1 <= a.length <= 104
 * 1 <= b.length <= 104
 * a 和 b 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/22 10:15 上午
 */
public class Q686 {
    public int repeatedStringMatch1(String a, String b) {
        int i = 0, j = 0, result = 1, iStart = 0;
        while (true) {
            while (i < a.length() && j < b.length()) {
                if (a.charAt(i) == b.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (j == 0) {
                        i++;
                    } else {
                        if (++iStart < a.length()) {
                            i = iStart;
                            j = 0;
                            result = 1;
                        } else {
                            result = -1;
                            return result;
                        }
                    }
                }
            }
            if (j == 0 && i == a.length()) {
                result = -1;
                break;
            }
            if (j == b.length()) {
                break;
            }
            i = 0;
            result++;
        }
        return result;
    }

    // 使用KMP算法优化方法1
    // 参见Q28
    public int repeatedStringMatch(String a, String b) {
        int[] next = new int[b.length()];
        next[0] = -1;
        for (int i = 0, k = -1; i < b.length() - 1;) {
            if (k == -1 || b.charAt(i) == b.charAt(k)) {
                if (b.charAt(++i) != b.charAt(++k)) {
                    next[i] = k;
                } else {
                    next[i] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        int la = a.length(), lb = b.length();
        int i = 0, j = 0;
        // j遍历不超过b的长度，查找遍历次数上限i与j之差比la小
        while (j < lb && i - j < la) {
            // 当n为-1时，重新从头匹配
            if (j == -1 || a.charAt(i % la) == b.charAt(j)) {
                i++;// 向右移动m
                j++;// n = 0
            } else {
                // 跳到n所对应的倒退位置
                j = next[j];
            }
        }
        if (j == lb) {
            int index = i - lb;
            if (la - index >= lb) {
                return 1;
            }
            return (index + lb - la - 1) / la + 2;
        }
        return -1;
    }
}
