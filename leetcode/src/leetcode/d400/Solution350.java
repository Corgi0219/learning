package leetcode.d400;//给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 317 👎 0


import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution350 {
    /**
     * 使用Hashmap
     * 思路：使用字典存储第一个数组中所有数字的出现次数，遍历第二个数字，找字典中是否有对应的key且值不为0，将此数字记录下来，
     * 并将字典中该数字的出现次数减1，遍历结束后，返回结果。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        int[] res = new int[nums1.length];
        int idx = nums1.length < nums2.length ? findIntersect(nums1, nums2, res) : findIntersect(nums2, nums1, res);
        res = Arrays.copyOfRange(res, 0, idx);
        return res;
    }

    private int findIntersect(int[] nums1, int[] nums2, int[] res) {
        int idx = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.containsKey(nums1[i]) ? map.get(nums1[i]) + 1 : 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                res[idx++] = nums2[i];
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 3, 4};
        int[] nums2 = new int[]{1};
        new Solution350().intersect(nums1, nums2);
    }
}

class Solution350V1 {
    /**
     * 排序后双指针
     * 思路：先将两个数组排序，然后分别用两个指针指向两个数组的索引，全部从0开始，判断元素是否相等，
     * 不相等则向后移动指向较小值的那个指针，直到相等则记录该数字，并且两个指针同时向后移动
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx = 0, idx1 = 0, idx2 = 0;
        int[] res = new int[nums1.length];
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] == nums2[idx2]) {
                res[idx++] = nums1[idx1];
                idx1++;
                idx2++;
            } else {
                idx2++;
            }
        }
        res = Arrays.copyOfRange(res, 0, idx);
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 3, 4};
        int[] nums2 = new int[]{1, 1};
        new Solution350V1().intersect(nums1, nums2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
