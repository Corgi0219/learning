package leetcode;

import java.util.*;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for (String str : strs) {
            char[] array = str.toCharArray();
            int[] nums = new int[26];
            for (int i = 0; i < array.length; i++) {
                nums[array[i] - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    builder.append('a' + i).append(nums[i]);
                }
            }

            map.putIfAbsent(builder.toString(), new ArrayList<>());
            map.get(builder.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}