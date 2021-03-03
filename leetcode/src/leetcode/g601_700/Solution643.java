package leetcode.g601_700;

class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = k - 1;
        double res, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res = sum / k;

        for (int i = k; i < nums.length; i++, left++) {
            sum -= nums[left];
            sum += nums[i];
            res = Math.max(res, sum / k);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution643().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
    }
}