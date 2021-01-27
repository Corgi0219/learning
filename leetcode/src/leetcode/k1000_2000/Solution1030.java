package leetcode.k1000_2000;

import java.util.ArrayList;
import java.util.List;

class Solution1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int k = 0; k < C; k++) {
                res.add(new int[]{i, k});
            }
        }

        res.sort((o1, o2) -> Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - Math.abs(o2[0] - r0) - Math.abs(o2[1] - c0));
        int[][] arr = new int[res.size()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        new Solution1030().allCellsDistOrder(2, 2, 0, 1);
    }
}