package leetcode.d400;

class Solution321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0, j = 0, index = 0;

        while (index < merge.length) {
            if (nums1[i] == nums2[j]) {
                int count = 1;
                while (i + count < nums1.length
                        && j + count < nums2.length
                        && nums1[i + count] == nums2[j + count]) {
                    merge[index++] = nums1[i + count];
                    count++;
                }
                merge[index++] = Math.max(nums1[i + count], nums2[j + count]);

                for (int n = 0; n < count; n++) {
                    merge[index++] = nums2[j + n];
                }

                if (i + count == nums1.length || nums1[i + count] > nums2[j + count]) {
                    i += count;
                }
                if (j + count == nums2.length || nums1[i + count] < nums2[j + count]) {
                    j += count;
                }
            } else {
                merge[index++] = Math.max(nums1[i], nums2[j]);
                if (nums1[i] > nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Solution321().maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
    }
}