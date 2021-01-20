package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(people));
        list.sort((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] < o2[1] ? 1 : -1);
        int[][] res = new int[people.length][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = new int[]{-1, -1};
        }
        for (int[] p : list) {
            int count = 0;
            for (int k = 0; k < res.length; k++) {
                if (res[k][0] < 0) {
                    count++;
                    if (count == p[1] + 1) {
                        res[k] = p;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution406().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }
}