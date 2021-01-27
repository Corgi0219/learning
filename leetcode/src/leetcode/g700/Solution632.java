package leetcode.g700;//你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
//
// 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。 
//
// 示例 1: 
//
// 
//输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//输出: [20,24]
//解释: 
//列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
//列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
//列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
// 
//
// 注意: 
//
// 
// 给定的列表可能包含重复元素，所以在这里升序表示 >= 。 
// 1 <= k <= 3500 
// -105 <= 元素的值 <= 105 
// 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。 
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 152 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int len = 0;
        for (List<Integer> num : nums) {
            len += num.size();
        }
        int index = 0;
        int[][] ordered = new int[len][2];
        for (int i = 0; i < nums.size(); i++) {
            for (Integer number : nums.get(i)) {
                ordered[index][0] = number;
                ordered[index][1] = i;
                index++;
            }
        }
        Arrays.sort(ordered, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[2];
        int[] count = new int[nums.size()];
        int k = 0, i = 0;
        for (int j = 0; j < len; j++) {
            if (0 == count[ordered[j][1]]++) k++;
            if (k == nums.size()) {
                while (count[ordered[i][1]] > 1) count[ordered[i++][1]]--;
                if ((ans[0] == 0 && ans[1] == 0) || ans[1] - ans[0] > ordered[j][0] - ordered[i][0]) {
                    ans = new int[]{ordered[i][0], ordered[j][0]};
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(4, 10, 15, 24, 26)));
        list.add(new ArrayList<>(Arrays.asList(0, 9, 12, 20)));
        list.add(new ArrayList<>(Arrays.asList(5, 18, 22, 30)));
        new Solution632().smallestRange(list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
