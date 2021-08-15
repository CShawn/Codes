package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 * 给定一个范围在 1 ≤ a[i] ≤ n (n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 * 输入:[4,3,2,7,8,2,3,1]
 * 输出:[5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/13 7:29 下午
 */
public class Q448 {
    // 方法1：将数字放到其对应的索引位置上，最后检查位置与数字不对应的即为目标值
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        // 定义临时数字用于交换
        int temp;
        List<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i ++) {
            // 当前位置上的数字与位置不符，且要交换的位置上数字与其位置也不符，才进行交换
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        // 检查位置与数字不匹配的为目标值
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    // 方法2：如果需要保持原数组不变。可以将所有存在的数字+n,那么存在的数字必然大于n。
    // 检查<n的即为目标值，将每个数字对n取余即还原
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        for (int num : nums) {
            nums[(num - 1) % nums.length] += nums.length;
        }
        // 检查数字<n为未出现过
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                result.add(i + 1);
            } else {
                // 将数组还原
                nums[i] %= nums.length;
                if (nums[i] == 0) {
                    nums[i] = nums.length;
                }
            }
        }
        return result;
    }
}
