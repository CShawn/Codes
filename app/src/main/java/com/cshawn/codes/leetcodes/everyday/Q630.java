package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 课程表 III
 * 这里有 n 门不同的在线课程，按从 1 到 n编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 * 返回你最多可以修读的课程数目。
 *
 * 示例 1：
 * 输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * 输出：3
 * 解释：
 * 这里一共有 4 门课程，但是你最多可以修 3 门：
 * 首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
 * 第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
 * 第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
 * 第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
 *
 * 示例 2：
 * 输入：courses = [[1,2]]
 * 输出：1
 *
 * 示例 3：
 * 输入：courses = [[3,2],[4,3]]
 * 输出：0
 *
 * 提示:
 * 1 <= courses.length <= 104
 * 1 <= durationi, lastDayi <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/14 8:25 上午
 */
public class Q630 {
    // 贪心 + 大根堆
    public int scheduleCourse(int[][] courses) {
        // 按照截止日期排序，优先选deadline最早的课程
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        int day = 0;
        // 按照deadline选课后，可能一些课程deadline较小被选而导致后边的课程中耗时较小的课程无法被选
        // 但选择耗时较小的课程可以多选课，因此需要做出调整

        // 存储已选择的课程的耗时，按照耗时最长优先排序
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int[] course : courses) {
            if (day + course[0] <= course[1]) {
                // 当前课程可选
                day += course[0];
                heap.offer(course[0]);
            } else if (!heap.isEmpty() && course[0] < heap.peek()) {
                // 当前课程deadline在已选的课程中较大，但其耗时较短，可以变换选课，
                // 将已选的课程中，耗时最长的课程替换成当前课程
                int c = heap.poll();
                day -= c;
                day += course[0];
                heap.offer(course[0]);
            }
        }
        return heap.size();
    }
}
