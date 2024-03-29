package com.cshawn.codes.leetcodes.sword;

import java.util.PriorityQueue;

/**
 * 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/8 8:56 下午
 */
public class Sword_40 {
    /**
     * 方法1：排序，取前k个
     * 方法2：堆。构建k个元素的最大堆，将比当前最大元素小的元素插入堆中，最终结果就是目标数据。
     * 也可以使用最小堆，但需要每个比它大的元素都插入一遍，速度较慢
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        int[] result = new int[k];
        if (k == 0 || arr.length == 0) {
            return result;
        }
        // Java中的PriorityQueue为优先级队列，默认数字越小越靠前即最小堆，需要自定义排序反过来
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i : arr) {
            if (heap.size() < k) {
                // 不足k个直接加入堆
                heap.offer(i);
            } else if (i < heap.peek()) {
                // 比最大值小则将堆顶元素移除，将新数据放入堆
                heap.poll();
                heap.offer(i);
            }
        }
        // 遍历堆并构建结果数组
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    /**
     * 方法3：快排思想，找到中间数字的位置
     * 1. 如果恰好为k+1，那么之前的数字就是结果
     * 2. 如果大于k，则在左侧继续快排
     * 3. 如果小于k，则在右侧继续快排
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        int[] result = new int[k];
        if (k == 0 || arr.length == 0) {
            return result;
        }
        sortToResult(arr, k, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void sortToResult(int[] arr, int k, int left, int right) {
        int pos = quickSort(arr, left, right);
        int num = pos - left + 1;
        if (num == k) {
            return;
        } else if (k < num) {
            sortToResult(arr, k, left, pos - 1);
        } else {
            sortToResult(arr, k - num, pos + 1, right);
        }
    }

    private int quickSort(int[] arr, int left, int right) {
        // 选择第一个元素作为中间数字
        int first = left;
        int flag = arr[first];
        int lo = left;
        int hi = right + 1;
        while (true) {
            while (arr[++lo] < flag) {
                if (lo == right) {
                    break;
                }
            }
            while (arr[--hi] > flag) {
                if (hi == left) {
                    break;
                }
            }
            if (lo >= hi) {
                break;
            }
            // 将lo和hi交换
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
        }
        // 最后将lo和middle交换
        int temp = arr[hi];
        arr[hi] = arr[first];
        arr[first] = temp;
        return hi;
    }
}
