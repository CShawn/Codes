package com.cshawn.leetcodes.everyday;

/**
 * 所有数对按位与结果的异或和
 * 列表的 异或和（XOR sum）指对所有元素进行按位 XOR 运算的结果。如果列表中仅有一个元素，那么其 异或和 就等于该元素。
 * 例如，[1,2,3,4] 的 异或和 等于 1 XOR 2 XOR 3 XOR 4 = 4 ，而 [3] 的 异或和 等于 3 。
 * 给你两个下标 从 0 开始 计数的数组 arr1 和 arr2 ，两数组均由非负整数组成。
 * 根据每个(i, j) 数对，构造一个由 arr1[i] AND arr2[j]（按位 AND 运算）结果组成的列表。
 * 其中 0 <= i < arr1.length 且 0 <= j < arr2.length 。返回上述列表的 异或和 。
 *
 * 示例 1：
 * 输入：arr1 = [1,2,3], arr2 = [6,5]
 * 输出：0
 * 解释：列表 = [1 AND 6, 1 AND 5, 2 AND 6, 2 AND 5, 3 AND 6, 3 AND 5] = [0,1,2,0,2,1] ，
 * 异或和 = 0 XOR 1 XOR 2 XOR 0 XOR 2 XOR 1 = 0 。
 *
 * 示例 2：
 * 输入：arr1 = [12], arr2 = [4]
 * 输出：4
 * 解释：列表 = [12 AND 4] = [4] ，异或和 = 4 。
 * 提示：
 * 1 <= arr1.length, arr2.length <= 105
 * 0 <= arr1[i], arr2[j] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-xor-sum-of-all-pairs-bitwise-and
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/19 10:13 下午
 */
public class Q5737 {
    // 对于任意位上的数值
    // 异或时当有奇数个1时，结果为1，否则为0; 那么就需要相与的结果中有奇数个1
    // 相与为1需要两数都为1，设两个数组共有m,n个1，那么共有m*n个组合，需要其值为奇数，那么m,n都要为奇数
    // 至此，只要统计每个数位上1的个数奇偶性即可
    public int getXORSum(int[] arr1, int[] arr2) {
        int result = 0;
        // 依次计算每位上的异或和
        for (int i = 0; i < 32; i++) {
            // 统计arr1中该位上1的个数
            int m = 0;
            for (int x : arr1) {
                if(((x >> i) & 1) == 1) {
                    m++;
                }
            }
            // 统计arr2中该位上1的个数
            int n = 0;
            for (int y : arr2) {
                if(((y >> i) & 1) == 1) {
                    n++;
                }
            }
            // 两者都为奇数时，结果为1，计入result
            if ((m & 1) == 1 && (n & 1) == 1) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
