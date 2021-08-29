package com.cshawn.codes.leetcodes.everyday;

/**
 * 所有奇数长度子数组的和
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 *
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 * 提示：
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/29 11:17 上午
 */
public class Q1588 {

    // 累加
    public int sumOddLengthSubarrays1(int[] arr) {
        int result = 0;
        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
            pre = arr[i];
            result += pre;
            for (int j = i + 2; j < arr.length; j += 2) {
                pre += arr[j];
                pre += arr[j - 1];
                result += pre;
            }
        }
        return result;
    }

    // 前缀和
    public int sumOddLengthSubarrays2(int[] arr) {
        int[] sum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j += 2) {
                result += sum[j + 1] - sum[i];
            }
        }
        return result;
    }

    // 数学
    // 从第i个元素向左右扩展，要求总数奇数个，则向左扩展奇数个且向右扩展奇数个；或向左右都为偶数个
    // i左侧有i个元素，右侧有n-1-i个元素，左侧扩展连续奇数个元素有(i+1)/2个，其他情况同理计算
    // 而i在这些情况中构成K种方案，对最终结果的贡献值为k*arr[i]
    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int l0 = (i >> 1) + 1;
            int r0 = ((arr.length - 1 - i) >> 1) + 1;
            int l1 = (i + 1) >> 1;
            int r1 = (arr.length - i) >> 1;
            result += ((l0 * r0) + (l1 * r1)) * arr[i];
        }
        return result;
    }
}
