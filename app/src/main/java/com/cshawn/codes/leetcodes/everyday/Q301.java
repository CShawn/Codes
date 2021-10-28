package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * 删除无效的括号
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 *
 * 示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 *
 * 示例 3：
 * 输入：s = ")("
 * 输出：[""]
 *
 * 提示：
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/27 4:56 下午
 */
public class Q301 {
    // 回溯
    public List<String> removeInvalidParentheses1(String s) {
        List<String> result = new LinkedList<>();
        // 统计需要删除的最小的左右括号数
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        // 回溯删除left个左括号和right个右括号，检测每种情况下字符串是否符合条件
        backTracking(result, s, 0, left, right, 0, 0);
        return result;
    }

    private void backTracking(List<String> result, String s, int index, int left, int right, int usedLeft, int usedRight) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // 当前字符与之前的字符相同，不重复检测
            char c = s.charAt(i);
            if (i != index && c == s.charAt(i - 1)) {
                // 不删除当前字符时，统计当前留下的左右括号
                if (c == '(') {
                    usedLeft++;
                } else if (c == ')') {
                    usedRight++;
                }
                continue;
            }
            // 剩余字符长度不够删除的总数，不再检测
            if (left + right > s.length() - i) {
                return;
            }
            // 删除一个左括号
            if (left > 0 && c == '(') {
                // 删除一个字符后，新的字符串长度少了1，开始位置也少了1，所以index不用加1
                backTracking(result, s.substring(0, i) + s.substring(i + 1), i, left - 1, right, usedLeft, usedRight);
            }
            // 删除一个右括号
            if (right > 0 && c == ')') {
                backTracking(result, s.substring(0, i) + s.substring(i + 1), i, left, right - 1, usedLeft, usedRight);
            }
            // 不删除当前字符时，统计当前留下的左右括号
            if (c == '(') {
                usedLeft++;
            } else if (c == ')') {
                usedRight++;
            }
            // 当留下的当前字符串中右括号比左括号多，则当前字符串已经不合法，没必要继续检测
            if (usedRight > usedLeft) {
                break;
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count-- <= 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    // 广度优先遍历
    // 每次删除一个字符，判断是否有符合条件的
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        // 统计需要删除的最小的左右括号数
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        Set<String> queue = new HashSet<>();
        queue.add(s);
        while (left > 0 || right > 0) {
            boolean l = false;
            Set<String> cur = new HashSet<>();
            for (String str : queue) {
                for (int j = 0; j < str.length(); j++) {
                    if (left > 0) {
                        if (str.charAt(j) == '(' && (j == 0 ||  str.charAt(j - 1) != '(')) {
                            l = true;
                            cur.add(str.substring(0, j) + str.substring(j + 1));
                        }
                    } else if (str.charAt(j) == ')' && (j == 0 || str.charAt(j - 1) != ')')) {
                        cur.add(str.substring(0, j) + str.substring(j + 1));
                    }
                }
            }
            if (l) {
                left--;
            } else {
                right--;
            }
            queue = cur;
        }
        for (String str : queue) {
            if (isValid(str)) {
                result.add(str);
            }
        }
        return new LinkedList<>(result);
    }
}
