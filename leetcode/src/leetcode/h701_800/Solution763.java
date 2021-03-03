package leetcode.h701_800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution763 {
    public List<Integer> partitionLabels(String S) {
        char[] chars = S.toCharArray();
        HashMap<Character, int[]> idxMap = new HashMap<>(S.length() + 1);
        for (int i = 0; i < chars.length; i++) {
            idxMap.putIfAbsent(chars[i], new int[]{i, -1});
            idxMap.get(chars[i])[1] = i;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0, start = 0, end = 0; i < chars.length; i++) {
            end = Math.max(idxMap.get(chars[i])[1], end);
            if (end == i) {
                list.add(end - start + 1);
                start = end = end + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new Solution763().partitionLabels("vhaagbqkaq");
    }
}