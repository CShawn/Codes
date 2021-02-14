package com.cshawn.leetcodes.everyday;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/10 10:43 下午
 */
public class Q5 {
    // 方法1：动态规划 [i,j]区间字符串回文字符串长度，dp[i][j]=dp[i+1][j-1]>0?dp[i+1][j-1]+2:0
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[][] dp = new int[s.length()][s.length()];
        int count = 0;
        String result = "";
        // 从右下角开始，沿对角线一行行斜向上
        for (int i = s.length() - 1; i >= 0; i--) {
            // 向右遍历
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    // 只有一个字符，长度为1
                    dp[i][j] = 1;
                } else {
                    // 判断当前首尾字符是否相同
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (i + 1 > j - 1) {
                        // 第2个字符和倒数第二个字符越界，则只取决于首尾字符
                        dp[i][j] = b ? 2 : 1;
                    } else {
                        // 首尾字符相同且i+1到j-1为回文则当前范围回文长度+2
                        dp[i][j] = b && dp[i + 1][j - 1] == j - i - 1 ? dp[i + 1][j - 1] + 2 : dp[i + 1][j - 1];
                    }
                }
                // 更新最大回文字符串
                if (dp[i][j] > count) {
                    count = dp[i][j];
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    // 方法2：Manacher
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 当前回文中心位置与当前最大回文字符串的右边界位置0123456,*1*3*5*7*9*
        int center = -1, right = -1;
        // 构造manacher数组，为每个字符之间及字符串首尾添加*
        char[] manacher = new char[s.length() * 2 + 1];
        for (int i = 0; i < manacher.length; i++) {
            manacher[i] = (i & 1) == 0 ? '*' : s.charAt((i - 1) >> 1);
        }
        // 记录以每个位置为中心的回文字符串半径
        int[] radius = new int[manacher.length];
        // 最大回文字符串半径,一个字符时为1
        int maxRadius = 0;
        String result = "";
        for (int i = 0; i < manacher.length; i++) {
            radius[i] = i >= right ? 1 : Math.min(radius[2 * center - i], right - i);
            // 从i加当前回文半径开始探求是否有更大回文半径
            while (i + radius[i] < manacher.length && i - radius[i] >= 0 && manacher[i + radius[i]] == manacher[i - radius[i]]) {
                radius[i]++;
            }
            // 当前回文范围扩大，更新右边界与中文中心
            if (i + radius[i] > right) {
                right = i + radius[i] - 1;
                center = i;
            }
            // 回文半径扩大
            if (radius[i] > maxRadius) {
                if ((i & 1) == 0) {
                    // 偶数时且回文半径>1
                    if (radius[i] > 1) {
                        int index = i >> 1;
                        int trueRadius = radius[i] >> 1;
                        // 获取当前回文字符串
                        result = s.substring(index - trueRadius, index + trueRadius);
                    }
                } else {
                    // 奇数时
                    int index = (i - 1) >> 1;
                    int trueRadius = (radius[i] - 1) >> 1;
                    // 获取当前回文字符串
                    result = s.substring(index - trueRadius, index + trueRadius + 1);
                }
                // 更新最大回文半径
                maxRadius = radius[i];
            }
        }
        return result;
    }
}
