package leetcode.l_other;//哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’
//t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一
//本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。 
//
//
// 注意：本题相对原题稍作改动，只需返回未识别的字符数 
//
// 
//
// 示例： 
//
// 输入：
//dictionary = ["looked","just","like","her","brother"]
//sentence = "jesslookedjustliketimherbrother"
//输出： 7
//解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
// 
//
// 提示： 
//
// 
// 0 <= len(sentence) <= 1000 
// dictionary中总字符数不超过 150000。 
// 你可以认为dictionary和sentence中只包含小写字母。 
// 
// Related Topics 记忆化 字符串 
// 👍 119 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionInterview_17_13 {
    public int respace(String[] dictionary, String sentence) {
        if (sentence.equals("")) return 0;
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int k = 0; k < i; k++) {
                if (dict.contains(sentence.substring(k, i))) {
                    dp[i] = Math.min(dp[i], dp[k]);
                }
            }
        }
        return dp[sentence.length()];
    }

    public static void main(String[] args) {
        String[] dict = new String[]{"ab", "bc"};
        new SolutionInterview_17_13().respace(dict, "abced");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
