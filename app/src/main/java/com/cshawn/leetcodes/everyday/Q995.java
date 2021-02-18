package com.cshawn.leetcodes.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * K 连续位的最小翻转次数
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 *
 * 示例 1：
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 *
 * 示例 2：
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 *
 * 示例 3：
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]:A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]:A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]:A变成 [1,1,1,1,1,1,1,1]
 *
 * 提示：
 * 1 <= A.length <=30000
 * 1 <= K <= A.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/18 10:47 下午
 */
public class Q995 {
    // 方法1：遍历，遇到0则反转k个元素。超时
    public int minKBitFlips1(int[] A, int K) {
        int result = 0;
        for (int i = 0; i < A.length - K + 1; i++) {
            // 找到一个0，
            if (A[i] == 0) {
                // 从当前的0开始k个反转
                for (int j = 0; j < K; j++) {
                    if (i + j >= A.length) {
                        // 如果范围越界则不可完全反转
                        return -1;
                    }
                    // 反转元素
                    A[i + j] ^= 1;
                }
                // 计数
                result++;
            }
        }
        // 判断是否全为1
        for (int a : A) {
            if (a == 0) {
                return -1;
            }
        }
        return result;
    }

    // 方法2：滑动窗口
    // 一个0要反转则要反转其后的k-1个，如果某个1被反转为0还需要再反转回来
    // 如此需要记录某位置上元素被反转的次数：
    // 找到第一个0，接下来的K-1个元素要反转1次，如果原数为1，则还要再反转一次。
    // 用队列记录下第一个发生反转的位置
    // 判断当前位置与反转次数，0&偶数次，1&奇数次，需要再次反转
    // 超过K个后，记录的位置移出队首
    public int minKBitFlips(int[] A, int K) {
        int result = 0;
        // 队列用于记录某位置上元素被反转的次数
        Queue<Integer> flips = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            // 当前位置超出首个反转位置到其+k的范围时，反转位置的影响范围失效，弹出队首元素
            if (!flips.isEmpty() && i >= flips.peek() + K) {
                flips.poll();
            }
            // 元素为0且反转偶数次，元素为1且反转奇数次
            if ((flips.size() & 1) == A[i]) {
                // 越界则不可完全反转
                if (i + K > A.length) {
                    return -1;
                }
                // 将当前要反转的元素位置加入队列
                flips.offer(i);
                result++;
            }
        }
        return result;
    }
}
