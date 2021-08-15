package com.cshawn.codes.leetcodes.crack;

/**
 * 魔术索引
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 *
 * 示例2:
 *  输入：nums = [1, 1, 1]
 *  输出：1
 * 说明:
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/22 11:08 下午
 */
public class Q8_3 {
    // 二分法思想，但不是真正的二分法
    public int findMagicIndex(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    // 先递归找 mid 左侧，找到就返回，没找到，再看 mid 是不是魔术索引，是就返回，不是才找右侧。
    private int binarySearch(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + ((right - left) >> 1);
        int find = binarySearch(nums, left, middle - 1);
        if (find != -1) {
            return find;
        } else if (nums[middle] == middle) {
            return middle;
        } else {
            return binarySearch(nums, middle + 1, right);
        }
    }
}
