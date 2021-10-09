package com.cshawn.codes.leetcodes.everyday;

import java.util.Map;
import java.util.TreeMap;

/**
 * 将数据流变为多个不相交区间
 * 给你一个由非负整数a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 * 实现 SummaryRanges 类：
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间[starti, endi] 的列表形式返回对数据流中整数的总结。
 *
 * 示例：
 * 输入：
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * 输出：
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 *
 * 解释：
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // 返回 [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 * 
 * 提示：
 * 0 <= val <= 104
 * 最多调用addNum 和 getIntervals 方法 3 * 104 次
 * 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/9 3:15 下午
 */
public class Q352 {
    static class SummaryRanges {
        // 有序集合，存储区间范围<start, end>
        TreeMap<Integer, Integer> map;
        public SummaryRanges() {
            map = new TreeMap<>();
        }

        public void addNum(int val) {
            Map.Entry<Integer, Integer> ceil = map.ceilingEntry(val + 1);
            Map.Entry<Integer, Integer> floor = map.floorEntry(val);
            if (floor != null && floor.getKey() <= val && val <= floor.getValue()) {
                return;
            }
            boolean left = floor != null && floor.getValue() + 1 == val;
            boolean right = ceil != null && ceil.getKey() - 1 == val;
            if (left && right) {
                map.put(floor.getKey(), ceil.getValue());
                map.remove(ceil.getKey());
            } else if (left) {
                map.put(floor.getKey(), val);
            } else if (right) {
                map.put(val, ceil.getValue());
                map.remove(ceil.getKey());
            } else {
                map.put(val, val);
            }
        }

        public int[][] getIntervals() {
            int[][] result = new int[map.size()][2];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                result[index][0] = entry.getKey();
                result[index++][1] = entry.getValue();
            }
            return result;
        }
    }
}
