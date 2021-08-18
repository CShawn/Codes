package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 学生出勤记录II
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量。
 * 答案可能很大，所以返回对 109 + 7 取余 的结果。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：3
 *
 * 示例 3：
 * 输入：n = 10101
 * 输出：183236316
 *
 * 提示：1 <= n <= 105
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/18 3:27 下午
 */
public class Q552 {
    // 方法1：动态规划
    public int checkRecord1(int n) {
        int limitA = 2, limitL = 3;
        // dp[i][j][k]表示长度为i,共包含j个A,结尾含k个L的满足条件数量
        int[][][] dp = new int[n + 1][limitA][limitL];
        dp[0][0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < limitA; j++) {
                for (int k = 0; k < limitL; k++) {
                    // 添加P
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % 1000000007;
                    // 添加A
                    if (j > 0) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][k]) % 1000000007;
                    }
                    // 添加L
                    if (k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % 1000000007;
                    }
                }
            }
        }
        int result = 0;
        for (int j = 0; j < limitA; j++) {
            for (int k = 0; k < limitL; k++) {
                result = (result + dp[n][j][k]) % 1000000007;
            }
        }
        return result;
    }

    // 方法2：优化方法1空间
    public int checkRecord(int n) {
        int limitA = 2, limitL = 3;
        // dp[i]只与dp[i-1]有关，使用滚动数组优化
        int[][][] dp = new int[2][limitA][limitL];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int cur = i & 1, pre = cur ^ 1;
            for (int j = 0; j < limitA; j++) {
                Arrays.fill(dp[cur][j], 0);
            }
            for (int j = 0; j < limitA; j++) {
                for (int k = 0; k < limitL; k++) {
                    // 添加P
                    dp[cur][j][0] = (dp[cur][j][0] + dp[pre][j][k]) % 1000000007;
                    // 添加A
                    if (j > 0) {
                        dp[cur][j][0] = (dp[cur][j][0] + dp[pre][j - 1][k]) % 1000000007;
                    }
                    // 添加L
                    if (k > 0) {
                        dp[cur][j][k] = (dp[cur][j][k] + dp[pre][j][k - 1]) % 1000000007;
                    }
                }
            }
        }
        int result = 0, last = n & 1;
        for (int j = 0; j < limitA; j++) {
            for (int k = 0; k < limitL; k++) {
                result = (result + dp[last][j][k]) % 1000000007;
            }
        }
        return result;
    }
}
