package com.cshawn.codes.leetcodes.everyday;

/**
 * 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 *
 * 示例 4：
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *  
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/21 8:45 下午
 */
public class Q91 {
    int result = 0;
    // 方法1：回溯
    public int numDecodings1(String s) {
        backTracking(s, 0);
        return result;
    }

    private void backTracking(String s, int index) {
        if (index == s.length()) {
            result++;
            return;
        }
        char c = s.charAt(index);
        if (c == '0') {
            return;
        }
        backTracking(s, index + 1);
        if (index + 1 < s.length()) {
            if (c == '1' || (c == '2' && s.charAt(index + 1) < '7')) {
                backTracking(s, index + 2);
            }
        }
    }

    // 方法2：动态规划
    public int numDecodings2(String s) {
        // 当首字符为'0'时，不可解码
        if (s.charAt(0) == '0') {
            return 0;
        }
        // dp[i]表示字符串[0,i-1]的解码种数
        int[] dp = new int[s.length() + 1];
        // i等于2时，前两个字条组成[1,26]时，需取dp[0]的值，因此赋值为1
        dp[0] = 1;
        if (s.length() == 1) {
            return dp[0];
        }
        // 因为无需考虑'0'，因此一个字符时种数为1
        dp[1] = 1;
        char pre;
        for (int i = 2; i < dp.length; i++) {
            // 当前字符为'0'时，共有0种，否则，以单个字符来计算时等于dp[i-1]的种数
            dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
            // 当前字符与前一个字符组成一个[1,26]的数字时，再加上dp[i-2]的种数
            pre = s.charAt(i - 2);
            if (pre == '1' || (pre == '2' && s.charAt(i - 1) < '7')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    // 方法3：优化方法2
    // 方法2中，dp[i]只与dp[i-1]和dp[i-2]有关，因此可使用3个变量存储
    public int numDecodings(String s) {
        // 当首字符为'0'时，不可解码
        if (s.charAt(0) == '0') {
            return 0;
        }
        // 用于存储方法2中的3个变量
        int i_2 = 1, i_1 = 1, cur = 1;
        char pre;
        for (int i = 1; i < s.length(); i++) {
            // 当前字符为'0'时，共有0种，否则，以单个字符来计算时等于dp[i-1]的种数
            cur = s.charAt(i) == '0' ? 0 : i_1;
            // 当前字符与前一个字符组成一个[1,26]的数字时，再加上dp[i-2]的种数
            pre = s.charAt(i - 1);
            if (pre == '1' || (pre == '2' && s.charAt(i) < '7')) {
                cur += i_2;
            }
            i_2 = i_1;
            i_1 = cur;
        }
        return cur;
    }
}
