package com.cshawn.codes.leetcodes.everyday;

/**
 * 跳跃游戏 VII
 * 给你一个下标从 0 开始的二进制字符串  s  和两个整数  minJump 和  maxJump  。
 * 一开始，你在下标  0  处，且该位置的值一定为  '0'  。当同时满足如下条件时，你可以从下标  i  移动到下标  j  处：
 * i + minJump <= j <= min(i + maxJump, s.length - 1)  且 s[j] == '0'.
 * 如果你可以到达 s  的下标  s.length - 1  处，请你返回  true  ，否则返回  false  。
 *
 * 示例 1：
 * 输入：s = "011010", minJump = 2, maxJump = 3
 * 输出：true
 * 解释：
 * 第一步，从下标 0 移动到下标 3 。
 * 第二步，从下标 3 移动到下标 5 。
 *
 * 示例 2：
 * 输入：s = "01101110", minJump = 2, maxJump = 3
 * 输出：false
 *   
 * 提示：
 * 2 <= s.length <= 105
 * s[i]  要么是  '0'  ，要么是  '1'
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-vii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。给你一个下标从 0 开始的二进制字符串  s  和两个整数  minJump 和  maxJump  。一开始，你在下标  0  处，且该位置的值一定为  '0'  。当同时满足如下条件时，你可以从下标  i  移动到下标  j  处：
 * @author C.Shawn
 * @date 2021/5/23 1:04 下午
 */
public class Q5765 {
    boolean result = false;
    // 方法1：回溯，超时
    public boolean canReach1(String s, int minJump, int maxJump) {
        char[] arr = s.toCharArray();
        boolean[] memo = new boolean[arr.length];
        backTracking(arr, memo, 0, minJump, maxJump);
        return result;
    }

    private void backTracking(char[] arr, boolean[] memo, int index, int minJump, int maxJump) {
        if (index == arr.length - 1) {
            result = true;
            return;
        }
        for (int i = index + minJump; i <= index + maxJump && i < arr.length; i++) {
            if (memo[i]) {
                continue;
            }
            if (arr[i] == '0') {
                backTracking(arr, memo, i, minJump, maxJump);
                memo[i] = true;
                if (result) {
                    break;
                }
            }
        }
    }

    // 方法2：一次遍历
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] arr = s.toCharArray();
        // 记录所有能到达且为0的位置
        boolean[] dp = new boolean[arr.length];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = i + minJump; j < arr.length && j <= i + maxJump && !dp[j] ; j++) {
                dp[j] = arr[j] == '0';
            }
        }
        return dp[arr.length - 1];
    }
}
