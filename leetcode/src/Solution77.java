//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 373 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution77 {
    private boolean[][] path;
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        path = new boolean[n + 1][n + 1];
        res = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        dfs(1, n, k, list);
        return res;
    }

    private void dfs(int index, int n, int k, ArrayList<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

//        for (int i = index; i <= n; i++) {
//            list.add(i);
//            dfs(i + 1, n, k, list);
//            list.remove(list.size() - 1);
//        }
        //  剪枝
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            dfs(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution77().combine(4, 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
