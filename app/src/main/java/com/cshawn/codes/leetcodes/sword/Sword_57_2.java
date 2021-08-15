package com.cshawn.codes.leetcodes.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * 限制：1 <= target <= 10^5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/25 11:46 上午
 */
public class Sword_57_2 {
    // 方法1：暴力求解
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int limit = (target + 1) / 2;
        for (int i = 1; i < limit; i++) {
            int sum = 0;
            int j;
            for (j = i; sum < target; j++) {
                sum += j;
            }
            if (sum == target) {
                int[] array = new int[j - i];
                for (int k = i; k < j; k++) {
                    array[k - i] = k;
                }
                list.add(array);
            }
        }
        return list.toArray(new int[list.size()][]);
    }


    // 方法2：双指针
    public int[][] findContinuousSequence2(int target) {
        List<int[]> list = new ArrayList<>();
        int left = 1, right = 1, sum = 0;
        while (left <= target / 2) {
            if (sum < target) {
                sum += right++;
            } else if (sum > target) {
                sum -= left++;
            } else {
                int[] array = new int[right - left];
                for (int k = left; k < right; k++) {
                    array[k - left] = k;
                }
                list.add(array);
                sum -= left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
