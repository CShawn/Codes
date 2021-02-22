package com.cshawn.leetcodes.crack;

/**
 * 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 *
 * 示例 2：
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/22 10:20 下午
 */
public class Q1_1 {
    // 统计字符出现次数，当个数大于1则不满足
    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        boolean[] aux = new boolean[128];
        for (int i = 0; i < astr.length(); i++) {
            if (aux[astr.charAt(i)]) {
                return false;
            } else {
                aux[astr.charAt(i)] = true;
            }
        }
        return true;
    }
}
