package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/4/14 8:25 下午
 */
class Q208Test {
    @Test
    void test() {
        Q208.Trie trie = new Q208.Trie();
        trie.insert("apple");
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertFalse(trie.search("app"));
        Assertions.assertTrue(trie.startsWith("app"));
        trie.insert("app");
        Assertions.assertTrue(trie.search("app"));
    }
}