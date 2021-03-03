package leetcode.a1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution39V1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, int sum, List<Integer> temp, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                temp.add(candidates[i]);
                dfs(res, candidates, target, sum + candidates[i], temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution39V1().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}