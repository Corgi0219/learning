package leetcode.a1_100;

import java.util.ArrayList;
import java.util.List;

class Solution22V1 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, "", n, n, 0);
        return res;
    }

    public void dfs(List<String> res, int n, String str, int left, int right, int height) {
        if (str.length() == n * 2) {
            res.add(str);
        } else {
            if (left > right) {
                return;
            }
            if (left > 0) {
                dfs(res, n, str + "(", left - 1, right, height + 1);
            }
            if (right > 0) {
                dfs(res, n, str + ")", left, right - 1, height + 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution22V1().generateParenthesis(1);
    }
}