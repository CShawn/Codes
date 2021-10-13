package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果n是3的倍数，输出“Fizz”；
 * 2. 如果n是5的倍数，输出“Buzz”；
 * 3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 * n = 15,
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/13 9:56 上午
 */
public class Q412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        int three = 1, five = 1;
        for (int i = 1; i <= n; i++) {
            if (three == 3 && five == 5) {
                result.add("FizzBuzz");
                three = 1;
                five = 1;
                continue;
            }
            if (three == 3) {
                result.add("Fizz");
                three = 1;
                five++;
                continue;
            }
            if (five == 5) {
                result.add("Buzz");
                three++;
                five = 1;
                continue;
            }
            result.add(String.valueOf(i));
            three++;
            five++;
        }
        return result;
    }
}
