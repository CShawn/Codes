package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/7/10 9:56 上午
 */
class Q981Test {
    @Test
    void test() {
        Q981.TimeMap kv = new Q981.TimeMap();
        kv.set("foo", "bar", 1);
        Assertions.assertEquals("bar", kv.get("foo", 1));
        Assertions.assertEquals("bar", kv.get("foo", 3));
        kv.set("foo", "bar2", 4);
        Assertions.assertEquals("bar", kv.get("foo", 3));
        Assertions.assertEquals("bar2", kv.get("foo", 4));
        Assertions.assertEquals("bar2", kv.get("foo", 5));
        kv.set("foo", "bar3", 6);
        Assertions.assertEquals("bar3", kv.get("foo", 7));
        kv.set("foo", "bar4", 7);
        Assertions.assertEquals("bar4", kv.get("foo", 7));
        kv.set("foo", "bar5", 9);
        kv.set("foo", "bar6", 10);
        Assertions.assertEquals("bar4", kv.get("foo", 7));
        Assertions.assertEquals("bar4", kv.get("foo", 8));
        Assertions.assertEquals("bar5", kv.get("foo", 9));
        Assertions.assertEquals("bar6", kv.get("foo", 10));
    }
}