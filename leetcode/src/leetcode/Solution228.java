package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        StringBuilder sb = new StringBuilder(nums[0] + "");

        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
                if (i == nums.length - 1) {
                    sb.append("->").append(nums[i]);
                }
            } else {
                if (count > 1) {
                    sb.append("->").append(nums[i - 1]);
                }
                res.add(sb.toString());
                sb = new StringBuilder(nums[i] + "");
                count = 1;
            }
            if (i == nums.length - 1) {
                res.add(sb.toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution228().summaryRanges(new int[]{-1});
    }
}