package com.cshawn.leetcodes.crack;

/**
 * 整数转换
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * 示例1:
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 *
 * 示例2:
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:A，B范围在[-2147483648, 2147483647]之间
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-integer-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/18 10:34 下午
 */
public class Q5_6 {
    // 异或，统计1的个数
    public int convertInteger1(int A, int B) {
        int diff = A ^ B;
        int count = 0;
        while (diff != 0) {
            if ((diff & 1) == 1) {
                count++;
            }
            diff = diff >>> 1;
        }
        return count;
    }

    // 优化方法1
    public int convertInteger(int A, int B) {
        int diff = A ^ B;
        int count = 0;
        while(diff != 0){
            count++;
            // 一次消除后边的所有0
            diff &= (diff - 1);
        }
        return count;
    }
}
