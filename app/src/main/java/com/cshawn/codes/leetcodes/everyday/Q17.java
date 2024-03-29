package com.cshawn.codes.leetcodes.everyday;

import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/21 4:55 下午
 */
public class Q17 {
    private char[][] map = new char[][]{
            new char[0],
            new char[0],
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'}
    };
    // 回溯
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        backTracking(digits.toCharArray(), 0, new char[digits.length()], list);
        return list;
    }

    private void backTracking(char[] digits, int index, char[] temp, List<String> list) {
        if (index == digits.length) {
            list.add(new String(temp));
            return;
        }
        int num = digits[index] - '0';
        for (int i = 0; i < map[num].length; i++) {
            temp[index] = map[num][i];
            backTracking(digits, index + 1, temp, list);
        }
    }
}
