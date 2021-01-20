package leetcode.recursive;//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 暴力法 超时
 */
class Solution32_1 {
    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int k = i + 2; k <= s.length(); k += 2) {
                if (isValid(s.substring(i, k))) {
                    max = Math.max(max, k - i);
                }
            }
        }
        return max;
    }

    private boolean isValid(String substring) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '(') {
                stack.push("(");
            } else if (!stack.isEmpty() && stack.peek().equals("(")) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution32_1().longestValidParentheses("()"));
    }
}

/**
 * 暴力法的优化
 * 计算字符串每个位置各自的有效括号的长度，然后返回最长的即可
 * 遇见左括号+1，遇见右括号-1，一直循环到字符串末尾或者遇见count=0，则说明已经到了有效括号的尽头，更新最大值
 * count < 0说明已经不合法，直接break，但是count=0不能说明有效括号已经结束，因为可能是()()这样的。
 */
class Solution32_2 {
    public int longestValidParentheses(String s) {
        int max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = 0;
            for (int k = i; k < s.length(); k++) {
                if (s.charAt(k) == '(') count++;
                else count--;
                if (count < 0) break;
                if (count == 0) max = Math.max(max, k - i + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution32_2().longestValidParentheses("()"));
    }
}

class Solution32_3 {
    public int longestValidParentheses(String s) {
        int max = 0, count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution32_3().longestValidParentheses("()(()"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
