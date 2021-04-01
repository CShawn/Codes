package com.cshawn.leetcodes.everyday;

/**
 * 笨阶乘
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * 另外，我们使用的除法是地板除法（floor division），所以10 * 9 / 8等于11。这保证结果是一个整数。
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 * 示例 1：
 * 输入：4
 * 输出：7
 * 解释：7 = 4 * 3 / 2 + 1
 *
 * 示例 2：
 * 输入：10
 * 输出：12
 * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *
 * 提示：
 * 1 <= N <= 10000
 * -2^31 <= answer <= 2^31 - 1 （答案保证符合 32 位整数。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/clumsy-factorial
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/1 8:46 上午
 */
public class Q1006 {
    public int clumsy1(int N) {
        if (N <= 1) {
            return N;
        }
        int pre = 0;
        int result = N;
        int num = result - 1;
        while (num > 0) {
            // 乘
            result *= num--;

            // 除
            if (num > 0) {
                result /= num--;
            } else {
                if (N - num != 2) {
                    // 当前是最后一个数时，计算前边遗留的减法
                    result = pre - result;
                }
                return result;
            }

            // 加
            if (num > 0) {
                // 当前不是第一个加号时，计算前边遗留的减法
                if (N - num != 3) {
                    result = pre - result;
                }
                result += num--;
            } else {
                if (N - num != 3) {
                    // 当前是最后一个数时，计算前边遗留的减法
                    result = pre - result;
                }
                return result;
            }

            // 减
            if (num > 0) {
                // 当为最后一个数字时，直接相减得到最终结果
                if (num == 1) {
                    result -= num--;
                } else {
                    // 记录减法之前的数值
                    pre = result;
                    // 将当前值放入result继续后续的计算
                    result = num--;
                }
            }
        }
        return result;
    }

    // 方法2：递归
    public int clumsy2(int N) {
        if (N == 0){
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        if (N == 3) {
            return 6;
        }
        return N * (N - 1) / (N - 2) + aux(N - 3);
    }

    private int aux(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2 || N == 3) {
            return 1;
        }
        return N - (N - 1) * (N - 2) / (N - 3) + aux(N - 4);
    }

    // 方法3：数学公式计算
    public int clumsy3(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }

    // 优化方法3
    public int clumsy(int N) {
        int[] num = {1, 2, 2, -1};
        return N > 4 ? N + num[N % 4] : (N > 2 ? N + 3 : N);
    }
}
