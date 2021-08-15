package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/7 8:30 下午
 */
public class Q131 {
    private boolean[][] palindromic;
    public List<List<String>> partition1(String s) {
        // 预处理s中的回文子字符串[i,j]是否回文
        palindromic = new boolean[s.length()][s.length()];
        // [i][j]依赖于[i + 1][j - 1]，所以从右下角斜向上，从右向左
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= i; j--) {
                palindromic[i][j] = s.charAt(i) == s.charAt(j) &&
                        (i + 1 >= j - 1 || palindromic[i + 1][j - 1]);
            }
        }
        // 结果集
        List<List<String>> result = new ArrayList<>();
        // 一个回文子集
        List<String> answer = new ArrayList<>();
        backtrack(s, 0, answer, result);
        return result;
    }

    /**
     * 回溯法获取当前的回文子字符串组
     * @param s 字符串
     * @param i 起始位置
     * @param answer 一条回文子集
     * @param result 结果集
     */
    private void backtrack(String s, int i, List<String> answer, List<List<String>> result) {
        // 遍历到结尾时添加一条结果
        if (i == s.length()) {
            result.add(new ArrayList<>(answer));
            return;
        }
        // 从i开始遍历
        for (int j = i; j < s.length(); j++) {
            // 从i到当前位置为回文时
            if (palindromic[i][j]) {
                // 添加一个回文字符串
                answer.add(s.substring(i, j + 1));
                // 接着向后遍历查找新的子回文串
                backtrack(s, j + 1, answer, result);
                // 遍历完一次后，将当前结果子集的最后一条字符串移除回溯，继续向前
                answer.remove(answer.size() - 1);
            }
        }
    }

    private int[][] dp;
    // 不提前预处理palindromic，取值时才计算
    public List<List<String>> partition(String s) {
        dp = new int[s.length()][s.length()];
        // 结果集
        List<List<String>> result = new ArrayList<>();
        // 一个回文子集
        List<String> answer = new ArrayList<>();
        backtrack2(s, 0, answer, result);
        return result;
    }

    private void backtrack2(String s, int i, List<String> answer, List<List<String>> result) {
        // 遍历到结尾时添加一条结果
        if (i == s.length()) {
            result.add(new ArrayList<>(answer));
            return;
        }
        // 从i开始遍历
        for (int j = i; j < s.length(); j++) {
            // 从i到当前位置为回文时
            if (isPalindromic(s, i, j)) {
                // 添加一个回文字符串
                answer.add(s.substring(i, j + 1));
                // 接着向后遍历查找新的子回文串
                backtrack2(s, j + 1, answer, result);
                // 遍历完一次后，将当前结果子集的最后一条字符串移除回溯，继续向前
                answer.remove(answer.size() - 1);
            }
        }
    }

    private boolean isPalindromic(String s, int i, int j) {
        if (dp[i][j] == 1) {
            return true;
        }
        if (dp[i][j] == -1) {
            return false;
        }
        if (s.charAt(i) == s.charAt(j) && (i + 1 >= j - 1 || dp[i + 1][j - 1] == 1)) {
            dp[i][j] = 1;
            return true;
        } else {
            dp[i][j] = -1;
            return false;
        }
    }
}
