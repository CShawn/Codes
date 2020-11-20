package com.cshawn.leetcodes.sword;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * 
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/20 10:54
 */
public class Sword_11 {
    /** 
     * 可见最简单的就是直接遍历，查找最小值，那出这题就没有意义了
     * 由题中“递增排序的数组的一个旋转”可知，可以使用二分查找，特殊之处在于旋转。
     * 
     * 一个正常的递增序列，是旋转0个元素的结果，那么最小值就是首元素；
     * 其他情况下，数组被分成两半，两部分都是递增序列，后半部分的最后一个元素小于等于前半部分第一个元素。
     * 
     * 二分查找时，需判断目标值处于哪半部分。
     * 1. 当所查找的值小于当前值，则接下来的查找区间变为(首元素, 当前值)
     * 2. 当所查找的值大于当前值，则接下来的查找区间变为(当前值, 尾元素)
     * 3. 当所查找的值等于当前值，此时，最小值可以位于前半部分，也有可能位于后半部分，需要求查找两部分最小值，再求两者中最小者。
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        return minArray(numbers, 0, numbers.length - 1);
    }

    public int minArray(int[] numbers, int left, int right) {
        // 当首元素小于尾元素，为正常递增，直接返回首元素
        if (numbers[left] < numbers[right]) {
            return numbers[left];
        }
        // 将初始最小值设为尾元素
        int min = numbers[right];
        // 定义当前查找位置
        int n;
        // 当left和right差值为1，即要查找的范围内只有两个元素时，min已赋值为两者中较小的那个，直接返回即可。
        while (right - left > 1) {
            // 取中值
            n = (left + right) / 2;
            if (numbers[n] < min) {
                // 向左部分查找
                right = n;
                // 最小值更新为较小者
                min = numbers[n];
            } else if (numbers[n] > min) {
                // 向右部分查找
                left = n;
            } else {
                // 查找值与当前最小值相等时，需要查找两部分
//                int minLeft = minArray(numbers, left, n);
//                int minRight = minArray(numbers, n + 1, right);
//                min = Math.min(minLeft, minRight);
//                break;

                // 将最右侧数据剔除，继续查找
                int temp = Math.min(numbers[++left], numbers[--right]);
                min = Math.min(temp, min);
            }
        }
        return min;
    }
}
