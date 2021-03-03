package leetcode.g601_700;

class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0, temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        max = Math.max(max, temp);
        return max;
    }

    public static void main(String[] args) {
        new Solution674().findLengthOfLCIS(new int[]{2, 2, 2, 2, 2});
//        new Solution674().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
    }
}