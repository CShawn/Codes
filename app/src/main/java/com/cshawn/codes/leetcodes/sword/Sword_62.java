package com.cshawn.codes.leetcodes.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 * 限制：1 <= n <= 10^5; 1 <= m <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/26 4:15 下午
 */
public class Sword_62 {
    public int lastRemaining(int n, int m) {
        List<Integer> remains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            remains.add(i);
        }
//        if (n == 1) {
//            return 0;
//        }
        // 先删除第一次找到的要删除的元素，但可以在remove方法中合并这几行代码
//        int removed = (m - 1) % n;
//        remains.remove(removed);
//        return remove(remains, n, m, removed);
        return remove(remains, n, m, 0);
    }

    private int remove(List<Integer> remains, int n, int m, int removed) {
        if (remains.size() == 1) {
            return remains.get(0);
        }
        // 要删除的元素下标
//        int index = (m - 1) % remains.size();
        // 删除removed后，其后剩余remains.size() - removed个元素
        // 小于剩余个数时，加上removed为新的要删除的元素下标；
        // 大于时，相当于将removed前的元素移到removed后边，计算得index + removed - remains.size()
//        index = index < remains.size() - removed ? index + removed : index + removed - remains.size();
        // 以上也就相当于简写为对remains.size()取余。再代入初始index值，简化为最后的式子为：
//        index = (index + removed) % remains.size() = (m + removed - 1) % remains.size();
        int index = (m + removed - 1) % remains.size();
        remains.remove(index);
        return remove(remains, n - 1, m, index);
    }

    // 第1个元素为m%n,第二个记为x=f(n-1,m)，则f(n,m)=(m%n+x)%n=(m+x)%n
    public int lastRemaining2(int n, int m) {
        return f(n, m);
    }

    private int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining3(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
