package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * 示例 2:
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 *
 * 示例 3:
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 *
 * 示例 4:
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *
 * 提示：
 * 1 <=deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/25 7:40 下午
 */
public class Q752 {
    // 方法1：广度优先遍历
    public int openLock1(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        Set<String> checked = new HashSet<>();
        checked.add("0000");
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if (dead.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                for (String s : getNext1(queue.poll())) {
                    if (!checked.contains(s) && !dead.contains(s)) {
                        if (s.equals(target)) {
                            return step;
                        }
                        queue.offer(s);
                        checked.add(s);
                    }
                }
            }
        }
        return -1;
    }

    private String[] getNext1(String s) {
        char[] arr = s.toCharArray();
        String[] result = new String[8];
        for (int i = 0; i < 4; i++) {
            char[] temp = new char[4];
            System.arraycopy(arr, 0, temp, 0, 4);
            if (arr[i] == '0') {
                temp[i] = '1';
                result[i << 1] = new String(temp);
                temp[i] = '9';
                result[(i << 1) + 1] = new String(temp);
            } else if (arr[i] == '9') {
                temp[i] = '0';
                result[i << 1] = new String(temp);
                temp[i] = '8';
                result[(i << 1) + 1] = new String(temp);
            } else {
                temp[i]++;
                result[i << 1] = new String(temp);
                temp[i]--;
                temp[i]--;
                result[(i << 1) + 1] = new String(temp);
            }
        }
        return result;
    }

    // 方法2：A*算法
    public int openLock2(String[] deadends, String target) {
        String init = "0000";
        if (init.equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains("0000")) {
            return -1;
        }
        PriorityQueue<AStar> pq = new PriorityQueue<>((o1, o2) -> o1.f - o2.f);
        pq.offer(new AStar(init, target, 0));
        Set<String> seen = new HashSet<>();
        seen.add(init);
        while (!pq.isEmpty()) {
            AStar a = pq.poll();
            for (String next : getNext(a.status)) {
                if (!dead.contains(next) && !seen.contains(next)) {
                    if (target.equals(next)) {
                        return a.g + 1;
                    }
                    pq.offer(new AStar(next, target, a.g + 1));
                    seen.add(next);
                }
            }
        }
        return -1;
    }

    private List<String> getNext(String status) {
        List<String> list = new LinkedList<>();
        char[] arr = status.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = pre(c);
            list.add(new String(arr));
            arr[i] = next(c);
            list.add(new String(arr));
            arr[i] = c;
        }
        return list;
    }

    private char pre(char c) {
        return c == '0' ? '9' : (char)(c - 1);
    }

    private char next(char c) {
        return c == '9' ? '0' : (char)(c + 1);
    }

    // 方法3：双向BFS
    public int openLock3(String[] deadends, String target) {
        String init = "0000";
        if (init.equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains(init)) {
            return -1;
        }
        Queue<String> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        // 记录状态是经过多少次转换而来
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        q1.offer(init);
        q2.offer(target);
        m1.put(init, 0);
        m2.put(target, 0);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int t = q1.size() < q2.size() ? update(q1, dead, m1, m2) : update(q2, dead, m2, m1);
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }

    private int update(Queue<String> queue, Set<String> dead, Map<String, Integer> cur, Map<String, Integer> other) {
        String status = queue.poll();
        int step = cur.get(status);
        for (String s : getNext(status)) {
            if (!cur.containsKey(s) && !dead.contains(s)) {
                if (other.containsKey(s)) {
                    return step + other.get(s) + 1;
                } else {
                    queue.offer(s);
                    cur.put(s, step + 1);
                }
            }
        }
        return -1;
    }

    // 方法4：IDA*
    public int openLock(String[] deadends, String target) {
        String init = "0000";
        if (init.equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains(init)) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < target.length(); i++) {
            int diff = target.charAt(i) - '0';
            max += Math.max(diff, 10 - diff);
        }
        // 记录当前状态的深度，即步数
        Map<String, Integer> map = new HashMap<>();
        map.put(init, 0);
        // 当前最大遍历的深度
        int depth = 0;
        // 不断扩大遍历深度，尝试以较小的深度得到结果
        // IDA*不存储已遍历过的状态，存在重复遍历
        // while (depth <= max && !dfs(0, depth, init, target, dead, map)) {
        // 可以优化最小的遍历深度
        depth = getF(init, target);
        while (depth <= max && !dfs(0, depth, init, target, dead, map)) {
            map.clear();
            map.put(init, 0);
            depth++;
        }
        return depth > max ? -1 : depth;
    }

    private boolean dfs(int depth, int max, String cur, String target, Set<String> dead, Map<String, Integer> map) {
        if (depth + getF(cur, target) > max) {
            return false;
        }
        if (getF(cur, target) == 0) {
            return true;
        }
        for (String next : getNext(cur)) {
            if (!dead.contains(next) && (!map.containsKey(next) || map.get(next) > depth + 1)) {
                map.put(next, depth + 1);
                if (dfs(depth + 1, max, next, target, dead, map)) {
                    return true;
                }
            }
        } 
        return false;
    }

    private int getF(String cur, String target) {
        int f = 0;
        for (int i = 0; i < target.length(); i++) {
            int a = cur.charAt(i) - '0';
            int b = target.charAt(i) - '0';
            int diff = Math.abs(a - b);
            f += Math.min(diff, 10 - diff);
        }
        return f;
    }
}

class AStar {
    String status;
    int f, g, h;
    public AStar(String status, String target, int g) {
        this.status = status;
        this.g = g;
        this.h = getH(status, target);
        this.f = this.g + this.h;
    }

    public int getH(String status, String target) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int distance = Math.abs(status.charAt(i) - target.charAt(i));
            res += Math.min(distance, 10 - distance);
        }
        return res;
    }
}
