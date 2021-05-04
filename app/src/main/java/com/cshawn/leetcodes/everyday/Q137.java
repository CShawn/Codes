package com.cshawn.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字II
 * 给你一个整数数组nums，除某个元素仅出现一次外，其余每个元素都恰出现三次。请你找出并返回那个只出现了一次的元素。
 * 
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * 
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * 
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @author C.Shawn
 * @date 2021/4/30 13:33
 */
class Q137 {
    // 方法1：散列表
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return 0;
    }
    
    // 方法2：位运算
    // 因为其他数字有3个，统计每个数位上的数，如果有3个相同数字，则数位上数的总和为3的倍数，多余的那个数会产生余数。
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 0;
	    	for (int num : nums) {
    	   	    bit += ((num >> i) & 1); 
        	}
            result |= ((bit % 3) << i) ;
        }
        return result;
    }
    
    // 方法3：数电
    // 对于每个数位最终的结果可以使用数电方式计算。
    // 形同方法2，统计每位bit和，对3取余为0，1，2三种状态，加上当前数字 后，结果也是这三种状态
    // 因此，输入为00,01,10,加上当前输入0,1,得到结果状态转移方程
    // 既然每个数位上的bit可以得出，那么将数字作为一个32位的输入，可以直接得出最终结果，而无需每次计算一位数据
    public int singleNumber3(int[] nums) {
	    int a = 0, b = 0;
        for (int num : nums) {
            int aNext = (~a & b & num) | (a & ~b & ~num);
            int bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }
    
    // 方法4：优化方法3，不统一计算，改为分别计算a,b
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}
