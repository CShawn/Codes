package com.cshawn.leetcodes.sword;

/**
 * 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 限制：0 <= 数组长度 <= 50000
 *
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/20 10:42 上午
 */
public class Sword_53_1 {
    /**
     * 二分查找到目标数字，再查找其左边界和右边界
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int middle = binarySearch(nums, target, 0, nums.length - 1);
        if (middle == -1) {
            return 0;
        }
        int left = binarySearchLeft(nums, target, 0, middle);
        int right = binarySearchRight(nums, target, middle, nums.length - 1);
        return right - left + 1;
    }

    /**
     * 二分查找值
     */
    private int binarySearch(int[] nums, int target, int left, int right) {
        if (right < 0 || left >= nums.length) {
            return -1;
        }
        int m = (left + right) / 2;
        if (nums[m] == target) {
            return m;
        }
        // 未找到目标值
        if (left == right) {
            return -1;
        }
        if (nums[m] < target) {
            return binarySearch(nums, target, m + 1, right);
        } else {
            return binarySearch(nums, target, left, m - 1);
        }
    }

    /**
     * 二分查找左边界
     */
    private int binarySearchLeft(int[] nums, int target, int left, int right) {
        int m = (left + right) / 2;
        if (nums[m] == target) {
            // 查找到的位置为0或最左边界，直接赋值为左边界
            if (m == 0 || nums[m - 1] != target) {
                return m;
            }
            return binarySearchLeft(nums, target, left, m - 1);
        } else {
            return binarySearchLeft(nums, target, m + 1, right);
        }
    }

    /**
     * 二分查找右边界
     */
    private int binarySearchRight(int[] nums, int target, int left, int right) {
        int m = (left + right) / 2;
        if (nums[m] == target) {
            // 查找到的位置为尾部或最右边界，直接赋值为右边界
            if (m == nums.length - 1 || nums[m + 1] != target) {
                return m;
            }
            return binarySearchRight(nums, target, m + 1, right);
        } else {
            return binarySearchRight(nums, target, left, m - 1);
        }
    }

    // 二分查找可以更简单
    public int search2(int[] nums, int target) {
        // 因数组排序，故查找target-1查找到的数字为target前的一个数字
        return binaryFindRight(nums, target) - binaryFindRight(nums, target - 1);
    }

    private int binaryFindRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1, m;
        while (left <= right) {
            m = (left + right) / 2;
            // 此处判断条件为<=,查找到的数字即为target的前一个数字
            if (nums[m] <= target) {
                // 此时为二分查找
                left = m + 1;
            } else {
                // 此时为二分查找
                right = m - 1;
            }
        }
        return left;
    }
}
