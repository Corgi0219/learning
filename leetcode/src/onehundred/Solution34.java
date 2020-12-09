package onehundred;

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int li = findLeft(nums, left, mid, target);
                int ri = findRight(nums, mid, right, target);
                return new int[]{li, ri};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private int findRight(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
                if (nums[left] != target) {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int findLeft(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] range = new Solution34().searchRange(new int[]{5, 7, 8, 8, 10}, 7);
        return;
    }
}