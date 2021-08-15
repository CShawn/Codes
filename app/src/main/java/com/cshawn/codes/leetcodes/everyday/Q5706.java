package com.cshawn.codes.leetcodes.everyday;

/**
 * 句子相似性 III
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 * 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
 * 示例 1：
 * 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
 * 输出：true
 * 解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
 *
 * 示例 2：
 * 输入：sentence1 = "of", sentence2 = "A lot of words"
 * 输出：false
 * 解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
 *
 * 示例 3：
 * 输入：sentence1 = "Eating right now", sentence2 = "Eating"
 * 输出：true
 * 解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
 *
 * 示例 4：
 * 输入：sentence1 = "Luky", sentence2 = "Lucccky"
 * 输出：false
 * 提示：
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1 和 sentence2 都只包含大小写英文字母和空格。
 * sentence1 和 sentence2 中的单词都只由单个空格隔开。
 * @author C.Shawn
 * @date 2021/4/3 10:26 下午
 */
public class Q5706 {
    public boolean areSentencesSimilar1(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        if (words1.length == words2.length) {
            return false;
        }
        int min = Math.min(words1.length, words2.length);
        int diff = Math.max(words1.length, words2.length) - min;
        String[] shorter = words1.length == min ? words1 : words2;
        String[] longer = words1.length == min ? words2 : words1;
        if (words1[0].equals(words2[0])) {
            int mid = -1;
            for (int i = 1; i < min; i++) {
                if (!words1[i].equals(words2[i])) {
                    mid = i;
                    break;
                }
            }
            if (mid != -1) {
                for (int i = min - 1; i >= mid; i--) {
                    if (!shorter[i].equals(longer[i + diff])) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (words1[words1.length - 1].equals(words2[words2.length - 1])) {
            for (int i = 0; i < min - 1; i++) {
                if (!shorter[i].equals(longer[i + diff])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // 方法2：从前匹配，再从后匹配，若符合条件则从前匹配的结束位置必然大于从后匹配的位置，即不是在中间添加
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        if (words1.length == words2.length) {
            return false;
        }
        int min = Math.min(words1.length, words2.length);
        int diff = Math.max(words1.length, words2.length) - min;
        String[] shorter = words1.length == min ? words1 : words2;
        String[] longer = words1.length == min ? words2 : words1;
        int i = 0, j = shorter.length - 1;
        while (i < shorter.length && shorter[i].equals(longer[i])) {
            i++;
        }
        while (j >= 0 && shorter[j].equals(longer[j + diff])) {
            j--;
        }
        return i > j;
    }
}
