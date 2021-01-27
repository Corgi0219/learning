package leetcode.a100;//编写一个程序，通过已填充的空格来解决数独问题。
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 628 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution37 {
    private boolean[][] rows;
    private boolean[][] cols;
    private boolean[][][] blocks;
    private List<int[]> blanks;
    private boolean ok;

    public void solveSudoku(char[][] board) {
        rows = new boolean[9][9];
        cols = new boolean[9][9];
        blocks = new boolean[3][3][9];
        blanks = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (board[i][k] == '.') {
                    blanks.add(new int[]{i, k});
                } else {
                    int num = board[i][k] - 1 - '0';
                    if (!rows[i][num] && !cols[k][num] && !blocks[i / 3][k / 3][num]) {
                        rows[i][num] = cols[k][num] = blocks[i / 3][k / 3][num] = true;
                    }
                }
            }
        }
        helper(board, 0);
    }

    private void helper(char[][] board, int blankIndex) {
        if (blankIndex == blanks.size()) {
            ok = true;
            return;
        }

        int[] blankPos = blanks.get(blankIndex);
        int row = blankPos[0], col = blankPos[1];

        for (int i = 0; i < 9; i++) {
            if (!rows[row][i] && !cols[col][i] && !blocks[row / 3][col / 3][i]) {
                char num = (char) ('0' + 1 + i);
                board[row][col] = num;
                rows[row][i] = cols[col][i] = blocks[row / 3][col / 3][i] = true;
                helper(board, blankIndex + 1);
                if (!ok) return;
                rows[row][i] = cols[col][i] = blocks[row / 3][col / 3][i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
