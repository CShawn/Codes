package com.cshawn.codes.leetcodes.everyday;

/**
 * 灯泡开关
 * 初始时有n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。
 * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 * 找出并返回 n轮后有多少个亮着的灯泡。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 * 你应该返回 1，因为只有一个灯泡还亮着。
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：1
 *
 * 提示：0 <= n <= 109
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulb-switcher
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/15 8:27 上午
 */
public class Q319 {
    // 题意可知，求数字1~n的因子个数的奇偶性
    // 考虑每个数的因子个数什么时侯为奇什么时侯为偶
    // 一般的，成对出现都是偶数个，只有平方数的平方根因为两因子相等才为奇数个
    // 奇数个因子最后都会亮灯，因此题意为求n内平方数的个数
    // 设最大的平方数为k，则k*k<=x, k<=√x
    // 为防止精度丢失（如：结果为3时，可能得到2.99999，取整会成为2），加0.5保证得到正确值
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }
}