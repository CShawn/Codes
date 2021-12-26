package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * Bigram 分词
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 * 示例 1：
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 *
 * 示例 2：
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 *
 * 提示：
 * 1 <= text.length <= 1000
 * text 由小写英文字母和空格组成
 * text 中的所有单词之间都由 单个空格字符 分隔
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/occurrences-after-bigram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/26 1:02 下午
 */
public class Q1078 {
    public String[] findOcurrences1(String text, String first, String second) {
        int i = 0;
        List<String> list = new ArrayList<>();
        while (i < text.length()) {
            int f = 0;
            boolean match = true;
            while (f < first.length() && i < text.length()) {
                if (first.charAt(f) != text.charAt(i)) {
                    match = false;
                    break;
                }
                f++;
                i++;
            }
            if (match && i < text.length() && text.charAt(i) == ' ') {
                int j = ++i;
                int s = 0;
                while (s < second.length() && j < text.length()) {
                    if (second.charAt(s) != text.charAt(j)) {
                        match = false;
                        break;
                    }
                    s++;
                    j++;
                }
                if (match) {
                    int end = ++j;
                    while (end < text.length() && text.charAt(end) != ' ') {
                        end++;
                    }
                    if (end != j) {
                        list.add(text.substring(j, end));
                    }
                }
            } else {
                while (i < text.length() && text.charAt(i) != ' ') {
                    i++;
                }
                i++;
            }
        }
        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 2].equals(first) && arr[i - 1].equals(second)) {
                list.add(arr[i]);
            }
        }
        String[] result = new String[list.size()];
        return list.toArray(result);
    }
}