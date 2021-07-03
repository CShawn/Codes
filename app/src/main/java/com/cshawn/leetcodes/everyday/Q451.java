package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 示例 3:
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/3 11:02 上午
 */
public class Q451 {
    // Map + PriorityQueue
    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
        }
        char[] result = new char[s.length()];
        int i = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            Arrays.fill(result, i, i + map.get(c), c);
            i += map.get(c);
        }
        return new String(result);
    }

    // Map + List排序
    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        char[] result = new char[s.length()];
        int i = 0;
        for (Character c : list) {
            Arrays.fill(result, i, i + map.get(c), c);
            i += map.get(c);
        }
        return new String(result);
    }

    // 方法2：桶排序
    public String frequencySort3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }
        // 按照出现的频率划分桶
        StringBuilder[] buckets = new StringBuilder[max + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            StringBuilder sb = buckets[entry.getValue()];
            if (sb == null) {
                sb = new StringBuilder();
                buckets[entry.getValue()] = sb;
            }
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                result.append(buckets[i].toString());
            }
        }
        return result.toString();
    }

    // 快速排序 + 数组模拟Map
    public String frequencySort(String s) {
        int[] arr = new int[128];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c] == 0) {
                size++;
            }
            arr[c]++;
        }
        // 存储字符及出现的次数
        int[][] map = new int[size][2];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                map[index++] = new int[]{i, arr[i]};
            }
        }
        quickSort(map, 0, map.length - 1);
        char[] result = new char[s.length()];
        int i = 0;
        for (int[] m : map) {
            Arrays.fill(result, i, i + m[1], (char) m[0]);
            i += m[1];
        }
        return new String(result);
    }

    private void quickSort(int[][] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int i = lo + 1;
        int left = lo, right = hi;
        int v = arr[lo][1];
        while (i <= right) {
            if (arr[i][1] > v) {
                swap(arr, left++, i++);
            } else if (arr[i][1] < v) {
                swap(arr, i, right--);
            } else {
                i++;
            }
        }
        quickSort(arr, lo, left - 1);
        quickSort(arr, right + 1, hi);
    }

    private void swap(int[][] arr, int a, int b) {
        int[] t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}