package leetcode.a1_100;//的三元组。
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    /**
     * 暴力法
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 1; k < nums.length; k++) {
                for (int j = k + 1; j < nums.length; j++) {
                    if (nums[i] + nums[k] + nums[j] == 0) {
                        result.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 三指针
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int k = i + 1, j = nums.length - 1; k < j; ) {
                int sum = nums[i] + nums[k] + nums[j];
                if (sum < 0) {
                    do {
                        k++;
                    } while (k < j && nums[k] == nums[k - 1]);
                } else if (sum > 0) {
                    do {
                        j--;
                    } while (k < j && nums[j] == nums[j + 1]);
                } else {
                    result.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    do {
                        k++;
                    } while (k < j && nums[k] == nums[k - 1]);
                    do {
                        j--;
                    } while (k < j && nums[j] == nums[j + 1]);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], nums[i]);
//        }
//
//        Set<List<Integer>> result = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            for (int k = i + 1; k < nums.length; k++) {
//                if (map.containsKey(-nums[i] - nums[k])) {
//                    List<Integer> list = Arrays.asList(nums[i], nums[k], map.get(-nums[i] - nums[k]));
//                    list.sort(Comparator.naturalOrder());
//                    result.add(list);
//                }
//            }
//        }
//        return new ArrayList<>(result);
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> hashMap = new HashMap<>(nums.length - i);
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = hashMap.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(nums[i], exist, nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    hashMap.put(nums[j], nums[j]);
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0};
//        int[] nums = new int[]{-2, -3, 0, 0, -2};
//        threeSum(nums);
//        threeSum2(nums);
        threeSum3(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
