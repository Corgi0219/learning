package dp;//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 576 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int[] ints : dp) Arrays.fill(ints, Integer.MAX_VALUE);
        dp[0][1] = 0;
        dp[1][0] = 0;

        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[grid.length][grid[0].length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}

class Solution64_1 {
    public int minPathSum(int[][] grid) {
        int[][] mem = new int[grid.length][grid[0].length];
        for (int[] ints : mem) Arrays.fill(ints, -1);
        return helper(grid, 0, 0, mem);
    }

    private int helper(int[][] grid, int row, int col, int[][] mem) {
        if (row == grid.length || col == grid[0].length) return Integer.MAX_VALUE;
        if (mem[row][col] != -1) return mem[row][col];
        if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];

        int right = helper(grid, row, col + 1, mem);
        int down = helper(grid, row + 1, col, mem);
        mem[row][col] = Math.min(right, down) + grid[row][col];
        return mem[row][col];
    }

    public static void main(String[] args) {
        System.out.println(new Solution64_1().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
