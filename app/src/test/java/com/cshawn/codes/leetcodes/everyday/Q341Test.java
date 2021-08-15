package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;

/**
 * @author C.Shawn
 * @date 2021/3/23 8:07 下午
 */
class Q341Test {
    @Test
    void test1() {
        List<Q341.NestedInteger> list = new LinkedList<>();
        list.add(new Q341.NestedIntegerImpl(1));
        list.add(new Q341.NestedIntegerImpl(2));
        List<Q341.NestedInteger> inner = new LinkedList<>();
        List<Q341.NestedInteger> inner2 = new LinkedList<>();
        inner2.add(new Q341.NestedIntegerImpl(3));
        inner2.add(new Q341.NestedIntegerImpl(4));
        inner.add(new Q341.NestedIntegerImpl(inner2));
        inner.add(new Q341.NestedIntegerImpl(5));
        list.add(new Q341.NestedIntegerImpl(inner));
        list.add(new Q341.NestedIntegerImpl(6));
        Q341.NestedIterator1 test = new Q341.NestedIterator1(list);
        StringBuilder sb = new StringBuilder();
        while (test.hasNext()) {
            sb.append(test.next());
        }
        Assertions.assertEquals("123456", sb.toString());
    }

    @Test
    void test() {
        List<Q341.NestedInteger> list = new LinkedList<>();
        list.add(new Q341.NestedIntegerImpl(1));
        list.add(new Q341.NestedIntegerImpl(2));
        List<Q341.NestedInteger> inner = new LinkedList<>();
        List<Q341.NestedInteger> inner2 = new LinkedList<>();
        inner2.add(new Q341.NestedIntegerImpl(3));
        inner2.add(new Q341.NestedIntegerImpl(4));
        inner.add(new Q341.NestedIntegerImpl(inner2));
        inner.add(new Q341.NestedIntegerImpl(5));
        list.add(new Q341.NestedIntegerImpl(inner));
        list.add(new Q341.NestedIntegerImpl(6));
        Q341.NestedIterator test = new Q341.NestedIterator(list);
        StringBuilder sb = new StringBuilder();
        while (test.hasNext()) {
            sb.append(test.next());
        }
        Assertions.assertEquals("123456", sb.toString());
    }
}