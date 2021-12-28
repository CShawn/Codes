package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 连接词
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 *
 * 示例 1：
 * 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成;
 *      "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成;
 *      "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 *
 * 示例 2：
 * 输入：words = ["cat","dog","catdog"]
 * 输出：["catdog"]
 *
 * 提示：
 * 1 <= words.length <= 104
 * 0 <= words[i].length <= 1000
 * words[i] 仅由小写字母组成
 * 0 <= sum(words[i].length) <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/concatenated-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/28 1:40 下午
 */
public class Q472 {
    // 排序 + 字典树 + DFS
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Trie root = new Trie();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (find(root, word, 0)) {
                result.add(word);
            } else {
                insert(root, word);
            }
        }
        return result;
    }

    // DFS
    // 注意trie.isEnd时，可作为一个单词从头开始，也可以当作单词未结束，继续查找
    private boolean find(Trie root, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        Trie trie = root;
        for (int i = index; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (trie.children[c] == null) {
                return false;
            }
            trie = trie.children[c];
            if (trie.isEnd) {
                if (find(root, word, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void insert(Trie root, String word) {
        Trie trie = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (trie.children[c] == null) {
                trie.children[c] = new Trie();
            }
            trie = trie.children[c];
        }
        trie.isEnd = true;
    }

    static class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd;
    }
}
