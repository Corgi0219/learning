package leetcode;//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 176 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution491 {
    List<List<Integer>> list = new ArrayList<>();
    Set<String> set = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            dfs(nums, i, new ArrayList<>());
        }
        return list;
    }

    private void dfs(int[] nums, int idx, List<Integer> ints) {
        ints.add(nums[idx]);
        if (ints.size() > 1 && !set.contains(ints.toString())) {
            list.add(ints);
            set.add(ints.toString());
        }
        if (idx == nums.length - 1) return;

        for (int i = idx + 1; i < nums.length; i++) {
            dfs(nums, i, new ArrayList<>(ints));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution491().findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(list.get(0).toString());
    }

}
//leetcode submit region end(Prohibit modification and deletion)
