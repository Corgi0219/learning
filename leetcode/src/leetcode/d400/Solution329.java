package leetcode.d400;//给定一个整数矩阵，找出最长递增路径的长度。
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
//
// 示例 1:
//
// 输入: nums =
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//]
//输出: 4
//解释: 最长递增路径为 [1, 2, 6, 9]。
//
// 示例 2:
//
// 输入: nums =
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//]
//输出: 4
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
//
// Related Topics 深度优先搜索 拓扑排序 记忆化
// 👍 248 👎 0


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution329 {
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows = 0, cols = 0;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] mem = new int[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < cols; k++) {
                ans = Math.max(ans, dfs(matrix, i, k, mem));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int k, int[][] mem) {
        if (mem[i][k] != 0) return mem[i][k];
        mem[i][k]++;
        for (int[] dir : dirs) {
            int newRow = i + dir[0], newCol = k + dir[1];
            if (newRow >= 0 && newRow < rows
                    && newCol >= 0 && newCol < cols
                    && matrix[newRow][newCol] > matrix[i][k]) {
                mem[i][k] = Math.max(mem[i][k], dfs(matrix, newRow, newCol, mem) + 1);
            }
        }
        return mem[i][k];
    }

    public static void main(String[] args) {
//        int path = new Solution329().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
        int path = new Solution329().longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}});
        System.out.println(path);
    }
}

class Solution329V1 {
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows = 0, cols = 0;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        cols = matrix[0].length;
        int ans = 0;
        int[][] out = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < cols; k++) {
                for (int[] dir : dirs) {
                    int newRow = i + dir[0], newCol = k + dir[1];
                    if (newRow >= 0 && newRow < rows
                            && newCol >= 0 && newCol < cols
                            && matrix[newRow][newCol] < matrix[i][k]) {
                        out[i][k]++;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < out.length; i++) {
            for (int k = 0; k < out[i].length; k++) {
                if (out[i][k] == 0) queue.offer(new int[]{i, k});
            }
        }
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow >= 0 && newRow < rows
                            && newCol >= 0 && newCol < cols
                            && matrix[newRow][newCol] > matrix[row][col]) {
                        out[newRow][newCol]--;
                        if (out[newRow][newCol] == 0) queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int path = new Solution329V1().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
//        int path = new Solution329_1().longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}});
        System.out.println(path);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
