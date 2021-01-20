package leetcode.onehundred;//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 358 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution60 {
    private int n;
    private int k;
    private int[] factorial;
    private boolean[] used;


    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        this.used = new boolean[n + 1];
        Arrays.fill(used, false);
        calcFactorial(n);
        StringBuilder builder = new StringBuilder();
        dfs(0, builder);
        return builder.toString();
    }

    private void dfs(int level, StringBuilder builder) {
        if (level == n) return;

        int cnt = factorial[n - 1 - level];
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            used[i] = true;
            builder.append(i);
            dfs(level + 1, builder);
            return;
        }
    }


    private void calcFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution60().getPermutation(9, 4));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
