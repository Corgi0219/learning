//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 示例 1: 
//s = "abc", t = "ahbgdc" 
//
// 返回 true. 
//
// 示例 2: 
//s = "axc", t = "ahbgdc" 
//
// 返回 false. 
//
// 后续挑战 : 
//
// 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码
//？ 
//
// 致谢: 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 249 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if ("".equals(s)) return true;
        if (s.length() == t.length()) return s.equals(t);
        int i = 0, k = 0;
        while (i < t.length()) {
            if (t.charAt(i) == s.charAt(k)) k++;
            if (k == s.length()) break;
            i++;
        }
        return k == s.length();
    }

    public boolean isSubsequence_1(String s, String t) {
        t = " " + t;
        int n = t.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < 26; i++) {
            int p = -1;
            for (int k = n - 1; k >= 0; k--) {
                dp[k][i] = p;
                if (t.charAt(k) == 'a' + i) p = k;
            }
        }

        // 匹配
        int i = 0;
        for (char ch : s.toCharArray()) {
            i = dp[i][ch - 'a'];
            if (i == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution392().isSubsequence_1("abgc", "ahbgdc"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
