package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * @author C.Shawn
 * @date 2021/4/11 11:33 上午
 */
public class Q5729 {
    static class MKAverage {
        private final int[] nums;
        private final int[] temp;
        private int index = 0;
        private final int k;
        public MKAverage(int m, int k) {
            this.k = k;
            this.nums = new int[m];
            this.temp = new int[m];
        }

        public void addElement(int num) {
            nums[index++ % nums.length] = num;
        }

        public int calculateMKAverage() {
            if (index < nums.length) {
                return -1;
            }
            System.arraycopy(nums, 0, temp, 0, nums.length);
            Arrays.sort(temp);
            long sum = 0;
            for (int i = k; i < temp.length - k; i++) {
                sum += temp[i];
            }
            return (int) (sum / (temp.length - k - k));
        }
    }
}
