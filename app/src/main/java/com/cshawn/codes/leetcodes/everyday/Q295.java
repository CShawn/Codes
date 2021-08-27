package com.cshawn.codes.leetcodes.everyday;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4]的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/27 8:30 上午
 */
public class Q295 {
    // 最小堆+最大堆
    static class MedianFinder1 {
        private final PriorityQueue<Integer> max;
        private final PriorityQueue<Integer> min;
        /** initialize your data structure here. */
        public MedianFinder1() {
            max = new PriorityQueue<>((o1, o2) -> o2 - o1);
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (max.size() > min.size()) {
                if (num < max.peek()) {
                    min.offer(max.poll());
                    max.offer(num);
                } else {
                    min.offer(num);
                }
            } else if (max.size() < min.size()) {
                if (num >= min.peek()) {
                    max.offer(min.poll());
                    min.offer(num);
                } else {
                    max.offer(num);
                }
            } else {
                if (max.size() == 0 || num < max.peek()) {
                    max.offer(num);
                } else {
                    min.offer(num);
                }
            }
        }

        public double findMedian() {
            if (max.size() > min.size()) {
                return max.peek();
            } else if (max.size() < min.size()) {
                return min.peek();
            } else {
                return max.size() == 0 ? 0 : (max.peek() + min.peek()) / 2.0;
            }
        }
    }

    // 优化方法
    static class MedianFinder {
        private final PriorityQueue<Integer> max;
        private final PriorityQueue<Integer> min;
        /** initialize your data structure here. */
        public MedianFinder() {
            max = new PriorityQueue<>((o1, o2) -> o2 - o1);
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            max.offer(num);
            min.offer(max.poll());
            if (max.size() < min.size()) {
                max.offer(min.poll());
            }
        }

        public double findMedian() {
            return max.size() > min.size() ? max.peek() : (max.peek() + min.peek()) / 2.0;
        }
    }
}
