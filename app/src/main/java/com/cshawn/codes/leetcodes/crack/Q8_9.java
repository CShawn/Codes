package com.cshawn.codes.leetcodes.crack;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号
 * 设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 说明：解集不能包含重复的子集。
 * 例如，给出n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/30 9:07 下午
 */
public class Q8_9 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        dfs(result, new char[n << 1], n, 0, 0, 0);
        return result;
    }

    /**
     * @param result 结果集
     * @param s 当前排列的字符串
     * @param n 括号对数
     * @param leftCount 当前已使用的左括号数量
     * @param rightCount 当前已使用的左括号数量
     * @param index 当前索引
     */
    private void dfs(List<String> result, char[] s, int n, int leftCount, int rightCount, int index) {
        if (index == s.length) {
            result.add(new String(s));
            return;
        }
        /*
        // 当左括号用完时，直接添加右括号
        if (leftCount == n) {
            s[index] = ')';
            rightCount++;
            dfs(result, s, n, leftCount, rightCount, index + 1);
        } else {
            // 回溯时有两个情况，'('或')'
            // 先使用'('
            s[index] = '(';
            leftCount++;
            dfs(result, s, n, leftCount, rightCount, index + 1);
            // 当前右括号数量小于左括号数量时，可以回溯使用右括号
            // 注意此时判断条件为leftCount - 1，即回溯前状态下的leftCount
            if (rightCount < leftCount - 1) {
                s[index] = ')';
                // 将leftCount还原
                leftCount--;
                rightCount++;
                dfs(result, s, n, leftCount, rightCount, index + 1);
                // 之后已经遍历了所有情况，无需回溯rightCount
            }
        }
        */
        // 以上代码合并为：
        if (leftCount == n || rightCount < leftCount) {
            s[index] = ')';
            dfs(result, s, n, leftCount, rightCount + 1, index + 1);
        }
        if (leftCount < n) {
            s[index] = '(';
            dfs(result, s, n, leftCount + 1, rightCount, index + 1);
        }
    }
}
