package com.cshawn.leetcodes.sword;

/**
 * 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 
 * 说明：用返回一个整数列表来代替打印; n 为正整数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @Date 2020/11/24 22:20
 */
public class Sword_17 {
    public String[] printNumbers(int n) {
        String[] result = new String[(int)Math.pow(10, n) - 1];
        // 将前个数放入数组
        for (int i = 0; i < 9; i++) {
            result[i] = String.valueOf(i + 1);
        }
        if (n == 1) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        // 遍历n-1位的全部数字，在其后拼接0-9依次放入数组后方
        for (int i = 0; i < (n - 1) * 10 - 1; i++) {
            for (int j = 0; j <= 9; j++) {
                // 拼接0-9，并放入数组后方
                result[(i + 1) * 10 -1 + j] = sb.append(result[i]).append(j).toString();
                sb.setLength(0);
            }
        }
        sb = null;
        return result;
    }
}
