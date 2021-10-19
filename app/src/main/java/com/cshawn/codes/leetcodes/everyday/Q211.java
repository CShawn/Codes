package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。
 *
 * 示例：
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * 
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/19 9:22 上午
 */
public class Q211 {
    // 字典树
    static class WordDictionary {
        private final Trie node;
        public WordDictionary() {
            node = new Trie();
        }

        public void addWord(String word) {
            node.insert(word);
        }

        public boolean search(String word) {
//            return bfs(word);
            return dfs(word, 0, node);
        }

        private boolean dfs(String word, int index, Trie node) {
            if (index == word.length()) {
                return node.isEnd;
            }
            int c = word.charAt(index) - 'a';
            if (c < 0) {
                for (Trie child : node.children) {
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }
            } else {
                return node.children[c] != null && dfs(word, index + 1, node.children[c]);
            }
            return false;
        }

        private boolean bfs(String word) {
            List<Trie> cur = new ArrayList<>();
            cur.add(node);
            List<Trie> temp = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                temp.clear();
                for (Trie trie : cur) {
                    if (c < 0 || trie.children[c] != null) {
                        if (c < 0) {
                            for (Trie child : trie.children) {
                                if (child != null) {
                                    temp.add(child);
                                }
                            }
                        } else {
                            temp.add(trie.children[c]);
                        }
                    }
                }
                if (temp.isEmpty()) {
                    return false;
                }
                cur.clear();
                cur.addAll(temp);
            }
            for (Trie trie : cur) {
                if (trie.isEnd) {
                    return true;
                }
            }
            return false;
        }

        static class Trie {
            Trie[] children = new Trie[26];
            boolean isEnd;

            public void insert(String word) {
                Trie cur = this;
                for (int i = 0; i < word.length(); i++) {
                    int c = word.charAt(i) - 'a';
                    if (cur.children[c] == null) {
                        cur.children[c] = new Trie();
                    }
                    cur = cur.children[c];
                }
                cur.isEnd = true;
            }
        }
    }
}
