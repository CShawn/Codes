package com.cshawn.leetcodes.everyday;

import java.util.LinkedList;
import java.util.List;

/**
 * 二进制手表
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * 例如，下面的二进制手表读取 "3:25" 。
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * 小时不会以零开头：
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 *
 * 示例 1：
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 *
 * 示例 2：
 * 输入：turnedOn = 9
 * 输出：[]
 *
 * 提示：0 <= turnedOn <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/21 5:40 下午
 */
public class Q401 {
    // 方法1：遍历所有可能
    public List<String> readBinaryWatch1(int turnedOn) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    result.add(i + ":" + (j < 10 ? "0" : "") + j);
                }
            }
        }
        return result;
    }

    // 方法2：回溯法
    private int[] minutes = new int[]{1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new LinkedList<>();
        int min = turnedOn > 6 ? turnedOn - 6 : 0;
        int max = Math.min(4, turnedOn);
        LinkedList<Integer>[] temp = new LinkedList[7];
        for (int i = min; i < temp.length; i++) {
            // i + 1 个1组成的数字
            temp[i] = new LinkedList<>();
            backTracking(temp[i], i, 0, 0, 0);
        }
        for (int i = min; i <= max; i++) {
            for (Integer hour : temp[i]) {
                if (hour < 12) {
                    for (Integer minute: temp[turnedOn - i]) {
                        if (minute < 60) {
                            if (minute < 10) {
                                result.add(hour + ":0" + minute);
                            } else {
                                result.add(hour + ":" + minute);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private void backTracking(List<Integer> result, int count, int index, int preCount, int pre) {
        if (preCount == count) {
            result.add(pre);
            return;
        }
        for (int i = index; i < minutes.length; i++) {
            backTracking(result, count, i + 1, preCount + 1, pre + minutes[i]);
        }
    }
}
