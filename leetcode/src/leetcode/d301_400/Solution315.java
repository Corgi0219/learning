package leetcode.d301_400;//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 示例: 
//
// 输入: [5,2,6,1]
//输出: [2,1,1,0] 
//解释:
//5 的右侧有 2 个更小的元素 (2 和 1).
//2 的右侧仅有 1 个更小的元素 (1).
//6 的右侧有 1 个更小的元素 (1).
//1 的右侧有 0 个更小的元素.
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 321 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution315 {
    /**
     * 暴力法 超时
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> counts = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            counts.add(0);
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] < nums[i]) {
                    counts.set(i, counts.get(i) + 1);
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        new Solution315().countSmaller(nums);
    }
}

class Solution315V1 {
    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        LinkedList<Integer> sortedList = new LinkedList<>();
        for (int i = 0; i < sorted.length; i++) {
            sortedList.add(sorted[i]);
        }
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            counts.add(findCount(nums[i], sortedList));
        }
        return counts;
    }

    private Integer findCount(int num, LinkedList<Integer> sortedList) {
        int start = 0, end = sortedList.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (sortedList.get(mid) >= num) end = mid - 1;
            if (sortedList.get(mid) < num) start = mid + 1;
        }
        if (sortedList.get(start) == num) {
            sortedList.remove(start);
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1};
        new Solution315V1().countSmaller(nums);
    }
}

class Solution315V2 {
    /**
     * 暴力法 超时
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> counts = new ArrayList<>();
        int[] temp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {

        }
        return counts;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        new Solution315V2().countSmaller(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
