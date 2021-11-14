package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/11/14 3:14 下午
 */
class Q677Test {
    @Test
    void test() {
        Q677.MapSum mapSum = new Q677.MapSum();
        mapSum.insert("apple", 3);
        assertEquals(3, mapSum.sum("ap"));
        mapSum.insert("app", 2);
        assertEquals(5, mapSum.sum("ap"));
        mapSum.insert("adb", 3);
        mapSum.insert("ap", 3);
        assertEquals(8, mapSum.sum("ap"));
        assertEquals(11, mapSum.sum("a"));
        mapSum.insert("apple", 1);
        assertEquals(6, mapSum.sum("ap"));
    }
}