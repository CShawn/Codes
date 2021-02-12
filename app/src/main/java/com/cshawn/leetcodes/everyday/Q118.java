package com.cshawn.leetcodes.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/12 12:35 下午
 */
public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        // 定义结果集合
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows <= 0) {
            return result;
        }
        List<Integer> first = new ArrayList<>(1);
        first.add(1);
        result.add(first);
        // 外循环为每一层的循环
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            // 将当前层的第一个元素置为1
            list.add(1);
            // 求中位
            int half = i / 2;
            List<Integer> pre = result.get(i - 1);
            // 只用求一半值
            for (int j = 1; j <= half; j++) {
                // 当前元素为上一层元素j和j-1两元素的和
                list.add(pre.get(j) + pre.get(j - 1));
            }
            // 另一半直接取其对称位置的值
            for (int k = half + 1; k <= i; k++) {
                list.add(list.get(i - k));
            }
            result.add(list);
        }
        return result;
    }
}
