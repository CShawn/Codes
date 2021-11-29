package com.cshawn.codes.leetcodes.everyday;

import java.util.PriorityQueue;

/**
 * 第 K 个最小的素数分数
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 *  
 * 示例 1：
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示: 
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 *
 * 示例 2：
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 *
 * 提示：
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/29 8:31 上午
 */
public class Q786 {
    // 方法1：最小堆
    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        int[] min = new int[]{0, arr.length - 1};
        PriorityQueue<int[]> left = new PriorityQueue<>((o1, o2) -> arr[o1[0]] * arr[o2[1]] - arr[o2[0]] * arr[o1[1]]);
        for (int i = 1; i < k; i++) {
            if (min[1] - min[0] != 1) {
                left.offer(new int[]{min[0] + 1, min[1]});
                left.offer(new int[]{min[0], min[1] - 1});
            }
            min = left.poll();
            System.out.println(arr[min[0]] + "/" + arr[min[1]]);
            while (!left.isEmpty() && left.peek()[0] == min[0] && left.peek()[1] == min[1]) {
                left.poll();
            }
        }
        return new int[]{arr[min[0]], arr[min[1]]};
    }

    // 方法2：二分法
    // 猜测恰有k个分数小于当前值x，x在（0,1）中
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0, right = 1, mid;
        while (true) {
            mid = (left + right) / 2;
            int count = 0, i = -1, x = 0, y = 1;
            for (int j = 1; j < arr.length; j++) {
                while (arr[i + 1] / (double)arr[j] < mid) {
                    i++;
                    if (arr[i] * y > arr[j] * x) {
                        x = arr[i];
                        y = arr[j];
                    }
                }
                count += i + 1;
            }
            if (count == k) {
                return new int[]{x, y};
            }
            if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }
}
