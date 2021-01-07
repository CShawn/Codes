package com.cshawn.leetcodes.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 限制：1 <= s 的长度 <= 8
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/6 22:19
 */
public class Sword_38 {
    public String[] permutation(String s) {
        String[] result = new String[0];
        if (s == null || s.length() == 0) {
            return result;
        }
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        // 记录当前位置的元素是否已拼接
        boolean[] used = new boolean[s.length()];
        // 结果的集合
        List<String> list = new ArrayList<>();
        // 将数据看作一棵二叉树，开头为1时树为：[1, 12, 13, 123, 132]
        // 按照深度优先遍历
        dfs(array, sb, used, 0, list);
        return list.toArray(result);
    }

    /**
     * 深度优先遍历
     * @param array 原始字符串对应的字符数组
     * @param sb 已拼接的字符
     * @param used 记录当前位置的元素是否已拼接的数组
     * @param deep 当前遍历树的层级
     * @param list 存储结果的集合
     */
    private void dfs(char[] array, StringBuilder sb, boolean[] used, int deep, List<String> list) {
        // 到达最后一层时结束
        if (deep == used.length) {
            // 遍历完一条路径，添加到结果集合中
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            // 遍历未使用过的元素
            if (!used[i]) {
                // 拼接当前元素
                sb.append(array[i]);
                // 设置当前位置的元素为已使用状态
                used[i] = true;
                // 深度遍历下一层
                dfs(array, sb, used, deep + 1, list);
                // 回溯，删除最后一个拼接的元素
                sb.deleteCharAt(sb.length() - 1);
                // 并将当前位置的元素设置为未使用
                used[i] = false;
            }
        }
    }
}
