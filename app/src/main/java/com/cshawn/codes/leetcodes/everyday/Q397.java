package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 * 示例 1：
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 *
 * 示例 3：
 * 输入：n = 4
 * 输出：2
 *  
 * 提示：
 * 1 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/19 5:31 下午
 */
public class Q397 {
    // 方法1：记忆化搜索
    Map<Integer, Integer> map = new HashMap<>();

    public int integerReplacement1(int n) {
        if (n == 1) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if ((n & 1) == 0) {
            return integerReplacement1(n >> 1) + 1;
        }
        int res = Math.min(integerReplacement1(n >> 1), integerReplacement1((n >> 1) + 1)) + 2;
        map.put(n, res);
        return res;
    }

    // 方法2：贪心
    // 奇数%4，结果为1或3，为尽量除2后还可以除2，应该使当前数字向除4能除尽的数字靠近
    // 因此结果为1则减1，结果为3则加1
    // 特殊的，数字为3时, 直接->2->1
    public int integerReplacement(int n) {
        int result = 0;
        while (n != 1) {
            int remainder = n % 4;
            if (remainder == 1) {
                result += 2;
                n >>= 1;
            } else if (remainder == 3) {
                if (n == 3) {
                    n >>= 1;
                } else {
                    n >>= 1;
                    n++;
                }
                result += 2;
            } else {
                result++;
                n >>= 1;
            }
        }
        return result;
    }
}