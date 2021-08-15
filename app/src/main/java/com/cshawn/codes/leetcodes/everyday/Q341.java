package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * 示例 1:
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用},next 直到},hasNext 返回 false，next},返回的元素的顺序应该是: [1,1,2,1,1]。
 *
 * 示例 2:
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用},next},直到},hasNext 返回 false，next},返回的元素的顺序应该是: [1,4,6]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/23 8:06 下午
 */
public class Q341 {
    public static class NestedIterator1 implements Iterator<Integer> {
        private List<Integer> list = new LinkedList<>();
        private Iterator<Integer> it;
        public NestedIterator1(List<NestedInteger> nestedList) {
            dfs(nestedList);
            it = list.iterator();
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger nested : nestedList) {
                if (nested.isInteger()) {
                    list.add(nested.getInteger());
                } else {
                    dfs(nested.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }
    }

    public static class NestedIterator implements Iterator<Integer> {
        private List<NestedInteger> list;
        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return list.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            // 是集合时，不断深度遍历
            while (!list.isEmpty() && !list.get(0).isInteger()) {
                // 移出首元素继续
                List<NestedInteger> inner = list.remove(0).getList();
                // 将集合中的元素按原来的顺序放入list
                for (int i = inner.size() - 1; i >= 0; i--) {
                    list.add(0, inner.get(i));
                }
            }
            return !list.isEmpty();
        }
    }

    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    static class NestedIntegerImpl implements NestedInteger {
        private Integer value;
        private List<NestedInteger> values;
        public NestedIntegerImpl(int value) {
            this.value = value;
        }
        public NestedIntegerImpl(List<NestedInteger> list) {
            this.values = list;
        }
        @Override
        public boolean isInteger() {
            return value != null;
        }

        @Override
        public Integer getInteger() {
            return value;
        }

        @Override
        public List<NestedInteger> getList() {
            return values;
        }
    }
}
