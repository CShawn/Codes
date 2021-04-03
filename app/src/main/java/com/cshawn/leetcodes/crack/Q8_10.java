package com.cshawn.leetcodes.crack;

/**
 * 颜色填充
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 *
 * 示例：
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]] 
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释: 
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 * 提示：
 * image 和image[0]的长度均在范围[1, 50] 内。
 * 初始坐标点 (sr,sc) 满足0 <= sr < image.length 和0 <= sc < image[0].length 。
 * image[i][j] 和newColor表示的颜色值在范围[0, 65535] 内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/color-fill-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/3 10:21 下午
 */
public class Q8_10 {
    // 深度优先遍历
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        // 越界，或当前位置的颜色与当前选取的颜色不同，或当前位置的颜色与新颜色相同，直接返回
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || oldColor != image[sr][sc] || newColor == image[sr][sc]) {
            return;
        }
        // 修改当前位置颜色
        image[sr][sc] = newColor;
        // 向上下左右遍历
        fill(image, sr - 1, sc, oldColor, newColor);
        fill(image, sr + 1, sc, oldColor, newColor);
        fill(image, sr, sc - 1, oldColor, newColor);
        fill(image, sr, sc + 1, oldColor, newColor);
    }
}
