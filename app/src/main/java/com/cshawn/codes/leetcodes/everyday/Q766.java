package com.cshawn.codes.leetcodes.everyday;

/**
 * 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * 示例1：
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 *
 * 示例2：
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：对角线 "[1, 2]" 上的元素不同。
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 *
 * 进阶：
 * 1. 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * 2. 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/22 9:21 上午
 */
public class Q766 {
    // 1. 遍历，与左上角元素不同则直接返回false
    // 2. 只能加载1行，则存储1行元素，从第2行按行遍历，与存储的行左上角进行比较，结束后更新存储的元素。可从后向前遍历，比较并更新存储的元素
    // 3. 加载不到1行，则需要分区比较，从情形2可知，可以一行行遍历比较，
    // 那么，不足1行时，可初始化一个x*y的矩阵，且x*y<=容量，[0]~[x-1]，[0]~[y-1]，
    // 接下来从[x-1]~[2x-2],[0]~[y-1]和[0]~[x-1],[y-1]~[2y-2]开始，有一条边重合
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
