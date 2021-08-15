package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 替换字符串中的括号内容 显示英文描述
 * 通过的用户数25
 * 尝试过的用户数26
 * 用户总通过次数25
 * 用户总提交次数27
 * 题目难度Medium
 * 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
 *
 * 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
 * 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
 *
 * 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
 *
 * 将 keyi 和括号用对应的值 valuei 替换。
 * 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
 * knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
 *
 * 请你返回替换 所有 括号对后的结果字符串。
 * @author C.Shawn
 * @date 2021/3/28 10:42 上午
 */
public class Q5714 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                start = i;
            } else if (c == ')') {
                sb.append(map.getOrDefault(s.substring(start + 1, i), "?"));
                start = -1;
            } else if (start == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
