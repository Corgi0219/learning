package leetcode.h701_800;

class Solution724 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0 || nums.length == 2) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        }
        int left = 0, right = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (left == right) {
                return i;
            }
            left += nums[i];
            if (i != nums.length - 1) {
                right -= nums[i + 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution724().pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
    }
}