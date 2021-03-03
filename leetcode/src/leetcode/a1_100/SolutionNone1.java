package leetcode.a1_100;//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 187 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionNone1 {
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] != nums[i + 1]) {
                res[index] = nums[i];
                index++;
            } else if (i == nums.length - 1 && nums[i] != nums[i - 1]) {
                res[index] = nums[i];
                index++;
            } else if (i != 0 && i != nums.length - 1 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                res[index] = nums[i];
                index++;
            }
        }
        return res;
    }

    public int[] singleNumbers1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int t = 1, a = 0, b = 0;
        while ((t & res) == 0) t <<= 1;
        for (int num : nums) {
            if ((num & t) == 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        System.out.println(new SolutionNone1().singleNumbers1(new int[]{1, 2, 2, 3}));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
