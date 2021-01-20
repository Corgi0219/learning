package leetcode.hashmap;
//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找 
// 👍 348 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int val = target - numbers[i];
            int idx = find(i, numbers, val);
            if (idx != -1) return new int[]{i + 1, idx + 1};
        }
        return null;
    }

    private int find(int i, int[] numbers, int val) {
        int start = 0, end = 0;
        if (val >= numbers[i]) {
            start = i + 1;
            end = numbers.length - 1;
        } else if (val < numbers[i]) {
            end = i - 1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (numbers[mid] == val) return mid;
            else if (numbers[mid] < val) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sum = new Solution167().twoSum(new int[]{0, 0, 3, 4}, 0);
        System.out.println(sum);
    }
}

class Solution167_1 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) left++;
            else if (sum > target) right--;
            else return new int[]{left+1, right+1};
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = new Solution167_1().twoSum(new int[]{0, 0, 3, 4}, 0);
        System.out.println(a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
