package com.cshawn.leetcodes.everyday;

/**
 * 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组A，我们最多可以将K个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释： 
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 示例 2：
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * 提示：
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为0或1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/19 8:41 下午
 */
public class Q1004 {
    // 题意可理解为，找到一个最长的子数组，其中包括的0最多为k个
    // 故使用滑动窗口
    public int longestOnes(int[] A, int K) {
        int result = 0;
        int left = 0, right = 0, count = 0;
        while (right < A.length) {
            // 统计0的个数
            if (A[right++] == 0) {
                count++;
            }
            // 多于k个时，左指针右移
            while (count > K) {
                // 遇到0减少计数
                if (A[left++] == 0) {
                    count--;
                }
            }
            // 更新结果长度
            // right已加1，故不用right-left+1
            result = Math.max(right - left, result);
        }
        return result;
    }
}
