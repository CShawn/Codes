package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 适龄的朋友
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 * 示例 1：
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 *
 * 示例 2：
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 *
 * 示例 3：
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 *
 * 提示：
 * n == ages.length
 * 1 <= n <= 2 * 104
 * 1 <= ages[i] <= 120
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/27 9:06 上午
 */
public class Q825 {
    // 排序 + 双指针
    public int numFriendRequests1(int[] ages) {
        Arrays.sort(ages);
        // (0.5 * age[x] + 7) < ages[y] <= age[x]
        // 由此条件可知，x > 14
        // !(age[y] > 100 && age[x] < 100)
        int result = 0;
        int left = 0, right = 0;
        for (int age : ages) {
            if (age <= 14) {
                continue;
            }
            while (0.5 * age + 7 >= ages[left]) {
                left++;
            }
            while (right < ages.length && ages[right] <= age && !(ages[right] > 100 && age < 100)) {
                right++;
            }
            // right为范围外的元素，[left,right) 范围内个数为right - left，要去除age本身故减1
            result += right - left - 1;
        }
        return result;
    }

    // 方法2：计数排序 + 前缀和
    public int numFriendRequests(int[] ages) {
        int maxAge = 121;
        int[] counts = new int[maxAge];
        for (int age : ages) {
            counts[age]++;
        }
        int[] sum = new int[maxAge];
        for (int i = 1; i < maxAge; i++) {
            sum[i] = counts[i] + sum[i - 1];
        }
        int result = 0;
        for (int age = 15; age < maxAge; age++) {
            if (counts[age] > 0) {
                int left = (int) (0.5 * age + 8);
                // 同样减1为减去自身
                result += counts[age] * (sum[age] - sum[left - 1] - 1);
            }
        }
        return result;
    }
}