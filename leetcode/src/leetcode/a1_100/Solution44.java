package leetcode.a1_100;//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution44 {
    // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配 (true 的话表示匹配)
    // 状态转移方程：
    //      1. 当 s[i] == p[j]，或者 p[j] == ? 那么 dp[i][j] = dp[i - 1][j - 1];
    //      注：为什么要看i-1和j-1的值呢，因为当前字符匹配了不代表前面的字符都匹配了，这里要捋清楚，只有i-1和k-1是true，当前位置才算匹配
    //      2. 当 p[j] == * 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j]
    //      其中：
    //      dp[i][j - 1] 表示 * 代表的是空字符，例如 ab, ab*
    //      dp[i - 1][j] 表示 * 代表的是非空字符，例如 abcd, ab*
    // 初始化：
    //      1. dp[0][0] 表示什么都没有，其值为 true
    //      2. 第一行 dp[0][j]，换句话说，s 为空，与 p 匹配，所以只要 p 开始为 * 才为 true
    //      3. 第一列 dp[i][0]，当然全部为 false
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        boolean[][] dp = new boolean[slen + 1][plen + 1];

        dp[0][0] = true;
        for (int i = 1; i <= plen; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= slen; i++) {
            for (int k = 1; k <= plen; k++) {
                if (s.charAt(i - 1) == p.charAt(k - 1) || p.charAt(k - 1) == '?') {
                    dp[i][k] = dp[i - 1][k - 1];
                }
                if (p.charAt(k - 1) == '*') {
                    dp[i][k] = dp[i][k - 1] || dp[i - 1][k];
                }
            }
        }
        return dp[slen][plen];
    }

    public static void main(String[] args) {
        System.out.println(new Solution44().isMatch("abcd", "ab?"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
