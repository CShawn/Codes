package com.cshawn.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 *
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *
 * 提示：
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/17 10:27 上午
 */
public class Q220 {
    // 方法1：滑动窗口两两比较，超时！！
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (k <= 0) {
            return false;
        }
        // 以0为中心，先遍历[0,k]中的两两元素之差是否满足要求
        for (int i = 0; i < k && i < nums.length; i++) {
            for (int j = i + 1; j <= k && j < nums.length; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                    return true;
                }
            }
        }
        // 再以[1,length-k)分别为中心，只用对比每个元素与最后一个元素之差即可
        int end = nums.length - k;
        for (int center = 1; center < end; center++) {
            int last = center + k;
            for (int i = center; i < last; i++) {
                if (Math.abs((long) nums[i] - (long) nums[last]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    // 方法2：滑动窗口+有序集合
    // 方法1的时间复杂度为n^k，在遍历过程中，其实不必要比较所有两两元素，如果滑动窗口内的元素是有序的，
    // 那么，可以二分查找在窗口内是否存在满足条件的元素，时间复杂度为nlog(min(n,k))，可以使用TreeSet实现
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k <= 0) {
            return false;
        }
        // 存储有序元素的滑动窗口
        TreeSet<Long> window = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 检查窗口中是否有元素位于[x-t, x+t]范围内
            Long ceil = window.ceiling((long) nums[i] - t);
            if (ceil != null && ceil <= (long) nums[i] + t) {
                return true;
            }
            window.add((long) nums[i]);
            // 超出窗口大小k，则移除最早放入窗口的元素
            if (i >= k) {
                window.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    // 方法3：桶排序。要求两两元素差值<=t，那么，可以使用桶排序的方式，
    // 令桶大小为t+1,当存在两个元素都放入同一个桶时，即满足条件。
    // 当两元素位于相邻桶时，需要再检查一次
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0) {
            return false;
        }
        int capacity = t + 1;
        Map<Long, Long> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long id = getBucketId(nums[i], capacity);
            if (bucket.containsKey(id)) {
                return true;
            }
            if (bucket.containsKey(id - 1) && Math.abs(bucket.get(id - 1) - nums[i]) <= t) {
                return true;
            }
            if (bucket.containsKey(id + 1) && Math.abs(bucket.get(id + 1) - nums[i]) <= t) {
                return true;
            }
            bucket.put(id, (long) nums[i]);
            if (i >= k) {
                bucket.remove(getBucketId(nums[i - k], capacity));
            }
        }
        return false;
    }

    private long getBucketId(int item, int capacity) {
        return item >= 0 ? item / capacity : (item + 1) / capacity - 1;
    }
}
