package com.cshawn.codes.leetcodes.sword;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 限制：0 <= 数组长度 <= 50000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/31 12:22 下午
 */
public class Sword_51 {
    // 分治，拆分到两个元素，统计逆序对，之后扩大范围，为避免重复统计，应将之前统计过的两个元素忽略
    // 将两个元素排序，使不为逆序即可。这个过程类似于归并排序，使用归并排序的思想即可。
    // 归并过程中，比较前后两个数组的元素，当后数组的元素比前数组小时，与前数组各个元素构成逆序对
    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        return mergeCount(copy, new int[nums.length], 0, nums.length - 1);
    }

    private int mergeCount(int[] nums, int[] sort, int left, int right) {
        if (left == right) {
            return 0;
        }
        int count = 0;
        int mid = left + (right - left) / 2;
        count += mergeCount(nums, sort, left, mid);
        count += mergeCount(nums, sort, mid + 1, right);
        // 已正常排序则无需比较及统计
        if (nums[mid] <= nums[mid + 1]) {
            return count;
        }
        // 复制一份待排序的元素
        System.arraycopy(nums, left, sort, left, right + 1 - left);
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // 左侧数组到达边界
                nums[k] = sort[j++];
            } else if (j > right) {
                // 右侧数组到达边界
                nums[k] = sort[i++];
            } else if (sort[i] <= sort[j]) {
                // 将nums排序
                nums[k] = sort[i++];
            } else {
                // 将nums排序
                nums[k] = sort[j++];
                // 累加当前元素j构成的逆序对个数
                count += mid - i + 1;
            }
        }
        return count;
    }
}
