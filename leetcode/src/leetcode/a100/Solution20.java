package leetcode.a100;//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {
    public static boolean isValid(String s) {
        int index = 0;
        int length = s.length();
        while (!s.equals("") && index < length) {
            index++;
            for (int i = 0; i < s.length() - 1; i++) {
                char left = s.charAt(i);
                char right = s.charAt(i + 1);
                if (left == '(' && right == ')') {
                    s = s.replace("()", "");
                } else if (left == '{' && right == '}') {
                    s = s.replace("{}", "");
                } else if (left == '[' && right == ']') {
                    s = s.replace("[]", "");
                }
            }
        }
        return s.equals("");
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char right = s.charAt(i);
            if (stack.size() > 0) {
                char left = stack.peek();
                boolean yes = (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
                boolean no = (left == '(' && right != ')') || (left == '[' && right != ']') || (left == '{' && right == ')');
                if (no) break;
                if (yes) stack.pop();
                else stack.push(right);
            } else {
                stack.push(right);
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
//        System.out.println(isValid2("()[]{}"));
        System.out.println('(' + ')');
        System.out.println('[' + ']');
        System.out.println('{' + '}');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
