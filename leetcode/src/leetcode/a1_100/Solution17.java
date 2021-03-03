package leetcode.a1_100;

import java.util.ArrayList;
import java.util.List;

class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        String[] dic = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(dic, res, digits, new StringBuffer(), digits.length());
        return res;
    }

    private void dfs(String[] dic, List<String> res, String digits, StringBuffer str, int length) {
        if (str.length() == length) {
            res.add(str.toString());
        } else {
            char[] chars = dic[digits.charAt(0) - '2'].toCharArray();
            for (char c : chars) {
                dfs(dic, res, digits.substring(1), str.append(c), length);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution17().letterCombinations("234");
    }
}