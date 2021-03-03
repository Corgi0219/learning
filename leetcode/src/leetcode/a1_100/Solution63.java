package leetcode.a1_100;//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution63 {
    /**
     * 动态规划解决
     * 先说思路，每个格子只能从上方或者左侧走过来，那么到达每个格子的路径树就等于上方和左侧格子路径数的和，由此可以知道DP数组中存储的是从起点到达每个格子的
     * 路径总和，当方格为障碍物时，则当前格子直接置为0，因为没有路径可以到达，有个特殊情况，即起点为障碍物，那么直接返回0。
     * 首先初始化DP数组，第一行和第一列的情况相同，当前面有障碍物时，障碍物以及后方的格子只能为0，因为无法通行。
     * 然后遍历每个方格，当方格不是障碍物时，dp[i][k] = dp[i-1][k] + dp[i][k-1]，当方格是障碍物，直接为0，
     * 最后返回dp数组的最后一个元素即可
     * @param obstacleGrid
     * @return
     */
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
