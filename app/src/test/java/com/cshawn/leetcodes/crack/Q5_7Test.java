package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 配对交换
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * 示例1:
 *  输入：num = 2（或者0b10）
 *  输出 1 (或者 0b01)
 *
 * 示例2:
 *  输入：num = 3
 *  输出：3
 * 提示:num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exchange-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/18 10:45 下午
 */
class Q5_7Test {

    @ParameterizedTest
    @CsvSource({"42453,23274", "0,0", "2,1", "7,11", "3,3"})
    void exchangeBits(int n, int result) {
        Assertions.assertEquals(result, new Q5_7().exchangeBits(n));
    }
}