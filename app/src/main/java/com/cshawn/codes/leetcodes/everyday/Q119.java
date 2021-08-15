package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * @author C.Shawn
 * @date 2021/2/12 10:55 上午
 */
public class Q119 {
    public List<Integer> getRow(int rowIndex) {
        // 定义结果集合
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        // 数组更为方便
        int[] list = new int[rowIndex + 1];
        // 外循环为每一层的循环
        for (int i = 0; i <= rowIndex; i++) {
            // 将当前层的最后一个元素置为1
            list[i] = 1;
            // 求中位
            int half = i / 2;
            // 只用求一半值
            for (int j = 1; j <= half; j++) {
                // 因两侧对称，j和j-1两元素的和可以使用j和i-j相加
                list[j] = list[j] + list[i - j];
            }
            // 另一半直接取其对称位置的值
            for (int k = half + 1; k < i; k++) {
                list[k] = list[i - k];
            }
        }
        // 数组转为集合
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(list[i]);
        }
        return result;
    }
}
