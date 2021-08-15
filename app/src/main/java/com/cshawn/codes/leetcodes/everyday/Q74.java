package com.cshawn.codes.leetcodes.everyday;

/**
 * 搜索二维矩阵
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/30 3:08 下午
 */
public class Q74 {
    // 将二维当作一维，二分查找
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return search(matrix, target, matrix[0].length, 0, matrix.length * matrix[0].length - 1);
    }

    private boolean search(int[][] matrix, int target, int cols, int left, int right) {
        if (left >= right) {
            return matrix[left / cols][left % cols] == target;
        }
        int mid = left + ((right - left) >> 1);
        // 对列数除得所在行号，取余得所在列号
        int item = matrix[mid / cols][mid % cols];
        if (item == target) {
            return true;
        }
        if (item > target) {
            return search(matrix, target, cols, left, mid - 1);
        } else {
            return search(matrix, target, cols, mid + 1, right);
        }
    }

    // 二分查找，循环不递归
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int left = 0, right = matrix.length * matrix[0].length - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            int item = matrix[mid / cols][mid % cols];
            if (item == target) {
                return true;
            }
            if (item > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
