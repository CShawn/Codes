package com.cshawn.codes.leetcodes.interview;

import java.util.PriorityQueue;

/**
 * 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 *
 * 提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/3 8:41 上午
 */
public class Q17_14 {
    // 方法1：最小堆
    public int[] smallestK1(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    // 方法2：快速排序
    public int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        quickSort(arr, k, 0, arr.length - 1);
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    // 只排序最小的k个
    private void quickSort(int[] arr, int k, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int left = lo + 1, right = hi, t;
        while (left <= right) {
            while (left <= right && arr[left] < arr[lo]) {
                left++;
            }
            while (left <= right && arr[right] > arr[lo]) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
            left++;
            right--;
        }
        swap(arr, lo, right);
        if (right + 1 > k) {
            quickSort(arr, k, lo, right - 1);
        } else if (right + 1 < k) {
            quickSort(arr, k, right + 1, hi);
        }
    }

    private void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}