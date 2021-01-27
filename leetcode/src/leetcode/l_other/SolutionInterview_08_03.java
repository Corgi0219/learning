package leetcode.l_other;//魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找
//出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。 
//
// 示例1: 
//
//  输入：nums = [0, 2, 3, 4, 5]
// 输出：0
// 说明: 0下标的元素为0
// 
//
// 示例2: 
//
//  输入：nums = [1, 1, 1]
// 输出：1
// 
//
// 提示: 
//
// 
// nums长度在[1, 1000000]之间 
// 
// Related Topics 数组 二分查找 
// 👍 34 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SolutionInterview_08_03 {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) return i;
        }
        return -1;
    }
}

class SolutionInterview_08_03V1 {
    public int findMagicIndex(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index) return index;
            else if (nums[index] > index) index = nums[index];
            else index++;
        }
        return -1;
    }
}

class SolutionInterview_08_03V2 {
    public int findMagicIndex(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        int i = dfs(nums, lo, hi);
        if (i > -1) {
            return i;
        } else if (nums[mid] == mid) {
            return mid;
        } else {
            return dfs(nums, mid + 1, hi);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolutionInterview_08_03V2().findMagicIndex(new int[]{1, 1, 2, 3, 3}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
