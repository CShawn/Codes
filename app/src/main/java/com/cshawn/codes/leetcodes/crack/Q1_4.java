package com.cshawn.codes.leetcodes.crack;

/**
 * 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 *
 * 示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/23 5:26 下午
 */
public class Q1_4 {
    // 将相同字符出现偶数次则抵消，奇数次则剩余，最终剩余的字符为0个或1个
    public boolean canPermutePalindrome1(String s) {
        if (s == null) {
            return false;
        }
        boolean[] aux = new boolean[128];
        // 标识最终剩余一个字符
        boolean flag = false;
        // 遍历并将字符出现相抵消，奇数次则为true
        for (int i = 0; i < s.length(); i++) {
            aux[s.charAt(i)] = !aux[s.charAt(i)];
        }
        for (boolean b : aux) {
            // 已出现过一次某元素，再次出现一个不同的字符，则不回文
            if (b && flag) {
                return false;
            }
            // 出现一个字符则将flag置为true
            if (b) {
                flag = true;
            }
        }
        return true;
    }

    // 当只包括英文时，可以使用一个int以bit位表示出现次数
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }
        int aux = 0;
        for (int i = 0; i < s.length(); i++) {
            // 将每个英文字符转换成左移x位的bit位
            aux ^= 1 << s.charAt(i) - 'a';
        }
        // 最终结果为0或2的n次幂
        return aux == 0 || (aux & aux - 1) == 0;
    }
}
