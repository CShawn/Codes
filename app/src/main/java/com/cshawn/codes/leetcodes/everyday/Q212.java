package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * 单词搜索 II
 * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例 1：
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/16 5:12 下午
 */
public class Q212 {
    // 字典树 + 回溯
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        // 不同路径可能构造出相同的字符串，需要去重
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, trie, i, j, res);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, Trie trie, int i, int j, Set<String> res) {
        // '#'不会出现在单词中，所以在此不用判断'#'
        if (!trie.children.containsKey(board[i][j])) {
            return;
        }
        char c = board[i][j];
        Trie child = trie.children.get(c);
        // 为空的说明不是一个完整的单词
        if (child.word != null) {
            res.add(child.word);
        }
        // 将字符替换为'#'代表已访问过，可以节约额外记录的空间
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, child, i - 1, j, res);
        }
        if (i < board.length - 1) {
            dfs(board, child, i + 1, j, res);
        }
        if (j > 0) {
            dfs(board, child, i, j - 1, res);
        }
        if (j < board[0].length - 1) {
            dfs(board, child, i, j + 1, res);
        }
        board[i][j] = c;
        // 加速：当前单词为叶子结点时，已加入结果集，因此可以从字典树中删除
        // 不断删除已计算的单词，后续的判断会逐步减少
        if (child.children.isEmpty()) {
            trie.children.remove(c);
        }
    }

    static class Trie {
        String word;
        Map<Character, Trie> children;
        public Trie() {
            children = new HashMap<>();
        }

        public void insert(String str) {
            Trie trie = this;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!trie.children.containsKey(c)) {
                    trie.children.put(c, new Trie());
                }
                trie = trie.children.get(c);
            }
            trie.word = str;
        }
    }
}
