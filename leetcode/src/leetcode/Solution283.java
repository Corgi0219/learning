package leetcode;

class Solution283 {
    public void moveZeroes(int[] nums) {
        int zero = 0, notZero = 1;
        while (true) {
            while (zero < nums.length && nums[zero] != 0) {
                zero++;
            }
            while (notZero < nums.length && (nums[notZero] == 0 || notZero <= zero)) {
                notZero++;
            }
            if (zero == nums.length || notZero == nums.length) {
                break;
            }
            swap(nums, zero, notZero);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        new Solution283().moveZeroes(ints);
        return;
    }
}