package com.cshawn.codes.leetcodes.sword;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4] 
 * 注：[3,1,2,4] 也是正确的答案之一。
 * 提示：
 *     1 <= nums.length <= 50000
 *     1 <= nums[i] <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @Date 2020/11/28 20:11
 */
public class Sword_21 {
    public int[] exchange(int[] nums) {
        /* 笨办法：
        if (nums.length == 0) {
            return nums;
        }
        // 用队列存储偶数的索引
        Queue<Integer> evenIndexes = new LinkedList<>();
        // 用栈存储奇数的索引
        Stack<Integer> oddIndexes = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // 将偶数的索引放入队列
                evenIndexes.offer(i);
            } else {
                // 将奇数的索引放入栈
                oddIndexes.push(i);
            }
        }
        Integer evenIndex = evenIndexes.poll();
        Integer oddIndex = null;
        if (!oddIndexes.isEmpty()) {
            oddIndex = oddIndexes.pop();
        }
        while (evenIndex != null && oddIndex != null) {
            if (evenIndex < oddIndex) {
                // 取出最靠前的偶数与最靠后的奇数交换
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
                evenIndex = evenIndexes.poll();
            }
            if (!oddIndexes.isEmpty()) {
                oddIndex = oddIndexes.pop();
            } else {
                oddIndex = null;
            }
        }
        */
        // 其实不用存储那么多数据，使用双指针，“最靠前的偶数与最靠后的奇数交换”即可
        /*
        int right = nums.length - 1;
        for (int left = 0; left < nums.length; left++) {
            // 找到最前的偶数，判断奇偶数可以使用位运算优化
            if ((nums[left] & 1) == 0) {
                // 查找最后的奇数
                while ((nums[right] & 1) == 0) {
                    // 最后的奇数在最前的偶数之前，直接返回
                    if (right <= left) {
                        return nums;
                    }
                    right--;
                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        */
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            boolean leftEven = (nums[left] & 1) == 0;
            boolean rightOdd = (nums[right] & 1) == 1;
            if (leftEven && rightOdd) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else {
                // 左奇时需向右移动
                if (!leftEven) {
                    left++;
                }
                // 右偶时需向左移动
                if (!rightOdd) {
                    right--;
                }
            }
        }
        return nums;
    }
}
