package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;

/**
 * 在线选举
 * 给你两个整数数组 persons 和 times 。在选举中，第i张票是在时刻为times[i]时投给候选人 persons[i]的。
 * 对于发生在时刻 t 的每个查询，需要找出在t 时刻在选举中领先的候选人的编号。
 * 在t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 * 实现 TopVotedCandidate 类：
 * TopVotedCandidate(int[] persons, int[] times) 使用persons 和 times 数组初始化对象。
 * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
 * 示例：
 * 输入：
 * ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
 * [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
 * 输出：
 * [null, 0, 1, 1, 0, 0, 1]
 * 解释：
 * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
 * topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
 * topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
 * topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
 * topVotedCandidate.q(15); // 返回 0
 * topVotedCandidate.q(24); // 返回 0
 * topVotedCandidate.q(8); // 返回 1
 * 
 * 提示：
 * 1 <= persons.length <= 5000
 * times.length == persons.length
 * 0 <= persons[i] < persons.length
 * 0 <= times[i] <= 109
 * times 是一个严格递增的有序数组
 * times[0] <= t <= 109
 * 每个测试用例最多调用 104 次 q
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-election
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/11 7:54 下午
 */
public class Q911 {
    // 哈希表 + 二分查找
    static class TopVotedCandidate {
        private final int[] votes;
        private final int[] times;
        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            this.votes = new int[persons.length];
            votes[0] = persons[0];
            // 记录当前选票最多的人
            int pre = persons[0];
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(persons[0], 1);
            for (int i = 1; i < persons.length; i++) {
                map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
                if (map.get(persons[i]) >= map.get(pre)) {
                    votes[i] = persons[i];
                    pre = votes[i];
                } else {
                    votes[i] = pre;
                }
            }
        }

        public int q(int t) {
            int index = binarySearch(t);
            return votes[index];
        }

        private int binarySearch(int t) {
            int left = 0, right = times.length - 1, mid;
            while (left <= right) {
                mid = left + ((right - left) >> 1);
                if (times[mid] == t) {
                    return mid;
                }
                if (times[mid] <= t) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left - 1;
        }
    }
}
