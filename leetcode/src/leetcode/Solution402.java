package leetcode;

import java.util.Deque;
import java.util.LinkedList;

class Solution402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int count = 0;

        char[] chars = num.toCharArray();
        deque.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (deque.isEmpty()) {
                deque.add(chars[i]);
                continue;
            }

            while (count < k && !deque.isEmpty() && chars[i] < deque.peekLast()) {
                deque.pollLast();
                count++;
            }
            deque.add(chars[i]);
        }
        if (count < k) {
            for (int i = 0; i < k - count; i++) {
                deque.pollLast();
            }
        }
        StringBuilder res = new StringBuilder();
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            if (res.toString().equals("") && deque.peekFirst() == '0') {
                if (deque.pollFirst() == '0' && deque.isEmpty()) {
                    res.append("0");
                }
                continue;
            }
            res.append(deque.pollFirst());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new Solution402().removeKdigits("1432219", 3);
    }
}