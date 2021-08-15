package com.cshawn.codes.leetcodes.sword;

/**
 * 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 提示：0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/17 2:15 下午
 */
public class Sword_46 {
    /**
     * 把数字字符串分成一个或两个字符，[0,25]可翻译，可以看作Sword_10_2的一个变种
     * 青蛙跳台阶，一次一个或两个。不同的是能不能跳两个台阶取决于这个两位数是否在[10,25]之间
     * 注意"09"以0开头不能满足条件
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        // 类似于斐波那契数列，两个数分别记录n-2和n-1
        int n_2 = 1, n_1 = 1;
        // 从第2位开始
        for (int i = 1; i < str.length(); i++) {
            boolean valid = str.charAt(i - 1) == '1' || (str.charAt(i - 1) == '2' && str.charAt(i) <= '5');
            // 判断<=25，则满足，正常值为n_2+n_1，不满足时，则无视n_2，等于n_1
            int count = valid ? n_1 + n_2 : n_1;
            // 更新n-2和n-1
            n_2 = n_1;
            n_1 = count;
        }
        return n_1;
    }

    /**
     * 鉴于方法1需要一个字符串的空间存储，所以按照数字依次取位的方式可以节约空间
     * 从后向前
     */
    public int translateNum2(int num) {
        int n_2 = 1, n_1 = 1;
        while (num != 0) {
            int sub = num % 10;
            num /= 10;
            int temp = num % 10 * 10 + sub;
            int count = temp >= 10 && temp <= 25 ? n_1 + n_2 : n_1;
            n_2 = n_1;
            n_1 = count;
        }
        return n_1;
    }
}
