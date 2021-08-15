package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 *
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/12 16:30
 */
public class Q179 {
    public String largestNumber1(int[] nums) {
        // 将原数组转为字符串数组
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i] + "";
        }
        // 判断字符串 o1+o2和o2+o1两种拼接方式哪个数字更大，降序排列
        Arrays.sort(array, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        // 按顺序排列拼接即可
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        String result = sb.toString();
        return result.charAt(0) == '0' ? "0" : result;
    }

    // 方法2：优化方法1，手动实现快速排序
    public String largestNumber(int[] nums) {
        // 将原数组转为字符串数组
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i] + "";
        }
        // 判断字符串 o1+o2和o2+o1两种拼接方式哪个数字更大，降序排列
        quickSort(array, 0, array.length - 1);
        // 按顺序排列拼接即可
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        String result = sb.toString();
        return result.charAt(0) == '0' ? "0" : result;
    }

    // 降序排列拼接的字符串
    private void quickSort(String[] array, int lo, int hi) {
        if (hi - lo < 8) {
            insertSort(array, lo, hi);
        } else {
            int position = partition(array, lo, hi);
            quickSort(array, lo, position - 1);
            quickSort(array, position + 1, hi);
        }
    }

    private int partition(String[] array, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (!less(array, ++i, lo)) {
                if (i == hi) {
                    break;
                }
            }
            while (!less(array, lo, --j)) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, lo, j);
        return j;
    }

    // 插入排序
    private void insertSort(String[] array, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && !less(array, j, j - 1); j--) {
                swap(array, j - 1, j);
            }
        }
    }

    private boolean less(String[] array, int a, int b) {
        return (array[a] + array[b]).compareTo(array[b] + array[a]) < 0;
    }

    private void swap(String[] array, int a, int b) {
        String temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
