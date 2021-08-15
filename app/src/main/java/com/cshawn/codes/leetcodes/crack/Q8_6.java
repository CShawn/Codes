package com.cshawn.codes.leetcodes.crack;

import java.util.List;

/**
 * 汉诺塔问题
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * 你需要原地修改栈。
 * 示例1:
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 *
 * 示例2:
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 * 提示:A中盘子的数目不大于14个。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/28 8:01 下午
 */
public class Q8_6 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A, B, C, A.size());
    }

    // 将A中的n个元素经B移动到C中
    private void move(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        // 将A中的n-1个元素经C移动到B中
        move(A, C, B, n - 1);
        // 将A中最后一个元素直接移动到C中
        C.add(A.remove(A.size() - 1));
        // 将B中的n-1个元素经A移动到C中
        move(B, A, C, n - 1);
    }
}
