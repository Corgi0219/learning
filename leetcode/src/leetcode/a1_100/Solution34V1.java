package leetcode.a1_100;

import java.util.ArrayList;

class Solution34V1 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                int i = mid, k = mid;
                while (i >= 0 && nums[mid] == nums[i]) {
                    i--;
                }
                while (k < nums.length && nums[mid] == nums[k]) {
                    k++;
                }
                return new int[]{i + 1, k - 1};
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        new Solution34V1().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}