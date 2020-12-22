class Solution389 {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            arr[c - 'a']++;
        }
        char[] array1 = t.toCharArray();
        for (char c : array1) {
            arr[c - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}