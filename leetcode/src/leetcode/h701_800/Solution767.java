package leetcode.h701_800;

import java.util.PriorityQueue;

class Solution767 {
    public String reorganizeString(String S) {
        int[] words = new int[26];
        int max = 0;

        for (int i = 0; i < S.length(); i++) {
            words[S.charAt(i) - 'a']++;
            max = Math.max(max, words[S.charAt(i) - 'a']);
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> words[o2 - 'a'] - words[o1 - 'a']);

        for (char i = 0; i < 26; i++) {
            if (words[i] > 0){
                queue.offer((char) ('a' + i));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (queue.size() > 1) {
            Character fst = queue.poll();
            Character snd = queue.poll();
            builder.append(fst).append(snd);
            int f = fst - 'a';
            int s = snd - 'a';
            words[f]--;
            words[s]--;
            if (words[f] > 0) {
                queue.offer(fst);
            }
            if (words[s] > 0){
                queue.offer(snd);
            }
        }

        if (queue.size() > 0) {
            builder.append(queue.poll());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        new Solution767().reorganizeString("aab");
    }
}