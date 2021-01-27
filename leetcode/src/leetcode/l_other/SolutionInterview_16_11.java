package leetcode.l_other;//你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方
//法，生成跳水板所有可能的长度。 
// 返回的长度需要从小到大排列。 
// 示例： 
// 输入：
//shorter = 1
//longer = 2
//k = 3
//输出： {3,4,5,6}
// 
// 提示： 
// 
// 0 < shorter <= longer 
// 0 <= k <= 100000 
// 
// Related Topics 递归 记忆化


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionInterview_16_11 {
    /**
     * 递归超时
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        Set<Integer> set = new LinkedHashSet<>();
        helper(shorter, longer, k, 0, set);

        ArrayList<Integer> list = new ArrayList<>(set);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        Arrays.sort(ints);
        return ints;
    }

    private void helper(int shorter, int longer, int k, int temp, Set<Integer> result) {
        if (k == 0) {
            result.add(temp);
            return;
        }
//        if (!result.contains(temp + shorter))
        helper(shorter, longer, k - 1, temp + shorter, result);
//        if (!result.contains(temp + longer))
        helper(shorter, longer, k - 1, temp + longer, result);
    }

    public static void main(String[] args) {
        System.out.println(new SolutionInterview_16_11().divingBoard(1, 1, 10000));
    }
}

class Ans_2 {
    /**
     * 两个特例：
     * k == 0，这个时候返回 []
     * shorter == longer，此时结果中只有一种长度，即 shorter * k
     * 除了上述两种特例之外，即要从长度为 shorter 和 longer 的木板中（longer > shorter），挑选 k (k > 0) 个。
     * 先说结论：构成的不同长度木板的结果必有 k + 1 个，分别为 shorter * k + (longer - shorter) * i，其中 0 <= i <= k。
     * 证明如下：
     * 假如，假设取了 k - i 个 shorter 木板，则取了 i 个 longer 木板。
     * 构成的总长度 f(i) 是：
     * f(i) = shorter * (k - i) + longer * i
     *      = shorter * k + (longer - shorter) * i
     * 由于 longer - shorter > 0，所以 f(i) 是随着 i 的增长而单调递增的一元线性函数。
     * 由一元线性函数的性质，我们知道函数 f(i) 不会有相同的取值。而 i 的取值是 0 <= i <= k，因此 f(i) 必有 k + 1 个不同的取值。
     * 因此我们定义一个长度为 k + 1 的数组，把其中的每个位置分别设置为 shorter * (k - i) + longer * i 即可。
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{shorter * k};
        int[] ints = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            ints[i] = shorter * k + (longer - shorter) * i;
        }
        return ints;
    }
    public static void main(String[] args) {
        System.out.println(new Ans_2().divingBoard(2, 3, 3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
