package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 猜数字游戏
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 *
 * 示例 1:
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1807"
 *   |
 * "7810"
 *
 * 示例 2:
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
 *
 * 示例 3：
 * 输入：secret = "1", guess = "0"
 * 输出："0A0B"
 *
 * 示例 4：
 * 输入：secret = "1", guess = "1"
 * 输出："1A0B"
 *
 * 提示：
 * 1 <= secret.length, guess.length <= 1000
 * secret.length == guess.length
 * secret 和 guess 仅由数字组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulls-and-cows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/8 8:09 上午
 */
public class Q299 {
    // 哈希表
    public String getHint1(String secret, String guess) {
        Map<Character, Integer> s = new HashMap<>();
        Map<Character, Integer> g = new HashMap<>();
        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc == gc) {
                a++;
            } else {
                s.put(sc, s.getOrDefault(sc, 0) + 1);
                g.put(gc, g.getOrDefault(gc, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : g.entrySet()) {
            b += Math.min(entry.getValue(), s.getOrDefault(entry.getKey(), 0));
        }
        return a + "A" + b + "B";
    }

    // 数组模拟哈希表，因纯数字组成
    public String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc == gc) {
                a++;
            } else {
                s[sc - '0']++;
                g[gc - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(s[i], g[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a).append('A').append(b).append('B');
        return sb.toString();
    }
}
