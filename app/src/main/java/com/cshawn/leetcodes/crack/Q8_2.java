package com.cshawn.leetcodes.crack;

import java.util.LinkedList;
import java.util.List;

/**
 * 迷路的机器人
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 *
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释: 
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/22 8:53 下午
 */
public class Q8_2 {
    // 回溯+剪枝
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> result = new LinkedList<>();
        if (dfs(obstacleGrid, result, 0, 0)) {
            return result;
        }
        result.clear();
        return result;
    }

    private boolean dfs(int[][] obstacleGrid, List<List<Integer>> result, int i, int j) {
        // 越界或当前值为1，不满足条件
        if (i == obstacleGrid.length || j == obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return false;
        }
        // 添加当前位置
        List<Integer> position = new LinkedList<>();
        position.add(i);
        position.add(j);
        result.add(position);
        // 到达终点
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return true;
        }
        // 向下到达终点，则返回
        if (dfs(obstacleGrid, result, i, j + 1)) {
            return true;
        }
        // 向右到达终点，则返回
        if (dfs(obstacleGrid, result, i + 1, j)) {
            return true;
        }
        // 否则需要回溯
        result.remove(result.size() - 1);
        // 如果到达此处, 说明从当前坐标[i,j]向下或向右移动都无法到达目标地, 那么将当前坐标置为1, 进行剪枝处理
        obstacleGrid[i][j] = 1;
        return false;
    }
}
