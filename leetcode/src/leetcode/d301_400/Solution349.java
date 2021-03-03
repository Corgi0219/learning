package leetcode.d301_400;

import java.util.*;

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            map.putIfAbsent(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) set.add(nums2[i]);
        }
        int[] ints = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            ints[index++] = iterator.next();
        }
        return ints;

    }
}