package com.cshawn.leetcodes.everyday;

/**
 * 132模式
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列ai, aj, ak被定义为：当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * 注意：n 的值小于15000。
 * 示例1:
 * 输入: [1, 2, 3, 4]
 * 输出: False
 * 解释: 序列中不存在132模式的子序列。
 *
 * 示例 2:
 * 输入: [3, 1, 4, 2]
 * 输出: True
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 *
 * 示例 3:
 * 输入: [-1, 3, 2, 0]
 * 输出: True
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/24 8:38 上午
 */
public class Q456 {
    // 注意题意为子序列，不是必须连续。单调栈
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        // 存储当前元素左侧最小的数字
        int[] mins = new int[nums.length];
        mins[0] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i - 1]);
        }
        // 数组实现单调递减栈
        int[] stack = new int[nums.length];
        int top = -1;
        // 倒序查找位于min[i]和nums[i]之间的数字
        for (int i = nums.length - 1; i >= 0; i--) {
            while (top >= 0) {
                if (stack[top] < nums[i] && stack[top] > mins[i]) {
                    // 栈顶元素比当前元素小且比当前元素前最小的元素大，满足条件
                    return true;
                } else if (stack[top] > nums[i]) {
                    // 当前元素比栈顶元素小，则入栈
                    stack[++top] = nums[i];
                    break;
                } else {
                    // 栈顶元素比当前元素前的所有元素都小，那么栈顶的元素废弃无用，出栈
                    top--;
                }
            }
            // 栈为空，直接入栈
            if (top < 0) {
                stack[++top] = nums[i];
            }
        }
        return false;
    }

//    public boolean find132pattern2(int[] nums) {
//        int len=nums.length;
//        if(len<3) return false;
//        Stack<Integer> st=new Stack<>();
//        int K=-1;
//        for (int I = len - 1; I >= 0; I--) {
//            if (K > -1 && nums[K] > nums[I]) {
//                return true;
//            }
//            while (!st.isEmpty() && nums[st.peek()] < nums[I]) {
//                K = st.pop();
//            }
//            st.push(I);
//        }
//        return false;
//    }
}
