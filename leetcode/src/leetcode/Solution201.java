package leetcode;//给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
//
// 示例 1: 
//
// 输入: [5,7]
//输出: 4 
//
// 示例 2: 
//
// 输入: [0,1]
//输出: 0 
// Related Topics 位运算 
// 👍 172 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }

    public static void main(String[] args) {
//        System.out.println(21474 & 214748);
        System.out.println(new Solution201().rangeBitwiseAnd(9, 12));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
