package leetcode.a1_100;//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//
// 示例 1: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出: false 
// Related Topics 字符串 动态规划 
// 👍 247 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution97 {
    /**
     * 动态规划的解决思路：
     * dp[i][j]表示s1的前i个字符加上s2的前j个字符是否跟s3的前i+j个字符匹配
     * 首先初始化dp[0][0]为true，代表空字符
     * 然后初始化dp[i][0] = dp[i-1][0] && s1[i-1] == s3[i-1],dp[i-1][0]代表s1的前i-1个字符是否能构成s3的前i-1个字符，
     * s1[i-1] == s3[i-1] 代表s1的第i个字符和s3的第i个字符是否一致，两个条件可以得出dp[i][0]
     * 接着初始化dp[0][i] = dp[0][i-1] && s2[i-1] == s3[i-1],dp[i-1][0]代表s2的前i-1个字符是否能构成s3的前i-1个字符，
     * s2[i-1] == s3[i-1] 代表s1的第i个字符和s3的第i个字符是否一致，两个条件可以得出dp[i][0]
     * <p>
     * 然后是dp[i][j] = (dp[i][j-1] && s2[j-1] == s3[i+j-1]) || (dp[i-1][j] && s1[i-1] == s3[i+j-1])
     * dp[i][j-1] && s2[j-1] == s3[i+j-1]：
     * 表示s1的前i个字符加上s2的前j-1个字符是否能构成s3的前i+j-1个字符
     * dp[i-1][j] && s1[i-1] == s3[i+j-1]：
     * 表示s1的前i-1个字符加上s2的前j个字符是否能构成s3的前i+j-1个字符
     * 上述两个条件之一成立即可
     * <p>
     * 最后返回dp数组最后一个元素
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        //  初始化dp数组
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution97().isInterleave("aabcc", "dbbca", "aabccdbbca"));
    }
}

class Solution97V1 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        HashMap<String, Boolean> mem = new HashMap<>();
        return dfs(s1, 0, s2, 0, s3, 0, mem);
    }

    private boolean dfs(String s1, int idx1, String s2, int idx2, String s3, int idx3, HashMap<String, Boolean> mem) {
        String key = idx1 + "-" + idx2;
        if (mem.containsKey(key)) return mem.get(key);

        if (idx1 == s1.length()) {
            while (idx2 < s2.length()) {
                if (s2.charAt(idx2) != s3.charAt(idx3)) {
                    mem.put(key, false);
                    return false;
                }
                idx2++;
                idx3++;
            }
            mem.put(key, true);
            return true;
        }

        if (idx2 == s2.length()) {
            while (idx1 < s1.length()) {
                if (s1.charAt(idx1) != s3.charAt(idx3)) {
                    mem.put(key, false);
                    return false;
                }
                idx1++;
                idx3++;
            }
            mem.put(key, true);
            return true;
        }

        if (s1.charAt(idx1) == s3.charAt(idx3)
                && dfs(s1, idx1 + 1, s2, idx2, s3, idx3 + 1, mem)) {
            mem.put(key, true);
            return true;
        }
        if (s2.charAt(idx2) == s3.charAt(idx3)
                && dfs(s1, idx1, s2, idx2 + 1, s3, idx3 + 1, mem)) {
            mem.put(key, true);
            return true;
        }
        mem.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution97V1().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
