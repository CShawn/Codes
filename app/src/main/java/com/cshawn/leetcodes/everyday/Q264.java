package com.cshawn.leetcodes.everyday;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author C.Shawn
 * @date 2021/4/11 10:00 上午
 */
public class Q264 {
    // 方法1: 最小堆
    // 一个丑数乘以2,3,5也是丑数，因此分别计算每个丑数的2,3,5倍数，使用最小堆存储，第n个丑数即可得出
    // 注意需要去重，另外数字过多可能越界，需要使用long
    public int nthUglyNumber1(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        for (int i = 1; i < n; i++) {
            long top = heap.poll();
            long ugly = 2 * top;
            if (set.add(ugly)) {
                heap.offer(ugly);
            }
            ugly = 3 * top;
            if (set.add(ugly)) {
                heap.offer(ugly);
            }
            ugly = 5 * top;
            if (set.add(ugly)) {
                heap.offer(ugly);
            }
        }
        return heap.poll().intValue();
    }

    // 方法2：动态规划
    // 设丑数=min(第x个数*2, 第y个数*3, 第z个数*5)，对应的xyz需要计算之前的所有数字，
    // 分别使用3个变量存储当前使用的哪一个数字乘以2,3,5,
    // 那么下一个丑数需要将当前丑数所取的x,y,z中的那个值加1再次求min
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int n2 = 0, n3 = 0, n5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(2 * ugly[n2], Math.min(3 * ugly[n3], 5 * ugly[n5]));
            if (ugly[i] == 2 * ugly[n2]) {
                n2++;
            }
            if (ugly[i] == 3 * ugly[n3]) {
                n3++;
            }
            if (ugly[i] == 5 * ugly[n5]) {
                n5++;
            }
        }
        return ugly[n - 1];
    }
}
