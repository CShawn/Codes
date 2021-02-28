package com.cshawn.leetcodes.everyday;

/**
 * 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 *
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 *
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 *
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 *  
 * 提示：
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/28 10:31 上午
 */
public class Q896 {
    public boolean isMonotonic1(int[] A) {
        if (A.length == 0) {
            return false;
        }
        // 记录当前数组是升序(1)还是降序(2)
        int state = 0;
        for (int i = 0; i < A.length - 1; i++) {
            // 未初始化时先初始化升降序状态
            if (state == 0) {
                if (A[i] < A[i + 1]) {
                    state = 1;
                } else if (A[i] > A[i + 1]) {
                    state = 2;
                }
            } else {
                // 如果与记录的升降序不同，则不满足
                if (A[i] < A[i + 1] && state == 2) {
                    return false;
                } else if (A[i] > A[i + 1] && state == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isMonotonic(int[] A) {
        if (A.length == 0) {
            return false;
        }
        int up = 0, down = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                up++;
            } else if (A[i] > A[i + 1]) {
                down++;
            }
            if (up != 0 && down != 0) {
                return false;
            }
        }
        return true;
    }
}
