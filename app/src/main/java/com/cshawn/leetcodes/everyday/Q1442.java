package com.cshawn.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 形成两个异或相等数组的三元组数目
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * a 和 b 定义如下：
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 * 示例 1：
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 *
 * 示例 2：
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 *
 * 示例 3：
 * 输入：arr = [2,3]
 * 输出：0
 *
 * 示例 4：
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 *
 * 示例 5：
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 *
 * 提示：
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/18 5:44 下午
 */
public class Q1442 {
    // 异或前缀和, s[i]表示前i个数的异或和即[0,i-1]的异或和
    // 则s[i,j]=s[i]^s[j+1]，s[i,j)=s[i]^s[j]
    // 由s[i,j)=s[j,k)，可推出s[i]^s[j]=s[j]^s[k]，则s[i]=s[k]
    // 那么找到相等的s[i]和s[k]，在(i,k)之间的任意j都满足条件，个数为k-i-1,直接累加计数
    public int countTriplets1(int[] arr) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int result = 0;
        for (int i = 0; i < prefix.length; i++) {
            for (int k = i + 2; k < prefix.length; k++) {
                if (prefix[i] == prefix[k]) {
                    result += k - i - 1;
                }
            }
        }
        return result;
    }

    // 方法2：统计相同值出现的次数
    // 在方法1中，为计算方便，可使用相等的s[i]和s[k+1]，在(i,k]之间的任意j都满足条件，个数为k-i
    // 若i1,i2,i3...im皆满足s[i]=s[k+1]，那么累计数之和为(k-i1)+(k-i2)+...+(k-im)=k*m-(i1+i2+...+im)
    // 在遍历过程中统计相同数值出现的次数
    public int countTriplets2(int[] arr) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int result = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> total = new HashMap<>();
        for (int k = 0; k < arr.length; k++) {
            if (counts.containsKey(prefix[k + 1])) {
                result += k * counts.getOrDefault(prefix[k + 1], 0) - total.getOrDefault(prefix[k + 1], 0);
            }
            counts.put(prefix[k], counts.getOrDefault(prefix[k], 0) + 1);
            total.put(prefix[k], total.getOrDefault(prefix[k], 0) + k);
        }
        return result;
    }

    // 方法3：优化方法2
    public int countTriplets3(int[] arr) {
        int preXor = 0;
        int result = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> total = new HashMap<>();
        for (int k = 0; k < arr.length; k++) {
            if (counts.containsKey(preXor ^ arr[k])) {
                result += k * counts.getOrDefault(preXor ^ arr[k], 0) -
                        total.getOrDefault(preXor ^ arr[k], 0);
            }
            counts.put(preXor, counts.getOrDefault(preXor, 0) + 1);
            total.put(preXor, total.getOrDefault(preXor, 0) + k);
            preXor ^= arr[k];
        }
        return result;
    }

    // 方法4：直接异或
    public int countTriplets(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int k = i; k < arr.length; k++) {
                xor ^= arr[k];
                if (xor == 0) {
                    result += k - i;
                }
            }
        }
        return result;
    }
}
