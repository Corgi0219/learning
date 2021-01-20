package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[][] data = new int[len][2];
        for (int i = 0; i < len; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }

        Arrays.sort(data, Comparator.comparingInt(o -> o[0]));

        int[] res = new int[len];
        int prev = -1;
        for (int i = 0; i < len; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) prev = i;
            res[data[i][1]] = prev;
        }
        return res;
    }
}