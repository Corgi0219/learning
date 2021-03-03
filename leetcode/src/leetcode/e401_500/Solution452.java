package leetcode.e401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution452 {
    public int findMinArrowShots(int[][] points) {
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(points));
        list.sort(Comparator.comparingInt(o -> o[0]));

        int minRight = list.get(0)[1];
        int count = 0;

        for (int i = 1; i < list.size(); i++) {
            int[] p = list.get(i);
            if (minRight == Integer.MAX_VALUE) {
                minRight = p[1];
                continue;
            }

            if (p[0] > minRight) {
                count++;
                minRight = p[1];
            } else if (p[0] == minRight) {
                while (i < list.size() - 1 && list.get(i + 1)[0] == minRight) {
                    i++;
                }
                count++;
                if (i == list.size() - 1 && list.get(i)[0] == minRight) {
                    count--;
                }
                minRight = Integer.MAX_VALUE;
            } else if (p[1] < minRight) {
                minRight = p[1];
            }
        }
        count++;
        return count;
    }

    public static void main(String[] args) {
//        new Solution452().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
//        new Solution452().findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
//        new Solution452().findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
        new Solution452().findMinArrowShots(new int[][]{{4, 12}, {7, 8}, {7, 9}, {7, 9}, {2, 8}, {6, 7}, {5, 14}, {4, 13}});
    }
}