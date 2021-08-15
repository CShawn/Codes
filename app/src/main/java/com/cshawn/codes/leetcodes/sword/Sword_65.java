package com.cshawn.codes.leetcodes.sword;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * 提示：a, b 均可能是负数或 0; 结果不会溢出 32 位整数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/27 9:07 下午
 */
public class Sword_65 {
    // 使用逻辑运算代替算术运算，类似于门电路计算
    public int add(int a, int b) {
        // 加：0+0=0,1+0=1,0+1=1,1+1=(1)0，可见，个位为异或，进位为两位同时为1
        // 各位累加使用逻辑或
        // 优先级：+,<<,&,^,|,|=
        int sum = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int ai = a & (1 << i);
            int bi = b & (1 << i);

//            //把进位当作1位bit位，使用时移位
//            sum |= ai ^ bi ^ (carry << i);
//            //进位为1：101,011,111,110即ab'c+a'bc+abc+abc'=a&b|c&(a^b)
//            carry = (ai & bi) >> i | (carry & (ai ^ bi) >> i);

            sum |= ai ^ bi ^ carry;
            //进位为1：101,011,111,110即ab'c+a'bc+abc+abc'=a&b|c&(a^b)
            // 实时更新进位所在位，即将carry左移1位
            carry = (ai & bi | (carry & (ai ^ bi))) << 1;
        }
        return sum;
    }

    // 方法2：直接将两个数按方法1逻辑运算，无需单独每位计算
    public int add2(int a, int b) {
        int c;
        while (b != 0) {
            // 计算进位
            c = (a & b) << 1;
            // 计算和，用a存储
            a = a ^ b;
            // 将进位赋值给b，再次循环将a,b相加
            b = c;
        }
        return a;
    }
}
