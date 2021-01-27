package leetcode.g700;//你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
//
// 示例 1: 
//
// 输入: [4, 1, 8, 7]
//输出: True
//解释: (8-4) * (7-1) = 24
// 
//
// 示例 2: 
//
// 输入: [1, 2, 1, 2]
//输出: False
// 
//
// 注意: 
//
// 
// 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。 
// 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允
//许的。 
// 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。 
// 
// Related Topics 深度优先搜索 
// 👍 167 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution679 {
    public boolean judgePoint24(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) if (i > 0) list.add(i);
        nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        int len = nums.length;
        if (len == 1) {
            int i = nums[0] - 24;
            return Math.abs(i) == 0;
        }

        for (int i = 0; i < len; i++) {
            for (int k = i + 1; k < len; k++) {
                int[] copy = Arrays.copyOf(nums, len + 1);
                copy[i] = copy[k] = -1;

                int a = nums[i], b = nums[k];
                copy[len] = a - b;
                boolean isOk = judgePoint24(copy);
                copy[len] = a + b;
                isOk = isOk || judgePoint24(copy);
                copy[len] = a * b;
                isOk = isOk || judgePoint24(copy);
                copy[len] = a / b;
                isOk = isOk || judgePoint24(copy);

                if (isOk) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution679().judgePoint24(new int[]{1, 2, 1, 2}));
    }
}

class Solution679V1 {

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            if (i > 0) list.add((double) i);
        }
        return helper(list);
    }

    private boolean helper(List<Double> list) {

        int len = list.size();
        if (len == 1) {
            double i = list.get(0) - 24;
            return Math.abs(i) < 1e-6;
        }

        for (int i = 0; i < len; i++) {
            for (int k = i + 1; k < len; k++) {
                ArrayList<Double> copy = new ArrayList<>(list);
                double a = copy.get(i), b = copy.get(k);
                copy.remove(k);
                copy.remove(i);

                copy.add(a - b);
                int index = copy.size() - 1;
                boolean isOk = helper(copy);
                copy.set(index, b - a);
                isOk = isOk || helper(copy);
                copy.set(index, a + b);
                isOk = isOk || helper(copy);
                if (b != 0) {
                    copy.set(index, a / b);
                    isOk = isOk || helper(copy);
                }
                if (a != 0) {
                    copy.set(index, b / a);
                    isOk = isOk || helper(copy);
                }
                copy.set(index, a * b);
                isOk = isOk || helper(copy);

                if (isOk) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution679V1().judgePoint24(new int[]{1, 7, 4, 5}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
