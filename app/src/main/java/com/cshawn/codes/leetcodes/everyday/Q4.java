package com.cshawn.codes.leetcodes.everyday;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 *
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 *
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/8 3:54 下午
 */
public class Q4 {
    // 方法1：合并数组并查找中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int i = 0, j = 0;
        // 最终要归并的结尾为中间元素
        int end = (nums1.length + nums2.length) / 2;
        int temp = 0;
        // 临界条件为end之前
        while (i + j < end) {
            if (j == nums2.length || (i != nums1.length && nums1[i] <= nums2[j])) {
                temp = nums1[i++];
            } else {
                temp = nums2[j++];
            }
        }
        // 奇数个则再向后归并一个元素
        if ((nums1.length + nums2.length) % 2 != 0) {
            if (j == nums2.length || (i != nums1.length && nums1[i] <= nums2[j])) {
                temp = nums1[i];
            } else {
                temp = nums2[j];
            }
            return temp;
        } else {
            // 偶数个则与后一个元素相加求平均数
            if (j == nums2.length || (i != nums1.length && nums1[i] <= nums2[j])) {
                temp += nums1[i];
            } else {
                temp += nums2[j];
            }
            return temp / 2.0;
        }
    }
}
