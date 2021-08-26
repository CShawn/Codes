package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 救生艇
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 * 示例 1：
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 *
 * 示例 2：
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 *
 * 示例 3：
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 *
 * 提示：
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/26 8:40 上午
 */
public class Q881 {
    // 方法1：排序+双指针
    public int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, result = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                // 体重最小和最大的合坐一条船
                left++;
                right--;
            } else {
                // 体重大的坐一条船
                right--;
            }
            result++;
        }
        return result;
    }

    // 方法2：快速排序+双指针
    public int numRescueBoats2(int[] people, int limit) {
        quickSort(people, 0, people.length - 1);
        int left = 0, right = people.length - 1, result = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            result++;
        }
        return result;
    }

    // 方法2：3向切分快速排序+双指针
    public int numRescueBoats22(int[] people, int limit) {
        quickSort3Way(people, 0, people.length - 1);
        int left = 0, right = people.length - 1, result = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            result++;
        }
        return result;
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int left = lo + 1, right = hi;
        while (left <= right) {
            while (left < hi && arr[left] < arr[lo]) {
                left++;
            }
            while (right > lo && arr[right] > arr[lo]) {
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
        quickSort(arr, lo, right - 1);
        quickSort(arr, right + 1, hi);
    }

    // 快速排序-3向切分
    private void quickSort3Way(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int left = lo, right = hi, mid = lo + 1, base = arr[lo];
        while (mid <= right) {
            if (arr[mid] < base) {
                swap(arr, left++, mid++);
            } else if (arr[mid] > base) {
                swap(arr, mid, right--);
            } else {
                mid++;
            }
        }
        quickSort3Way(arr, lo, left - 1);
        quickSort3Way(arr, right + 1, hi);
    }

    private void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    // 方法3：桶排序+双指针,可能会超时
    public int numRescueBoats(int[] people, int limit) {
        int[] bucket = new int[limit + 1];
        for (int weight : people) {
            bucket[weight]++;
        }
        int left = 0, right = bucket.length - 1, result = 0;
        while (left <= right) {
            while (left <= right && bucket[left] <= 0) {
                left++;
            }
            while (left <= right && bucket[right] <= 0) {
                right--;
            }
            if (bucket[left] <= 0 && bucket[right] <= 0) {
                break;
            }
            if (left + right <= limit) {
                bucket[left]--;
            }
            bucket[right]--;
            result++;
        }
        return result;
    }
}
