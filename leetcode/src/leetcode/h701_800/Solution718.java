package leetcode.h701_800;//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
// 示例 1: 
//
// 
//输入:
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出: 3
//解释: 
//长度最长的公共子数组是 [3, 2, 1]。
// 
//
// 说明: 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 滑动窗口法
 */
class Solution718 {
    public int findLength(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }

    private int findMax(int[] small, int[] big) {
        int smallLen = small.length, bigLen = big.length;
        int max = 0;
        for (int i = 1; i <= small.length; i++) {
            max = Math.max(max, match(small, 0, big, bigLen - i, i));
        }

        for (int i = bigLen - smallLen; i >= 0; i--) {
            max = Math.max(max, match(small, 0, big, i, smallLen));
        }

        for (int i = 1; i < smallLen; i++) {
            max = Math.max(max, match(small, i, big, 0, smallLen - i));
        }
        return max;
    }

    private int match(int[] small, int smallStart, int[] big, int bigStart, int len) {
        int temp = 0, max = 0;
        for (int i = 0; i < len; i++) {
            if (small[smallStart + i] == big[bigStart + i]) {
                temp++;
            } else if (temp > 0) {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        return temp > 0 ? Math.max(max, temp) : max;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[] B = new int[]{2, 3, 4, 5, 6};
        int length = new Solution718().findLength(A, B);
        System.out.println(length);
    }
}

/**
 * 暴力法
 */
class Solution718V1 {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < B.length; k++) {
                int subLen = 0;
                while (i + subLen < A.length && k + subLen < B.length && A[i + subLen] == B[k + subLen]) {
                    subLen++;
                }
                max = Math.max(subLen, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[] B = new int[]{2, 3, 4, 5, 6};
        int length = new Solution718V1().findLength(A, B);
        System.out.println(length);
    }
}