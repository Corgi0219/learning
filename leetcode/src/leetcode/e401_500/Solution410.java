package leetcode.e401_500;//给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
//
// 注意: 
//数组长度 n 满足以下条件: 
//
// 
// 1 ≤ n ≤ 1000 
// 1 ≤ m ≤ min(50, n) 
// 
//
// 示例: 
//
// 
//输入:
//nums = [7,2,5,10,8]
//m = 2
//
//输出:
//18
//
//解释:
//一共有四种方法将nums分割为2个子数组。
//其中最好的方式是将其分为[7,2,5] 和 [10,8]，
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
// 
// Related Topics 二分查找 动态规划 
// 👍 232 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution410 {
    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt(), right = Arrays.stream(nums).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int tempCount = 0, temp = 0;
            for (int num : nums) {
                temp += num;
                if (temp > mid) {
                    temp = num;
                    tempCount++;
                }
            }
            tempCount++;
            if (tempCount > m) left = mid + 1;
            else right = mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        new Solution410().splitArray(new int[]{5, 123}, 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
