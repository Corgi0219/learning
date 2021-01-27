package leetcode.k1000_2000;

import java.util.*;

class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Integer[] res = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i];
        }
        Arrays.sort(res, (o1, o2) -> {
            if (map.containsKey(o1) && map.containsKey(o2)) {
                return map.get(o1) - map.get(o2);
            } else if (!map.containsKey(o1) && !map.containsKey(o2)) {
                return o1 - o2;
            } else {
                if (map.containsKey(o1)) return -1;
                else return 1;
            }
        });
        for (int i = 0; i < res.length; i++) {
            arr1[i] = res[i];
        }
        return arr1;
    }

    public static void main(String[] args) {
        new Solution1122().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
    }
}