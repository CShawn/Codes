package com.cshawn.leetcodes.everyday;

/**
 * 最长湍流子数组
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 返回 A 的最大湍流子数组的长度。
 *
 * 示例 1：
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 *
 * 示例 2：
 * 输入：[4,8,12,16]
 * 输出：2
 *
 * 示例 3：
 * 输入：[100]
 * 输出：1
 * 提示：
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/8 3:02 下午
 */
public class Q978 {
    // 双指针或滑动窗口
    public int maxTurbulenceSize1(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        // 定义左右指针，最终结果，临时存储长度，之前两个元素的差
        int left = 0, right = 1, result = 1, temp, preDiff = 0;
        // 边界条件为右指针到达数组边界
        while (right < arr.length) {
            // 计算当前两个元素的差值
            int diff = arr[right] - arr[right - 1];
            // 若两元素相等，则将左指针指向当前位置，重新开始
            if (diff == 0) {
                left = right;
            } else {
                // 通过判断当前两个元素的差与之前两个元素的差是否异号，来判断是否满足湍流条件
                if (preDiff == 0 || (diff ^ preDiff) < 0) {
                    // 更新最大长度
                    temp = right - left + 1;
                    if (temp > result) {
                        result = temp;
                    }
                } else {
                    // 不满足条件时，左指针指向当前位置的前一个位置
                    left = right - 1;
                }
            }
            // 更新记录的两元素差值
            preDiff = diff;
            // 右指针右移
            right++;
        }
        return result;
    }

    // 动态规划
    public int maxTurbulenceSize2(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        // up[i]表示以i结尾且arr[i]>arr[i-1]的最大湍流子数组的长度
        int[] up = new int[arr.length];
        // down[i]表示以i结尾且arr[i]<arr[i-1]的最大湍流子数组的长度
        int[] down = new int[arr.length];
        int result = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                // 状态转移
                up[i] = down[i - 1] + 1;
                // 更新最大值
                // dp数组默认值应为1，为方便默认为0，在计算结果加1
                if (up[i] + 1 > result) {
                    result = up[i] + 1;
                }
            } else if (arr[i] < arr[i - 1]) {
                // 同上
                down[i] = up[i - 1] + 1;
                if (down[i] + 1 > result) {
                    result = down[i] + 1;
                }
            }
        }
        return result;
    }

    // 动态规划空间存储优化
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        // 因当前状态只与前一个状态相关，可节约空间
        int up = 1, down = 1;
        int result = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                // 状态转移
                up = down + 1;
                down = 1;
                // 更新最大值
                // dp数组默认值应为1，为方便默认为0，在计算结果加1
                if (up > result) {
                    result = up;
                }
            } else if (arr[i] < arr[i - 1]) {
                // 同上
                down = up + 1;
                up = 1;
                if (down > result) {
                    result = down;
                }
            } else {
                up = 1;
                down = 1;
            }
        }
        return result;
    }
}