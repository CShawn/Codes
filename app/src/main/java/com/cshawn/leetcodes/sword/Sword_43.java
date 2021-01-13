package com.cshawn.leetcodes.sword;

/**
 * 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 * 限制：1 <= n <2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/12 10:01 下午
 */
public class Sword_43 {
    // 分别统计每个数位上的1出现的次数，相加即得结果
    public int countDigitOne(int n) {
        // 先转字符串求10进制数的位数
        String str = String.valueOf(n);
        int count = str.length();
        int sum = 0;
        for (int i = count - 1; i >= 0; i--) {
            // 当前位上的数字
            int current = str.charAt(count - 1 - i) - '0';
            // 当前位的权值
            int pow = pow(10, i);
            // 如：234的第2个位置上1出现个数为10~19,110~119,210~219共30个，即前半部分数值(2)+1=3,再乘以当前位置的权值10，
            // 同理最后一位上1的个数为前半部分(23)+1=24个1
            // 当前位数字为1时，当前位置出现1的次数还取决于当前位置后边的数值，
            // 如：218的第2位上1出现的个数为10~19，110~119，210~218共29个，即前半部分数值(2)*10=20，还要加上后半部分(8)+1=9共29个
            // 先计算当前位置前边的数值，n/pow/10，是否加1取决于当前位是否为1，代码实现上为直接+pow
            sum += n / pow / 10 * pow;
            if (current == 1) {
                // 计算后半部分数值+1
                sum += n % (pow * (n / pow)) + 1;
            } else if (current != 0) {
                sum += pow;
            }
            // 当前位数字为0时，不再计算后半部分
        }
        return sum;
    }

    /**
     * 求幂
     */
    private int pow(int n, int pow) {
        if (pow == 0) {
            return 1;
        }
        int b = pow;
        int x = n;
        int p = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                p *= x;
            }
            x *= x;
            b >>= 1;
        }
        return p;
    }
}
