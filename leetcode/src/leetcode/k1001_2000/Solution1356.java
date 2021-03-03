package leetcode.k1001_2000;

import java.util.ArrayList;
import java.util.List;

class Solution1356 {
    public int[] sortByBits(int[] arr) {
        List<int[]> counts = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 0;
            while (num != 0) {
                num &= (num - 1);
                count++;
            }
            counts.add(new int[]{count, i});
        }
        counts.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return arr[o1[1]] - arr[o2[1]];
            } else {
                return o1[0] - o2[0];
            }
        });
        int[] res = new int[counts.size()];
        for (int i = 0; i < counts.size(); i++) {
            res[i] = counts.get(i)[1];
        }
        return null;
    }

    public static void main(String[] args) {
        new Solution1356().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
    }
}