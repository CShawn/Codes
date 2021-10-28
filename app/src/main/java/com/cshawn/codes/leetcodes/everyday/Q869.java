package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * 重新排序得到 2 的幂
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入：1
 * 输出：true
 *
 * 示例 2：
 * 输入：10
 * 输出：false
 *
 * 示例 3：
 * 输入：16
 * 输出：true
 *
 * 示例 4：
 * 输入：24
 * 输出：false
 *
 * 示例 5：
 * 输入：46
 * 输出：true
 *
 * 提示：1 <= N <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/28 8:19 上午
 */
public class Q869 {
    // 全排列 + 判断2的幂
    public boolean reorderedPowerOf2_1(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        return backTracking(arr, 0, 0);
    }

    private boolean backTracking(char[] arr, int index, int num) {
        if (index == arr.length) {
            return (num & (num - 1)) == 0;
        }
        for (int i = index; i < arr.length; i++) {
            // 不能有前导零
            if ((num == 0 && arr[i] == '0') || (i != index && arr[i] == arr[i - 1])) {
                continue;
            }
            swap(arr, index, i);
            if (backTracking(arr, index + 1, num * 10 + arr[index] - '0')) {
                return true;
            }
            swap(arr, index, i);
        }
        return false;
    }

    private void swap(char[] arr, int a, int b) {
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    // 预处理 + 哈希表
    // 统计所有2的幂的对应数字出现次数
    public boolean reorderedPowerOf2(int n) {
        // 记录数字出现次数
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 31; i++) {
            set.add(countNum(1 << i));
        }
        // 判断n中各数字出现次数是否符合所有幂的出现次数
        return set.contains(countNum(n));
    }

    private String countNum(int n) {
        char[] arr = new char[10];
        Arrays.fill(arr, '0');
        while (n != 0) {
            arr[n % 10]++;
            n /= 10;
        }
        return new String(arr);
    }
}