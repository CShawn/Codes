package com.cshawn.leetcodes.sword;

/**
 * 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：2 <= n <= 58
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/23 18:38
 */
public class Sword_14 {
    /**
     * 1. 暴力法，计算所有剪法，求最大值
     * 2. 暴力过程中会发现：分成2段时只能遍历全部；
     *      分成3段时可看作先分出第1段，然后再将剩余的分成2段，分出第1段后，剩余的与分成两段相同；
     *      分成4段时可看作先分出第1段，然后再将剩余的分成3段...
     * 显然递归，而可优化处在于，分段时不必从1遍历到最后，因为过半后会重复，所以只用遍历到1/n即可。
     * 3. 进一步，分3段时，可看作先分第1段，剩余的看作一个整体去求最大值；那么分4段时也可以看作这种情况；
     *    不过，这里的整体是指长度为x的绳子可以得到的最大积
     * 因此，f(n)=max(f(1)*f(n-1), f(2)*f(n-2),..., f((n+1)/2)*f((n-1)/2))
     * 那么可以自底向上保存已求过的数据以进行进一步优化
     */
    public int cuttingRope(int n) {
        int[] temp = new int[n + 1];
//        return cutting(n, temp);
        // 修改如下后，可见temp相当于dp数组，此解法为动态归划
        temp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 只用遍历到一半位置
            for (int j = 1; j <= i / 2; j++) {
                // j为前半段的长度，计算j的最大剪切积和剩余段的最大剪切积，再相乘
                int num = Math.max(j, temp[j]) * Math.max(i - j, temp[i - j]);
                // 将temp[i]更新为最大值
                temp[i] = Math.max(num, temp[i]);
            }
        }
        return temp[n];
    }

    // 这种方法有待改进，定义的temp并不需要每次传入，因为是自底向上，所以直接从temp获取时一定有值
    private int cutting(int n, int[] temp) {
        if (n == 1) {
            return 1;
        }
        if (temp[n] != 0) {
            return temp[n];
        }
        for (int i = 2; i <= n; i++) {
            // 只用遍历到一半位置
            for (int j = 1; j <= (i + 1) / 2; j++) {
                // j为前半段的长度，计算j的最大剪切积和剩余段的最大剪切积，再相乘
                int num = Math.max(j, cutting(j, temp)) * Math.max(i - j, cutting(i - j, temp));
                // 将temp[i]更新为最大值
                temp[i] = Math.max(num, temp[i]);
            }
        }
        return temp[n];
    }
}
