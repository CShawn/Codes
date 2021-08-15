package com.cshawn.codes.leetcodes.everyday;

/**
 * 尽可能使字符串相等
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 * 示例 1：
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 *
 * 示例 2：
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 *
 * 示例 3：
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 * 提示：
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s 和 t 都只含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/5 10:55 上午
 */
public class Q1208 {
    // 题意应为s和t的长度相同，统计每个字符的开销，双指针搞定
    public int equalSubstring(String s, String t, int maxCost) {
        if (s == null || t == null) {
            return 0;
        }
        // 取较小者的长度
        int n = Math.min(s.length(), t.length());
        // 构造每个字符差值的数组
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        // 定义双指针；临时长度计数；结果数据
        int left = 0, right = 0, res = 0, result = 0;
        while (right < n) {
            // >=0则减去right
            if (maxCost >= 0) {
                maxCost -= diffs[right++];
            } else {
                // <0则加上left并将当前res减1
                res--;
                maxCost += diffs[left++];
            }
            // 当前结果>=0时，累加res并更新result
            if (maxCost >= 0) {
                res++;
                if (res > result) {
                    result = res;
                }
            }
        }
        return result;
    }
}
