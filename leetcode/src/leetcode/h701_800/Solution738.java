package leetcode.h701_800;

class Solution738 {
    public int monotoneIncreasingDigits(int N) {
        char[] array = Integer.toString(N).toCharArray();
        int i = 1, len = array.length;
        while (i < len && array[i-1] <= array[i]) {
            i++;
        }
        if (i < len) {
            while (i > 0 && array[i-1] > array[i]) {
                array[i - 1]--;
                i--;
            }
            for (i++; i < len; i++) {
                array[i] = '9';
            }
        }

        return Integer.parseInt(new String(array));
    }

    public static void main(String[] args) {
        int digits = new Solution738().monotoneIncreasingDigits(4251891);
        return;
    }
}