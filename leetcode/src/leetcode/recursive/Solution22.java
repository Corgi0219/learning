package leetcode.recursive;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return null;
    }

    private void _generate(int left, int right, int max, String s) {
        //  退出条件
        if (left == max && right == max) {
            res.add(s);
            System.out.println(s);
            return;
        }
        //  逻辑
        //  下沉
        if (left < max)
            _generate(left + 1, right, max, s + "(");
        if (right < left)
            _generate(left, right + 1, max, s + ")");
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        solution22.generateParenthesis(3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
