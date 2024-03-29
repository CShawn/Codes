package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * 单线程 CPU
 * 给你一个二维数组 tasks ，用于表示 n 项从 0 到 n - 1 编号的任务。
 * 其中 tasks[i] = [enqueueTimei, processingTimei] 意味着第 i 项任务将会于 enqueueTimei 时进入任务队列，需要 processingTimei 的时长完成执行。
 * 现有一个单线程 CPU ，同一时间只能执行 最多一项 任务，该 CPU 将会按照下述方式运行：
 * 如果 CPU 空闲，且任务队列中没有需要执行的任务，则 CPU 保持空闲状态。
 * 如果 CPU 空闲，但任务队列中有需要执行的任务，则 CPU 将会选择 执行时间最短 的任务开始执行。
 * 如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
 * 一旦某项任务开始执行，CPU 在 执行完整个任务 前都不会停止。
 * CPU 可以在完成一项任务后，立即开始执行一项新任务。
 * 返回 CPU 处理任务的顺序。
 *
 * 示例 1：
 * 输入：tasks = [[1,2],[2,4],[3,2],[4,1]]
 * 输出：[0,2,3,1]
 * 解释：事件按下述流程运行：
 * - time = 1 ，任务 0 进入任务队列，可执行任务项 = {0}
 * - 同样在 time = 1 ，空闲状态的 CPU 开始执行任务 0 ，可执行任务项 = {}
 * - time = 2 ，任务 1 进入任务队列，可执行任务项 = {1}
 * - time = 3 ，任务 2 进入任务队列，可执行任务项 = {1, 2}
 * - 同样在 time = 3 ，CPU 完成任务 0 并开始执行队列中用时最短的任务 2 ，可执行任务项 = {1}
 * - time = 4 ，任务 3 进入任务队列，可执行任务项 = {1, 3}
 * - time = 5 ，CPU 完成任务 2 并开始执行队列中用时最短的任务 3 ，可执行任务项 = {1}
 * - time = 6 ，CPU 完成任务 3 并开始执行任务 1 ，可执行任务项 = {}
 * - time = 10 ，CPU 完成任务 1 并进入空闲状态
 *
 * 示例 2：
 * 输入：tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
 * 输出：[4,3,2,0,1]
 * 解释：事件按下述流程运行：
 * - time = 7 ，所有任务同时进入任务队列，可执行任务项  = {0,1,2,3,4}
 * - 同样在 time = 7 ，空闲状态的 CPU 开始执行任务 4 ，可执行任务项 = {0,1,2,3}
 * - time = 9 ，CPU 完成任务 4 并开始执行任务 3 ，可执行任务项 = {0,1,2}
 * - time = 13 ，CPU 完成任务 3 并开始执行任务 2 ，可执行任务项 = {0,1}
 * - time = 18 ，CPU 完成任务 2 并开始执行任务 0 ，可执行任务项 = {1}
 * - time = 28 ，CPU 完成任务 0 并开始执行任务 1 ，可执行任务项 = {}
 * - time = 40 ，CPU 完成任务 1 并进入空闲状态
 *
 * 提示：
 * tasks.length == n
 * 1 <= n <= 105
 * 1 <= enqueueTimei, processingTimei <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-threaded-cpu
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/18 10:52 上午
 */
public class Q5736 {
    // 数组按启动时间排序 + 排序Map按执行时长排序
    public int[] getOrder(int[][] tasks) {
        int[] result = new int[tasks.length];
        // 1. 使用数组按顺序存储每个task的启动时间，数组中元素为task的索引
        Integer[] orderByStart = new Integer[tasks.length];
        for (int i = 0; i < orderByStart.length; i++) {
            orderByStart[i] = i;
        }
        // 按启动时间排序
        Arrays.sort(orderByStart, Comparator.comparingInt(o -> tasks[o][0]));
        // 当前时间
        long time = 0;
        // 当前的任务
        int cur = 0;
        // 2. 使用优先级队列来按任务需执行时长存储当前时间之前加入的任务<任务执行时长, 任务的索引>
        PriorityQueue<int[]> orderByCost = new PriorityQueue<>(result.length, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < result.length; i++) {
            // 当前时间点无任务时，取下一个任务，将时间置为此任务的开始时间
            if (orderByCost.isEmpty()) {
                time = Math.max(time, tasks[orderByStart[cur]][0]);
            }
            // 将当前时间前加入的任务按照所需执行时间排序，并存储其原先对应的索引
            while (cur < result.length && tasks[orderByStart[cur]][0] <= time) {
                orderByCost.add(new int[]{tasks[orderByStart[cur]][1], orderByStart[cur]});
                cur++;
            }
            // 取出第一个任务执行
            if (!orderByCost.isEmpty()) {
                int[] choice = orderByCost.poll();
                // 更新执行后的时间
                time += choice[0];
                // 记录当前所选择任务的索引
                result[i] = choice[1];
            }
        }
        return result;
    }
}
