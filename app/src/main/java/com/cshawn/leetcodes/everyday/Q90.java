package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/31 9:53 上午
 */
public class Q90 {
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        dfs(nums, result, new LinkedList<>(), 0, false);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> sub, int index, boolean usedPre) {
        if (index == nums.length) {
            result.add(new LinkedList<>(sub));
            return;
        }
        dfs(nums, result, sub, index + 1, false);
        if (!usedPre && index > 0 && nums[index - 1] == nums[index]) {
            return;
        }
        sub.add(nums[index]);
        dfs(nums, result, sub, index + 1, true);
        sub.remove(sub.size() - 1);
    }

    // 方法2：类似二进制
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            List<Integer> list = new LinkedList<>();
            boolean repeat = false;
            for (int i = 0; i < nums.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask & (1 << (i - 1))) == 0 && nums[i] == nums[i - 1]) {
                        repeat = true;
                        break;
                    }
                    list.add(nums[i]);
                }
            }
            if (!repeat) {
                result.add(list);
            }
        }
        return result;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> result) {
        result.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            dfs(nums, i + 1, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
}
