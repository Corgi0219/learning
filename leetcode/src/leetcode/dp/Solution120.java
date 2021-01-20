package leetcode.dp;//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 460 👎 0


import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int col = triangle.get(triangle.size() - 1).size();
        int row = triangle.size();
        int[][] dp = new int[row + 1][col + 1];
        for (int[] ints : dp) Arrays.fill(ints, Integer.MAX_VALUE);
        for (int i = 0; i <= triangle.get(0).size(); i++) dp[0][i] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= triangle.size(); i++) {
            for (int k = 1; k <= triangle.get(i - 1).size(); k++) {
                dp[i][k] = triangle.get(i - 1).get(k - 1) + Math.min(dp[i - 1][k - 1], dp[i - 1][k]);
                if (i == triangle.size()) min = Math.min(dp[i][k], min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        System.out.println(new Solution120().minimumTotal(list));
    }
}

class Solution120_1 {
    /**
     * 自上而下动态规划优化空间：
     * 创建一个只有一行长度为N（三角形高度）的dp数组，使用三角形第一行初始化该数组，
     * 遍历每行，
     * 首先更新最后一个元素dp[N]=dp[N-1]+triangle[N][N]
     * 接着更新中间的dp元素，注意dp数组应该从后往前更新，因为相邻的定义是dp[i]和dp[i-1]，
     * 所以dp[i+1]的值更新完是不再需要使用的，也就不会影响后续的计算
     * 最后更新第一个元素dp[0]+=triangle[i][0]
     * 最后返回dp数组中的最小值即可
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[row];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int k = i - 1; k > 0; k--) {
                dp[k] = Math.min(dp[k - 1], dp[k]) + triangle.get(i).get(k);
            }
            dp[0] += triangle.get(i).get(0);
        }
        Arrays.sort(dp);
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        System.out.println(new Solution120_1().minimumTotal(list));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
