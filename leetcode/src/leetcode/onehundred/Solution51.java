package leetcode.onehundred;//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 586 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution51 {
    private int n;
    private boolean[] cols;
    private boolean[] mains;
    private boolean[] subs;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) return res;

        this.n = n;
        this.cols = new boolean[n];
        this.mains = new boolean[2 * n - 1];
        this.subs = new boolean[2 * n - 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        dfs(0, deque);
        return res;
    }

    private void dfs(int row, ArrayDeque<Integer> deque) {
        if (row == n) {
            List<String> board = convert(deque);
            res.add(board);
            return;
        }

        for (int col = 0; col < this.n; col++) {
            if (!cols[col] && !mains[row - col + n - 1] && !subs[row + col]) {
                deque.addLast(col);
                cols[col] = mains[row - col + n - 1] = subs[row + col] = true;
                dfs(row + 1, deque);
                cols[col] = mains[row - col + n - 1] = subs[row + col] = false;
                deque.pollLast();
            }
        }
    }

    private List<String> convert(ArrayDeque<Integer> deque) {
        ArrayList<Integer> list = new ArrayList<>(deque);
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if (list.get(i) == k) str.append("Q");
                else str.append(".");
            }
            board.add(str.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        List<List<String>> queens = new Solution51().solveNQueens(4);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
