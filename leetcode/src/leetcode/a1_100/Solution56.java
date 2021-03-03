package leetcode.a1_100;

import java.util.*;

class Solution56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(nums -> nums[0]));
        list.offerLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= list.peekLast()[1]) {
                list.peekLast()[1] = Math.max(list.peekLast()[1], intervals[i][1]);
            } else {
                list.offerLast(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        new Solution56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}