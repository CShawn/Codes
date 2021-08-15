package com.cshawn.codes.leetcodes.everyday;

/**
 * 情侣牵手
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 * 人和座位用0到2N-1的整数表示，情侣们按顺序编号，第一对是(0, 1)，第二对是(2, 3)，以此类推，最后一对是(2N-2, 2N-1)。
 * 这些情侣的初始座位row[i]是由最初始坐在第 i 个座位上的人决定的。
 *
 * 示例 1:
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 *
 * 示例 2:
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 *
 * 说明:
 * len(row) 是偶数且数值在[4, 60]范围内。
 * 可以保证row 是序列0...len(row)-1的一个全排列。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/14 11:26 上午
 */
public class Q765 {
    // 方法1：贪心算法，遍历并交换使两两匹配
    public int minSwapsCouples1(int[] row) {
        int i = 0, j, result = 0;
        while (i < row.length) {
            // j为i后的一个元素
            j = i + 1;
            // 两个匹配的数字异或为1
            if ((row[j] ^ row[i]) != 1) {
                // 查找与i匹配的数字j的位置
                while (j < row.length && (row[j] ^ row[i]) != 1) {
                    j++;
                }
                // i+1与j交换
                row[i + 1] ^= row[j];
                row[j] ^= row[i + 1];
                row[i + 1] ^= row[j];
                // 交换次数+1
                result++;
            }
            // 向后移动两位
            i += 2;
        }
        return result;
    }

    // 方法2：并查集
    // 假设有x对情侣坐错顺序，则需要交换x-1次
    // N对情侣中，坐错顺序的情侣可以分成多组，每组中的情侣相互坐错位置
    // 假设5对情侣分为两组，一组为3对坐错，一组为2对坐错，则需要交换2+1=3次
    // 将5对分为两个连通分量N1,N2，则N1+N2=N,(N1-1)+(N2-1)=N-2=总对数-组数
    // 扩展到多个分组同样符合规律，因此交换次数=总对数-坐错的分组数=交换之后的连通分量-交换之前的连通分量
    public int minSwapsCouples(int[] row) {
        UnionFind unionFind = new UnionFind(row.length / 2);
        for (int i = 0; i < row.length; i += 2) {
            // 匹配的两个数除2后相等，故将数字除2以获得连通分量
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return row.length / 2 - unionFind.getCount();
    }
}
