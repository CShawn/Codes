package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 原子的数量
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * 两个化学式连在一起是新的化学式。例如H2O2He3Mg4 也是化学式。
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 给定一个化学式，输出所有原子的数量。
 * 格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 示例 1:
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 *
 * 示例 2:
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 *
 * 示例 3:
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 *
 * 注意:
 * 所有原子的第一个字母为大写，剩余字母都是小写。
 * formula的长度在[1, 1000]之间。
 * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-atoms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/5 2:00 下午
 */
public class Q726 {
    // 栈+TreeMap
    public String countOfAtoms(String formula) {
        // 每层括号放入一个Map<String, Integer>
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        // 根放入一个TreeMap，用于按字母顺序排序
        stack.push(new TreeMap<>());
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (c == '(') {
                // 其他层放入HashMap即可
                stack.push(new HashMap<>());
            } else if (c == ')') {
                int begin = ++i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = begin == i ? 1 : Integer.parseInt(formula.substring(begin, i));
                i--;
                // 当前层的map
                Map<String, Integer> map = stack.pop();
                // 上一层的map
                Map<String, Integer> root = stack.peek();
                // 将当括号内的数据乘以外层数字，并放入上一层的map中
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    root.put(entry.getKey(), root.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
                }
            } else {
                // 解析当前的元素及个数并放入当前层的map中
                int begin = i++;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(begin, i);
                begin = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                Map<String, Integer> map = stack.peek();
                int count = begin == i ? 1 : Integer.parseInt(formula.substring(begin, i));
                i--;
                map.put(element, map.getOrDefault(element, 0) + count);
            }
        }
        // 最终结果只剩最后一层map，且TreeMap按字母排序
        Map<String, Integer> map = stack.pop();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() != 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}
