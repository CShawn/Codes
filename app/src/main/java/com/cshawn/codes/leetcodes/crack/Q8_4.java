package com.cshawn.codes.leetcodes.crack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 幂集
 * 编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 说明：解集不能包含重复的子集。
 * 示例:
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/28 6:40 下午
 */
public class Q8_4 {

    // 回溯
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        // 子集中每个子集合的长度
        for (int count = 0; count <= nums.length; count++) {
            dfs(result, list, nums, count, 0);
        }
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int count, int index) {
        if (list.size() == count) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, nums, count, i + 1);
            list.remove(list.get(list.size() - 1));
        }
    }

    // 优化方法1
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        //走过的所有路径都是子集的一部分，所以都要加入到集合中
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
