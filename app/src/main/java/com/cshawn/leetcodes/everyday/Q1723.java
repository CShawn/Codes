package com.cshawn.leetcodes.everyday;

/**
 * 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * 示例 1：
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 *
 * 示例 2：
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 *
 * 提示：
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/8 9:56 下午
 */
public class Q1723 {
    private int result = Integer.MAX_VALUE >> 1;
    // 方法1：回溯，超时
    public int minimumTimeRequired1(int[] jobs, int k) {
        // sum[i]表示第i个人分到的工作时长
        int[] sum = new int[k];
        backTracking1(jobs, sum, 0, 0);
        return result;
    }

    // max表示当前个人分到的最大工作时长
    private void backTracking1(int[] jobs, int[] sum, int index, int max) {
        if (max >= result) {
            return;
        }
        if (index == jobs.length) {
            result = max;
            return;
        }
        for (int i = 0; i < sum.length; i++) {
            sum[i] += jobs[index];
            backTracking1(jobs, sum, index + 1, Math.max(max, sum[i]));
            sum[i] -= jobs[index];
        }
    }

    // 方法2：优化方法1
    // 在回溯过程中，太耗时；最优解应该是工作平均分配，因此可以优先将工作分配给未分配工作的人
    public int minimumTimeRequired(int[] jobs, int k) {
        // sum[i]表示第i个人分到的工作时长
        int[] sum = new int[k];
        backTracking(jobs, sum, 0, 0, 0);
        return result;
    }

    // used表示当前有几个工人被分配了工作
    private void backTracking(int[] jobs, int[] sum, int used, int index, int max) {
        if (max >= result) {
            return;
        }
        if (index == jobs.length) {
            result = max;
            return;
        }
        // 优先分配给空闲工人
        if (used < sum.length) {
            sum[used] = jobs[index];
            backTracking(jobs, sum, used + 1, index + 1, Math.max(sum[used], max));
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[index];
            backTracking(jobs, sum, used, index + 1, Math.max(max, sum[i]));
            sum[i] -= jobs[index];
        }
    }
}
