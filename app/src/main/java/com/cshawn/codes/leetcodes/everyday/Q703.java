package com.cshawn.codes.leetcodes.everyday;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 
 * 请实现 KthLargest 类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * 
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * 
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *  

 * 提示：
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q703 {
    // 因为不需要实现remove方法，只有add，
    // 那么添加较小的数据时，无需任何操作；
    // 添加较大数据时，移除最大值即可，只用保存K个较大元素
    // 使用优先级队列，队首为最小值，即第K大的元素
    static class KthLargest {
        PriorityQueue<Integer> queue;
        int k = 0;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            // 初始化优先级队列
            queue = new PriorityQueue<>(k, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            // 先填充K个或不足K个元素
            for (int i = 0; i < Math.min(nums.length, k); i++) {
                queue.offer(nums[i]);
            }
            // 如果多于K个，则添加元素后再删除最小值，保证只有K个
            for (int i = k; i < nums.length; i++) {
                queue.offer(nums[i]);
                queue.poll();
            }
        }
        
        public int add(int val) {
            // 比当前第K大的元素大于或等于时或者当前不足K个时，才添加到优先级队列
            if (queue.size() < k || val > queue.peek()) {
                queue.offer(val);
            }
            // 多于K个则删除最小值
            if (queue.size() > k) {
                queue.poll();
            }
            // 不足K个返回-1，队首为第K大的元素
            return queue.size() < k ? -1 : queue.peek();
        }
    }
}