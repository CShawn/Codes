package com.cshawn.codes.leetcodes.everyday;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现 MyHashMap 类：
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 * 示例：
 *
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *
 * 提示：
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/14 9:32 上午
 */
public class Q706 {
    class MyHashMap {
        class Pair {
            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }
            int key;
            int value;
        }
        private float loadFactor = 0.75f;
        private int used = 0;
        LinkedList<Pair>[] arr;
        /** Initialize your data structure here. */
        public MyHashMap() {
            arr = new LinkedList[1 << 4];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            // 扩容
            if ((float)used / arr.length >= loadFactor) {
                int oldLength = arr.length;
                LinkedList<Pair>[] newArr = new LinkedList[oldLength << 1];
                System.arraycopy(arr, 0, newArr, 0, oldLength);
                arr = newArr;
                // 扩容2倍，则length-1比之前多一位1，那么重新计算index要么与原来相同，要么前边多一位1
                // 多一位1时，表示当前索引-之前索引=原length
                for (int i = 0; i < oldLength; i++) {
                    if (newArr[i] != null) {
                        Iterator<Pair> it = newArr[i].iterator();
                        while (it.hasNext()) {
                            Pair pair = it.next();
                            int newIndex = getIndex(pair.key);
                            if (newIndex != i) {
                                if (arr[newIndex] == null) {
                                    arr[newIndex] = new LinkedList<>();
                                }
                                arr[newIndex].add(new Pair(pair.key, pair.value));
                                it.remove();
                            }
                        }
                    }
                }
            }
            // 添加
            int index = getIndex(key);
            if (arr[index] == null) {
                arr[index] = new LinkedList<>();
            }
            boolean contains = false;
            Iterator<Pair> list = arr[index].iterator();
            while (list.hasNext()) {
                Pair pair = list.next();
                if (pair.key == key) {
                    contains = true;
                    pair.value = value;
                    break;
                }
            }
            if (!contains) {
                arr[index].add(new Pair(key, value));
                used++;
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = getIndex(key);
            if (arr[index] == null) {
                return -1;
            }
            Iterator<Pair> list = arr[index].iterator();
            while (list.hasNext()) {
                Pair pair = list.next();
                if (pair.key == key) {
                    return pair.value;
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = getIndex(key);
            if (arr[index] == null) {
                return;
            }
            Iterator<Pair> list = arr[index].iterator();
            while (list.hasNext()) {
                Pair pair = list.next();
                if (pair.key == key) {
                    list.remove();
                    used--;
                    break;
                }
            }
        }

        private int getIndex(int key) {
            return key & (arr.length - 1);
        }
    }
}
