package leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution387 {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[26];
        for (char c : chars) {
            nums[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (nums[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}