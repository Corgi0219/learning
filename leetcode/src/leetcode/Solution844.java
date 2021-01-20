package leetcode;

import java.util.Stack;

/**
 * @author Chengliming
 * @create 2020-10-19 1:17 下午
 **/
public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!stack1.isEmpty()) stack1.pop();
            } else {
                stack1.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!stack2.isEmpty()) stack2.pop();
            } else {
                stack2.push(T.charAt(i));
            }
        }
        if (stack1.size() != stack2.size()) return false;
        while (!stack1.isEmpty()) {
            if (!stack1.pop().equals(stack2.pop())) return false;
        }
        return true;
    }
}
