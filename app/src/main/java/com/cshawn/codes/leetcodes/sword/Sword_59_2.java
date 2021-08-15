package com.cshawn.codes.leetcodes.sword;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * 限制：
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/25 9:50 下午
 */
public class Sword_59_2 {
    static class MaxQueue {
        private Queue<Integer> queue;
        private Deque<Integer> max;
        public MaxQueue() {
            queue = new LinkedList<>();
            max = new LinkedList<>();
        }

        public int max_value() {
            return max.peekFirst() != null ? max.peekFirst() : -1;
        }

        public void push_back(int value) {
            queue.add(value);
            // 当前元素比当前最大值大时，将双向队列清除
            if (!max.isEmpty() && value > max.peekFirst()) {
                max.clear();
            }
            // 当前元素比当前最小值大时，无断删除比它小的元素
            while (!max.isEmpty() && max.peekLast() < value) {
                max.pollLast();
            }
            // 最后加入当前元素
            max.add(value);
        }

        public int pop_front() {
            Integer num = queue.poll();
            if (num != null && num.equals(max.peekFirst())) {
                max.pollFirst();
            }
            return num != null ? num : -1;
        }
    }
}
