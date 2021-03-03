package leetcode.i801_900;

import java.util.ArrayList;
import java.util.List;

class Solution842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        char[] chars = S.toCharArray();
        dfs(list, chars, chars.length, 0);
        return list;
    }

    private boolean dfs(List<Integer> list, char[] s, int length, int index) {
        if (length == index && list.size() > 2) {
            return true;
        }

        long currLong = 0L;
        for (int i = index; i < length; i++) {
            if (i > index && s[index] == '0') {
                break;
            }

            currLong = currLong * 10 + s[i] - '0';
            if (currLong == Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;

            int size = list.size();
            if (size >= 2 && curr > list.get(size - 1) + list.get(size - 2)) {
                break;
            }
            if (size <= 1 || curr == list.get(size - 1) + list.get(size - 2)) {
                list.add(curr);
                if (dfs(list, s, length, i + 1)) {
                    return true;
                }
                list.remove(size - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1.0f != Float.NaN);
        System.out.println(1.0f > Float.NaN);
        System.out.println(1.0f <= Float.NaN);
        System.out.println(Float.NaN != Float.NaN);
        System.out.println(0xFFFF);
        System.out.println(0b1111111111111111);
    }
}