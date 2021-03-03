package leetcode.a1_100;

class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (target >= nums[left] && target <= nums[mid]) {
                right = mid - 1;
            } else if (target <= nums[right] && target >= nums[mid]) {
                left = mid + 1;
            } else if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else if (nums[right] > nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        new Solution33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        new Solution33().search(new int[]{3, 1}, 1);
    }
}