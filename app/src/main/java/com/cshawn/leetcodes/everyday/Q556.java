package com.cshawn.leetcodes.everyday;

/**
 * 下一个更大元素 III
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：21
 *
 * 示例 2：
 * 输入：n = 21
 * 输出：-1
 * 提示：1 <= n <= 231 - 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/6 9:45 下午
 */
public class Q556 {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        if (s.length() == 1) {
            return -1;
        }
        // 将数字转为数组
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
        }
        boolean find = false;
        // 由后向前遍历
        for (int i = arr.length - 1; i > 0; i--) {
            // 找到第一个后者比前者大的数
            if (arr[i] > arr[i - 1]) {
                find = true;
                // 再由后向前遍历，找到最后一个比i-1大的数
                for (int j = arr.length - 1; j >= i; j--) {
                    if (arr[j] > arr[i - 1]) {
                        // 将两个数交换位置
                        arr[i - 1] ^= arr[j];
                        arr[j] ^= arr[i - 1];
                        arr[i - 1] ^= arr[j];
                        break;
                    }
                }
                // 将i以后的数字反转
                int count = (arr.length - i) / 2;
                for (int k = 0; k < count; k++) {
                    arr[i + k] ^= arr[arr.length - 1 - k];
                    arr[arr.length - 1 - k] ^= arr[i + k];
                    arr[i + k] ^= arr[arr.length - 1 - k];
                }
                break;
            }
        }
        if (!find) {
            return -1;
        }
        // 校验是否大于int最大值
//        String max = String.valueOf(Integer.MAX_VALUE);
//        if (arr.length == max.length()) {
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] + '0' > max.charAt(i)) {
//                    return -1;
//                }
//            }
//        }
        // 重新计算数组里组成的数字
        int result = 0;
        for (int num : arr) {
            result = result * 10 + num;
        }
        return result <= n ? -1 : result;
    }
}
