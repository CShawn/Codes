package com.cshawn.codes.leetcodes.everyday;

/**
 * 丑数 III
 * 给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第n个丑数。
 * 丑数是可以被a或b或 c整除的 正整数 。
 *
 * 示例 1：
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 *
 * 示例 2：
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
 *
 * 示例 3：
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 *
 * 示例 4：
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 *
 * 提示：
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * 本题结果在[1,2 * 10^9]的范围内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/9 5:18 下午
 */
public class Q1201 {
    // 方法1：模拟依次计算，超时
    public int nthUglyNumber1(int n, int a, int b, int c) {
        long ugly = -1;
        long na = 1, nb = 1, nc = 1;
        for (int i = 0; i < n; i++) {
            long ua = na * a;
            long ub = nb * b;
            long uc = nc * c;
            long min = Math.min(ua, Math.min(ub, uc));
            ugly = min;
            if (ua == min) {
                na++;
            }
            if (ub == min) {
                nb++;
            }
            if (uc == min) {
                nc++;
            }
        }
        return (int) ugly;
    }

    // 方法2：二分+周期
    // a,b,c的倍数以其最小公倍数为周期不断增加，第n个丑数应位于第x个周期内
    // 在一个周期内，可进行二分查找第n个丑数
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);
        long lcm = lcm(lcmAB, c);
        long period = lcm / a + lcm / b + lcm / c - lcm / lcmAB - lcm / lcmBC - lcm / lcmAC + 1;
        long remainder = n % period;
        if (remainder == 0) {
            return (int) (n / period * lcm);
        }
        long left = 1, right = lcm, mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            long count = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + mid / lcm;
            if (count >= remainder) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) (n / period * lcm + left);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        long greater = Math.max(a, b);
        long less = Math.min(a, b);
        long t;
        while (less != 0) {
            t = greater % less;
            greater = less;
            less = t;
        }
        return greater;
    }
}
