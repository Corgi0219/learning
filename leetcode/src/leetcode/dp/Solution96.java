package leetcode.dp;//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 676 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution96 {
    /**
     * 动态规划：以g(n)表示当有n个节点时，生成二叉搜索树的总数量
     * f(i)表示以i为根时，生成二叉搜索树的数量，则g(n) = f(1) + f(2) + ... + f(n)
     * 以i为根时，左子树会有i-1个节点，右子树会有n-i个节点，则f(i) = g(i-1) * g(n-i)
     * 则g(n) = g(0) * g (n-1) + g(1) * g(n-2) + ... + g(n-1) * g(0)
     * 此公式又称卡特兰数
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int k = 1; k < i + 1; k++) {
                dp[i] += dp[k - 1] * dp[i - k];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Solution96().numTrees(4);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
