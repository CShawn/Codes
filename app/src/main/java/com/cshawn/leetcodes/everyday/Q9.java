package com.cshawn.leetcodes.everyday;

/**
 * 回文数
 * @author C.Shawn
 * @date 2021/2/15 10:00 下午
 */
public class Q9 {
    // 反转数字，与原数字相等则为回文，但可能数字过大而越界
    // 可以反转一半。从后向前反转数字同时将原数字缩短，原数字<=反转数字则反转了一半
    public boolean isPalindrome(int x) {
        // 负数不回文。非0数个位为0则不回文
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            // 反转数字
            reverse = reverse * 10 + x % 10;
            // 删除当前数字的最后一位
            x /= 10;
        }
        // 偶数位时，两数相等。奇数位时，反转数字删除最后一位数字会与缩短后的原数字相等
        return x == reverse || x == reverse / 10;
    }
}
