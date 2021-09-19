package com.cshawn.codes.leetcodes.everyday;

/**
 * 只有两个键的键盘
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。
 *
 * 示例 1：
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：0
 *
 * 提示：1 <= n <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2-keys-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/19 1:32 下午
 */
public class Q650 {
    // 重点在于，要粘贴的个数是n的因子，才可以.
    // 另外，可数学推出，最终结果为n的所有质因子的和
    public int minSteps(int n) {
        int result = 0, copy = 0, count = 1;
        while (count < n) {
            // 当前已有count个，n能除尽，则可以复制当前所有，进行一次粘贴
            if (n % count == 0) {
                copy = count;
                result++;
            }
            count += copy;
            result++;
        }
        return result;
    }
}
