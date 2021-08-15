package com.cshawn.codes.leetcodes.crack;

import java.util.LinkedList;
import java.util.List;

/**
 * 有重复字符串的排列组合
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 *
 * 示例2:
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/30 8:42 下午
 */
public class Q8_8 {
    public String[] permutation(String S) {
        List<String> result = new LinkedList<>();
        dfs(S.toCharArray(), result, 0);
        return result.toArray(new String[0]);
    }

    private void dfs(char[] s, List<String> result, int index) {
        if (index == s.length - 1) {
            result.add(new String(s));
            return;
        }
        // 用一个64位数表示s（大小写英文字母）中字符是否出现过
        long repeats = 0;
        for (int i = index; i < s.length; i++) {
            // 当前字符未出现过
            if (((repeats >> (s[i] - 'a')) & 1) == 0) {
                swap(s, i, index);
                dfs(s, result, index + 1);
                swap(s, i, index);
            }
            repeats |= (1L << (s[i] - 'a'));
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
