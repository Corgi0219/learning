package leetcode.d400;
//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//
// 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 lef
//t 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划 
// 👍 401 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution312 {
    private static int maxCoin = 0;

    public int maxCoins(int[] nums) {
        helper(nums, 0, nums.length, 0);
        return maxCoin;
    }

    private void helper(int[] nums, int level, int length, int tempCoin) {
        if (level == length) {
            maxCoin = Math.max(tempCoin, maxCoin);
            return;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] == -1) continue;
            int temp = nums[i];
            nums[i] = -1;
            int leftIndex = i - 1, leftCoin = 0;
            while (leftIndex >= 0 && nums[leftIndex] == -1) leftIndex--;
            if (leftIndex < 0) leftCoin = 1;
            else leftCoin = nums[leftIndex];

            int rightIndex = i + 1, rightCoin = 0;
            while (rightIndex < length && nums[rightIndex] == -1) rightIndex++;
            if (rightIndex == length) rightCoin = 1;
            else rightCoin = nums[rightIndex];

            int current = temp * leftCoin * rightCoin;
            helper(nums, level + 1, length, tempCoin + current);
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int i = new Solution312().maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(i);
    }
}

class Solution312_1 {
    public int maxCoins(int[] nums) {
        int[] nums1 = new int[nums.length + 2];
        System.arraycopy(nums, 0, nums1, 1, nums.length);
        nums1[0] = 1;
        nums1[nums1.length - 1] = 1;
        int[][] cache = new int[nums1.length][nums1.length];
        return helper(nums1, 0, nums1.length - 1, cache);
    }

    private int helper(int[] nums1, int start, int end, int[][] cache) {
        int max = 0;
        if (start == end - 1) return max;
        if (cache[start][end] != 0) return cache[start][end];
        for (int i = start + 1; i < end; i++) {
            int temp = helper(nums1, start, i, cache) +
                    helper(nums1, i, end, cache) +
                    nums1[start] * nums1[i] * nums1[end];
            max = Math.max(temp, max);
        }
        cache[start][end] = max;
        return max;
    }

    public static void main(String[] args) {
        int i = new Solution312_1().maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
