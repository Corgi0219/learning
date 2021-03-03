package leetcode.a1_100;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(res, nums, new ArrayList<>(), used);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] used) {
        if (nums.length == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(res, nums, temp, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        new Solution46().permute(new int[]{1, 2, 3});
    }
}