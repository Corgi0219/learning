package leetcode;//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
// 注意： 
//
// 
// num1 和num2 的长度都小于 5100. 
// num1 和num2 都只包含数字 0-9. 
// num1 和num2 都不包含任何前导零。 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。 
// 
// Related Topics 字符串 
// 👍 211 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, k = num2.length() - 1, add = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || k >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = k >= 0 ? num2.charAt(k) - '0' : 0;
            int result = x + y + add;
            res.append(result % 10);
            add = result / 10;
            i--;
            k--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution415().addStrings("115", "116"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
