package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 子集
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/31 10:56 上午
 */
public class Q78 {
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        // 生成不同长度的子集
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, result, new Integer[i], 0, 0);
        }
        return result;
    }

    /**
     * 生成长度为count的子集
     *
     * @param nums   原数组
     * @param result 结果集
     * @param sub    长度为目标长度的子数组
     * @param index  子数组要填充的当前索引
     * @param start  原数组的开始遍历位置
     */
    private void dfs(int[] nums, List<List<Integer>> result, Integer[] sub, int index, int start) {
        // 当子数组遍历结束时添加到结果集
        if (index == sub.length) {
            result.add(new ArrayList<>(Arrays.asList(sub)));
            return;
        }
        // 当起始位置大于原数组长度时退出
        if (start == nums.length) {
            return;
        }
        // 从起始位置开始选择并回溯
        for (int i = start; i < nums.length; i++) {
            // 选择
            sub[index] = nums[i];
            // 继续向后选择
            dfs(nums, result, sub, index + 1, i + 1);
            // 下一次仍向index位置赋值，相当于回溯
        }
    }

    // 方法2：每个元素有选择与不选两种情况
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(nums, 0, result, new LinkedList<>());
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> sub) {
        if (index == nums.length) {
            result.add(new LinkedList<>(sub));
            return;
        }
        // 选择一个元素
        sub.add(nums[index]);
        // 继续选择后续元素
        dfs(nums, index + 1, result, sub);
        // 不选择当前选择
        sub.remove(sub.size() - 1);
        // 继续选择后续元素
        dfs(nums, index + 1, result, sub);
    }

    // 方法3：每个元素可选可不选，取0或取1，则相当于二进制
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (((mask >> i) & 1) == 1) {
                    list.add(nums[i]);
                }
            }
            result.add(list);
        }
        return result;
    }
}
