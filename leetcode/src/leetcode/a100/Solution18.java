package leetcode.a100;//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 590 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution18 {
    private List<List<Integer>> res;
    private int target;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        this.target = target;
        helper(nums, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int index, int target, List<Integer> list) {
        if (list.size() == 4) {
            if (target == this.target) res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums.length - i < 4 - list.size()) return;
            if (i > index && nums[i] == nums[i - 1]) continue;
            if (i < nums.length - 1 && target + nums[i] + (3 - list.size()) * nums[i + 1] > this.target) return;
            if (i < nums.length - 1 && target + nums[i] + (3 - list.size()) * nums[nums.length - 1] < this.target)
                continue;
            list.add(nums[i]);
            helper(nums, i + 1, target + nums[i], list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution18().fourSum(new int[]{-2,-1,-1,1,1,2,2
        }, 0);
    }
}


class Solution18V1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length < 4) return res;
        Arrays.sort(nums);

        for (int i = 0; i < length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) continue;
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            for (int k = i + 1; k < length - 2; k++) {
                if (k > i + 1 && nums[k] == nums[k - 1]) continue;
                if (nums[i] + nums[k] + nums[k + 1] + nums[k + 2] > target) break;
                if (nums[i] + nums[k] + nums[length - 1] + nums[length - 2] < target) continue;
                int left = k + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[k] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[k], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution18V1().fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
