package com.cshawn.codes.leetcodes.everyday;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/27 5:20 下午
 */
public class Q22 {
    // 回溯
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        char[] arr = new char[n << 1];
        backTracking(result, arr, n, 0, 0, 0);
        return result;
    }

    private void backTracking(List<String> result, char[] arr, int n, int index, int left, int right) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }
        if (left < n) {
            arr[index] = '(';
            backTracking(result, arr, n, index + 1, left + 1, right);
        }
        if (right < left) {
            arr[index] = ')';
            backTracking(result, arr, n, index + 1, left, right + 1);
        }
    }
}
