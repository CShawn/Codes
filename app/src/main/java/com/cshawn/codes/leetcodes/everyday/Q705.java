package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *  
 * 示例：
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 *
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 *  
 * 提示：
 * 0 <= key <= 106
 * 最多调用 104 次 add、remove 和 contains 。
 * 进阶：你可以不使用内建的哈希集合库解决此问题吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/13 10:12 上午
 */
public class Q705 {
    class MyHashSet {
        private float loadFactor = 0.75f;
        private int used = 0;
        LinkedList<Integer>[] arr;
        /** Initialize your data structure here. */
        public MyHashSet() {
            arr = new LinkedList[1 << 4];
        }

        public void add(int key) {
            int index = getIndex(key);
            if (arr[index] == null) {
                arr[index] = new LinkedList<>();
            }
            if (!arr[index].contains(key)) {
                arr[index].add(key);
            }
            used++;
            // 扩容
            if ((float)used / arr.length >= loadFactor) {
                int oldLength = arr.length;
                LinkedList<Integer>[] newArr = new LinkedList[oldLength << 1];
                System.arraycopy(arr, 0, newArr, 0, oldLength);
                arr = newArr;
                // 扩容2倍，则length-1比之前多一位1，那么重新计算index要么与原来相同，要么前边多一位1
                // 多一位1时，表示当前索引-之前索引=原length
                for (int i = 0; i < oldLength; i++) {
                    if (newArr[i] != null) {
                        Iterator<Integer> it = newArr[i].iterator();
                        while (it.hasNext()) {
                            int value = it.next();
                            int newIndex = getIndex(value);
                            if (newIndex != i) {
                                if (arr[newIndex] == null) {
                                    arr[newIndex] = new LinkedList<>();
                                }
                                arr[newIndex].add(value);
                                it.remove();
                            }
                        }
                    }
                }
            }
        }

        public void remove(int key) {
            int index = getIndex(key);
            if (arr[index] != null) {
                arr[index].remove(Integer.valueOf(key));
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int index = getIndex(key);
            return arr[index] != null && arr[index].contains(key);
        }

        private int getIndex(int key) {
            return key & (arr.length - 1);
        }
    }
}
