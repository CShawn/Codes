package com.cshawn.leetcodes.crack;

import java.util.LinkedList;
import java.util.List;

/**
 * 无重复字符串的排列组合
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * 
 * 示例1:
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 
 * 示例2:
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 
 * 提示:
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/29 22:42 
 */
public class Q8_7 {
    
    // 方法1：递归
    public String[] permutation1(String S) {
        return recursive(S).toArray(new String[0]);
    }
    // 递归获取所有子串的全排列
    private List<String> recursive(String s) {
        List<String> result = new LinkedList<>();
        // 字符串长度小于等于1时，直接添加并返回
        if (s.length() <= 1) {
            result.add(s);
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            // 获取除当前字符外其他字符组成的字符串的全排列
            List<String> list = recursive(s.substring(0, i) + s.substring(i + 1, s.length()));
            for (String str : list) {
                // 将当前字符与其他字符组成的字符串的全排列相拼接，形成完整的全排列
                result.add(s.charAt(i) + str);
            }
        }
        return result;
    }
    
    // 方法2：回溯
    // 方法1中很明显存在大量的重复运算，需要去除
    public String[] permutation2(String s) {
        // 用于记录每个位置上的字符是否已使用
        boolean[] used = new boolean[s.length()];
        List<String> result = new LinkedList<>();
        backtrack(result, s, new char[s.length()], 0, used);
        return result.toArray(new String[0]);
    }

    /**
     * 回溯
     * @param result 結果
     * @param s 原字符串
     * @param pre 當前遍歷的子串的字符數組，用於代替StringBuilder
     * @param index 當前遍歷的子串的索引
     * @param used 记录每个位置上的字符是否已使用
     */
    private void backtrack(List<String> result, String s, char[] pre, int index, boolean[] used) {
        // 當一次遍歷結束時添加到結果中
        if (index == s.length()) {
            result.add(new String(pre));
        }
        for (int i = 0; i < used.length; i++) {
            // 找到第一個未使用過的字符才可以使用
            if (!used[i]) {
                // 向尾部添加字符
                pre[index] = s.charAt(i);
                // 標記當前字符被使用
                used[i] = true;
                // 繼續遍歷後續的字符
                backtrack(result, s, pre, index + 1, used);
                // 標記當前字符未使用，不用移除pre[index]，相當于回溯
                used[i] = false;
            }
        }
    }
    
    // 方法3：回溯，不使用额外记录
    public String[] permutation(String s) {
        if (s.length() == 0) {
            return new String[]{""};
        }
        char[] array = s.toCharArray();
        List<String> result = new LinkedList<>();
        dfs(result, array, 0);
        return result.toArray(new String[0]);
    }

    private void dfs(List<String> result, char[] array, int index) {
        if (index == array.length - 1) {
            result.add(new String(array));
            return;
        }
        for (int i = index; i < array.length; i++) {
            // 當前可選擇爲i~length之前的字符，將i與index交換，那麼選擇的相當于是緊跟着之前已選擇的字符，
            // 此時不會出現方法2中後邊的元素已被選擇的情況，所以不需要額外的記錄
            swap(array, i, index);
            dfs(result, array, index + 1);
            // 再次交換回來，即爲回溯
            swap(array, i, index);
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
