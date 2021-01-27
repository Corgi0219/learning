package leetcode.d400;

import java.util.*;

class Solution316 {
    public String removeDuplicateLetters(String s) {
        int[] chars = new int[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            chars[c - 'a']++;
        }
        Deque<Character> deque = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : array) {
            if (deque.isEmpty()) {
                deque.offer(c);
                map.put(c, 1);
                continue;
            }

            if (map.containsKey(c)) {
                chars[c-'a']--;
                continue;
            }
            while (!deque.isEmpty() && deque.peekLast() > c && chars[deque.peekLast() - 'a'] > 1) {
                chars[deque.peekLast() - 'a']--;
                map.remove(deque.peekLast());
                deque.pollLast();
            }
            deque.offer(c);
            map.put(c, 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution316().removeDuplicateLetters("bbcaac");
    }
}