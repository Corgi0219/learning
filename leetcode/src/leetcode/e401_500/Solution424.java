package leetcode.e401_500;

class Solution424 {
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        int left = 0, right = 0, maxCharSum = 0;

        for (; right < chars.length; right++) {
            int index = chars[right] - 'A';
            counts[index]++;
            maxCharSum = Math.max(maxCharSum, counts[index]);

            if (right - left + 1 > maxCharSum + k) {
                counts[chars[left++] - 'A']--;
            }
        }
        return chars.length - left;
    }

    public static void main(String[] args) {
        new Solution424().characterReplacement("AABABBA", 1);
    }
}