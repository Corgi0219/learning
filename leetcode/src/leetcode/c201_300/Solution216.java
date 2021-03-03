package leetcode.c201_300;//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 199 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution216 {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        dfs(1, new ArrayList<>(), k, n, 0);
        return res;
    }

    private void dfs(int index, ArrayList<Integer> list, int k, int n, int sum) {
        if (list.size() == k) {
            if (sum == n) res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (sum + i <= n) {
                list.add(i);
                dfs(i + 1, list, k, n, sum + i);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution216().combinationSum3(3, 9);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
