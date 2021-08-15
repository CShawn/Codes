package com.cshawn.codes.leetcodes.sword;

/**
 * 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 *
 * 限制：0 <= n < 2^31
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/14 8:48 下午
 */
public class Sword_44 {

    /**
     * 1位数[0,9]共10(10-0)个，范围为[0,9(0+10*1-1)]
     * 2位数[10,99]共90(100-10)个，范围为[10,189(10+90*2-1)]
     * 3位数[100,999]共900(1000-100)个，范围为[190,1089(190+900*3-1)]
     * 那么，需要先定位第n位位于几位数区间内，再计算位于第几个数值范围内，再计算这个数值的第几位即可
     */
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        // 当前范围为几位数
        int len = 1;
        // 边界范围
        long left = 0, right = 9;
        // 当前范围的权值，也是len位数的最高位权值
        int pow = 1;
        // 不断扩大范围直到n位于[left, right]之中
        while (n > right) {
            // 当前范围内数值的位数
            len++;
            // 当前范围内数值的最高位权值
            pow *= 10;
            // 范围左边界向右移一位
            left = right + 1;
            // 右边界为当前位数数值的最大值，即下一个范围权值减1
            // 当前len位数所占的长度为个数乘以位数，
            // 个数为(len+1)位的数的最小值减去左边界
            // 右边界为左边界 + 长度 - 1
            right = left + (long) pow * 9 * len - 1;
        }
        // 目标所在的数值，如n=14,为数值12的1位置
        long num = (n - left) / len + pow;
        return getNumByPosition(num, (int) ((n - left) % len), len);
    }

    /**
     * 获取长度为len的数值n十进制的第position位上的数字，
     */
    private int getNumByPosition(long n, int position, int len) {
        // 也可以直接使用字符串方法获取
//        return String.valueOf(n).charAt(position) - '0';
        long pow = 1;
        for (int i = 1; i < len - position; i++) {
            pow *= 10;
        }
        return (int) (n / pow % 10);
    }

    /**
     * 方法2：方法1是累加式的，还可以考虑递减式方法
     * 同上，计算len位数的个数，将n不断减小
     */
    public int findNthDigit2(int n) {
        // 当前范围为几位数
        int len = 1;
        // 当前范围的权值
        long pow = 1;
        // len位数的个数，初始1位数有10个
        long count = 9;
        while (n > count) {
            n -= count;
            pow *= 10;
            len++;
            count = pow * 9 * len;
        }
        long num = (n - 1) / len + pow;
        return String.valueOf(num).charAt((n - 1) % len) - '0';
    }
}
