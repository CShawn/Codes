package com.cshawn.codes.leetcodes.everyday;

/**
 * 环形数组是否存在循环
 * 存在一个不含 0 的 环形 数组nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果nums[i] 是负数，向后 移动 nums[i] 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 *
 * 示例 2：
 * 输入：nums = [-1,2]
 * 输出：false
 * 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 *
 * 示例 3:
 * 输入：nums = [-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
 * 所有 nums[seq[j]] 应当不是全正就是全负。
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 *
 * 进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circular-array-loop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/8 10:25 上午
 */
class Q457 {
    // 方法1：模拟遍历O(N^2)
    public boolean circularArrayLoop1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int start = i, cur = i, k = 1;
            // 标记当前符号
            boolean flag = nums[i] > 0;
            while (true) {
                // 遍历结束卡在循环中但不是环
                if (k > nums.length) {
                    break;
                }
                // 找到下一个结点
                int next = ((cur + nums[cur]) % nums.length + nums.length) % nums.length;
                // 下一个结点的符号与当前不同
                if ((flag && nums[next] < 0) || (!flag && nums[next] > 0)) {
                    break;
                }
                // 找到环
                if (next == start) {
                    if (k > 1) {
                        return true;
                    } else {
                        // 长度为1，不符合条件，继续遍历
                        break;
                    }
                }
                // 更新当前结点并继续遍历
                cur = next;
                k++;
            }
        }
        return false;
    }

    // 方法2：优化方法1，记录已遍历的结点
    public boolean circularArrayLoop(int[] nums) {
        // 记录某个索引是何时(第几次遍历，为方便，从1开始)被标记的
        int[] visited = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            int cur = i, curRound = i + 1;
            visited[cur] = curRound;
            // 标记当前符号
            boolean flag = nums[i] > 0;
            while (true) {
                // 找到下一个结点
                int next = ((cur + nums[cur]) % nums.length + nums.length) % nums.length;
                // 当前结点下一个结点还是自身，不算环
                if (next == cur) {
                    break;
                }
                if (visited[next] != 0) {
                    // 在当前轮被标记，找到环
                    if (visited[next] == curRound) {
                        return true;
                    } else {
                        break;
                    }
                }
                // 下一个结点的符号与当前不同
                if ((flag && nums[next] < 0) || (!flag && nums[next] > 0)) {
                    break;
                }
                // 更新当前结点并继续遍历
                cur = next;
                visited[cur] = curRound;
            }
        }
        return false;
    }
}