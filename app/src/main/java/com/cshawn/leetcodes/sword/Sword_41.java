package com.cshawn.leetcodes.sword;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 * [2,3,4]的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 *
 * 示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * 限制：最多会对addNum、findMedian 进行50000次调用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/10 9:07 下午
 */
public class Sword_41 {
    /**
     * 定义两个堆分别存储数据的前后两部分，前半部分使用最大堆，后半部分使用最小堆；
     * 在存储数据时保持两个堆数据量的平衡，最后直接取两个堆顶数据即可。
     */
    static class MedianFinder {
        // 前半部分使用最大堆
        private PriorityQueue<Integer> maxHeap;
        // 后半部分使用最小堆
        private PriorityQueue<Integer> minHeap;
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            //*
            if ((!minHeap.isEmpty() && num < minHeap.peek()) || (!maxHeap.isEmpty() && num < maxHeap.peek())) {
                // 当前数值比后半部分小时，放入前半部分
                maxHeap.offer(num);
            } else {
                // 否则放入前半部分
                minHeap.offer(num);
            }
            // 当两半部分个数差距大于1时，从较多的部分向较少部分转移一个元素，进行一次平衡
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() - minHeap.size() < -1) {
                maxHeap.offer(minHeap.poll());
            }
            //*/
            // 上述判断较为繁琐，可以简写为以下代码，但执行速度略有下降：
//            if (maxHeap.size() == minHeap.size()) {
//                // 两部分个数相同时，先向前半部分添加元素，再向后半部分平衡一次
//                maxHeap.add(num);
//                minHeap.add(maxHeap.poll());
//            } else {
//                minHeap.add(num);
//                maxHeap.add(minHeap.poll());
//            }
            // 最终两部分个数相同或后半部分的个数多1个
        }

        public double findMedian() {
            // 两部分都为空时返回0
            if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                return 0;
            }
            //*
            // 两部分不一样多时，返回较多部分的堆顶元素
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            if (maxHeap.size() < minHeap.size()) {
                return minHeap.peek();
            }
            // 两部分一样多时，返回平均值
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
            //*/
            // 简写为：
//            return maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 : minHeap.peek();
        }
    }
}
