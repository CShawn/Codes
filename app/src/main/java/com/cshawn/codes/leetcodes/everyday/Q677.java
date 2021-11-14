package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert和sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * 示例：
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);  
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);    
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 * 提示：
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/14 10:52 上午
 */
public class Q677 {
    // 字典树
    static class MapSum {
        class Trie {
            int sum;
            Trie[] children = new Trie[26];
        }
        private Map<String, Integer> map;
        Trie root;
        public MapSum() {
            map = new HashMap<>();
            root = new Trie();
        }

        public void insert(String key, int val) {
            int diff = val - map.getOrDefault(key, 0);
            map.put(key, val);
            Trie trie = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (trie.children[index] == null) {
                    trie.children[index] = new Trie();
                }
                trie.children[index].sum += diff;
                trie = trie.children[index];
            }
        }

        public int sum(String prefix) {
            Trie trie = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (trie.children[index] == null) {
                    return 0;
                }
                trie = trie.children[index];
            }
            return trie.sum;
        }
    }
}
