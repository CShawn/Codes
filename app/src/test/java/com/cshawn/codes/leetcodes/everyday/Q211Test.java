package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/10/19 10:30 上午
 */
class Q211Test {
    @Test
    void test() {
        Q211.WordDictionary test = new Q211.WordDictionary();
        test.addWord("a");
        test.addWord("ab");
        test.addWord("bad");
        test.addWord("dad");
        test.addWord("mad");
        test.addWord("maddy");
        assertTrue(test.search("a"));
        assertTrue(test.search("."));
        assertFalse(test.search("pad"));
        assertTrue(test.search("bad"));
        assertTrue(test.search(".ad"));
        assertTrue(test.search("b.."));
        assertTrue(test.search("b.d"));
        assertFalse(test.search("b.dd"));
        assertFalse(test.search("ba"));
        assertFalse(test.search("ad"));
        assertTrue(test.search(".."));
        assertTrue(test.search("..."));
        assertFalse(test.search("...."));
    }
}