package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 森林中的兔子
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在answers数组里。
 * 返回森林中兔子的最少数量。
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * 说明:
 * answers的长度最大为1000。
 * answers[i]是在[0, 999]范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/4 10:22 上午
 */
public class Q781 {
    // 相同颜色的兔子答案是相同的。
    // 假设有x只兔子回答y，那么设这种颜色有y + 1只兔子，x中至少有x/(y+1)+(除不尽再加1，除尽不加1)种颜色，
    // 且每种颜色的兔子有y + 1只，则至少有((x/(y+1) + (x%(y+1)==0?0:1)))*(y+1)=(x+y)/(y+1)*(y+1)只兔子
    public int numRabbits(int[] answers) {
        // 1. 分别统计答案相同的兔子只数
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int result = 0;
        // 分别计算答案相同的兔子至少多少只
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += (entry.getValue() + entry.getKey()) / (entry.getKey() + 1) * (entry.getKey() + 1);
        }
        return result;
    }
}
