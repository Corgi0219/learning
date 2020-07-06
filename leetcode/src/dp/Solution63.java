package dp;//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划


import java.lang.annotation.ElementType;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] ways = new int[obstacleGrid.length][obstacleGrid[0].length];
        ways[0][0] = 1;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) ways[0][i] = 0;
            else ways[0][i] = ways[0][i - 1] == 0 ? 0 : 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) ways[i][0] = 0;
            else ways[i][0] = ways[i - 1][0] == 0 ? 0 : 1;
        }


        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int k = 1; k < obstacleGrid[i].length; k++) {
                if (obstacleGrid[i][k] == 1) {
                    ways[i][k] = 0;
                } else {
                    ways[i][k] = ways[i - 1][k] + ways[i][k - 1];
                }
            }
        }
        return ways[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}};
        System.out.println(new Solution63().uniquePathsWithObstacles(a));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
