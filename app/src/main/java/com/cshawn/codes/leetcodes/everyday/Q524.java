package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1：
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 *
 * 示例 2：
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/14 8:48 上午
 */
public class Q524 {
    // 排序 + 双指针
    public String findLongestWord1(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) ->
                o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length()
        );
        for (String str : dictionary) {
            int i = 0, j = 0;
            while (i < s.length() && j < str.length()) {
                if (s.charAt(i) == str.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == str.length()) {
                return str;
            }
        }
        return "";
    }

    // 一次遍历
    public String findLongestWord2(String s, List<String> dictionary) {
        String result = "";
        int sl = s.length();
        for (String str : dictionary) {
            int jl = str.length(), rl = result.length();
            if (jl > rl || (jl == rl && str.compareTo(result) < 0)) {
                int i = 0, j = 0;
                while (i < sl && j < jl) {
                    if (s.charAt(i) == str.charAt(j)) {
                        j++;
                    }
                    i++;
                }
                if (j == jl) {
                    result = str;
                }
            }
        }
        return result;
    }

    // 动态规划
    // 方法1，2的重复之处在于每次对s的遍历，如果可以预处理s，
    // 对于每个字符可以知道在s中是否出现及出现的位置，则可以提高速度
    public String findLongestWord(String s, List<String> dictionary) {
        int len = s.length();
        String result = "";
        // dp[i][j]表示s从索引i开始，字符j首次出现的位置
        int[][] dp = new int[len + 1][26];
        Arrays.fill(dp[len], len);
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = s.charAt(i) == 'a' + j ? i : dp[i + 1][j];
            }
        }
        for (String str : dictionary) {
            int i = 0, dl = str.length();
            boolean match = true;
            for (int j = 0; j < dl; j++) {
                int c = str.charAt(j) - 'a';
                if (dp[i][c] == len) {
                    match = false;
                    break;
                }
                i = dp[i][c] + 1;
            }
            if (match) {
                if (dl > result.length() || (str.length() == result.length() && str.compareTo(result) < 0)) {
                    result = str;
                }
            }
        }
        return result;
    }
}
