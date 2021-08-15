package com.cshawn.codes.leetcodes.everyday;

/**
 * 最少侧跳次数
 * 给你一个长度为n的3 跑道道路，它总共包含n + 1个点，编号为0到n。
 * 一只青蛙从0号点第二条跑道出发，它想要跳到点n处。然而道路上可能有一些障碍。
 * 给你一个长度为 n + 1的数组obstacles，其中obstacles[i]（取值范围从 0 到 3）表示在点 i处的obstacles[i]跑道上有一个障碍。
 * 如果obstacles[i] == 0，那么点i处没有障碍。任何一个点的三条跑道中最多有一个障碍。
 * 比方说，如果obstacles[2] == 1，那么说明在点 2 处跑道 1 有障碍。
 * 这只青蛙从点 i跳到点 i + 1且跑道不变的前提是点 i + 1的同一跑道上没有障碍。
 * 为了躲避障碍，这只青蛙也可以在同一个点处侧跳到 另外一条跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。
 * 比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
 * 这只青蛙从点 0 处跑道 2出发，并想到达点 n处的 任一跑道 ，请你返回 最少侧跳次数。
 * 注意：点 0处和点 n处的任一跑道都不会有障碍。
 *
 * 示例 1：
 * 输入：obstacles = [0,1,2,3,0]
 * 输出：2 
 * 解释：最优方案如上图箭头所示。总共有 2 次侧跳（红色箭头）。
 * 注意，这只青蛙只有当侧跳时才可以跳过障碍（如上图点 2 处所示）。
 *
 * 示例 2：
 * 输入：obstacles = [0,1,1,3,3,0]
 * 输出：0
 * 解释：跑道 2 没有任何障碍，所以不需要任何侧跳。
 *
 * 示例 3：
 * 输入：obstacles = [0,2,1,0,3,0]
 * 输出：2
 * 解释：最优方案如上图所示。总共有 2 次侧跳。
 * 提示：
 * obstacles.length == n + 1
 * 1 <= n <= 5 * 105
 * 0 <= obstacles[i] <= 3
 * obstacles[0] == obstacles[n] == 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-sideway-jumps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/11 11:13 上午
 */
public class Q5728 {
    private int result;
    // 方法1：回溯，超时
    public int minSideJumps1(int[] obstacles) {
        result = obstacles.length;
        backtracking(obstacles, 2, 0, 0);
        return result;
    }

    private void backtracking(int[] obstacles, int cur, int index, int temp) {
        if (index == obstacles.length - 1) {
            result = Math.min(result, temp);
            return;
        }
        if (obstacles[index + 1] == cur) {
            for (int i = 1; i <= 3; i++) {
                if (i != cur && i != obstacles[index]) {
                    backtracking(obstacles, i, index + 1, temp + 1);
                }
            }
        } else {
            backtracking(obstacles, cur, index + 1, temp);
        }
    }

    // 方法2：贪心
    public int minSideJumps(int[] obstacles) {
        int cur = 2, res = 0;
        for (int i = 0; i < obstacles.length - 1; i++) {
            if (obstacles[i + 1] == cur) {
                int other1 = (cur + 1) % 3 == 0 ? 3 : (cur + 1) % 3;
                int other2 = cur == 2 ? 3 : (cur + 2) % 3;
                int index1 = i, index2 = i;
                while (index1 < obstacles.length && obstacles[index1] != other1) {
                    index1++;
                }
                while (index2 < obstacles.length && obstacles[index2] != other2) {
                    index2++;
                }
                if (index1 > index2) {
                    i = index1 - 2;
                    cur = other1;
                } else {
                    i = index2 - 2;
                    cur = other2;
                }
                res++;
            }
        }
        return res;
    }
}
