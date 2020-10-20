//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 584 👎 0


import java.util.Arrays;
import java.util.logging.Level;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution79 {
    private int[][] path = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] marked;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0 || "".equals(word)) return false;
        int cols = board[0].length;
        this.marked = new boolean[rows][cols];
        this.board = board;
        this.word = word;
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < cols; k++) {
                if (helper(i, k, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(int row, int col, int index) {
        boolean ok = board[row][col] == word.charAt(index);
        if (index == word.length() - 1) return ok;

        if (ok) {
            marked[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int newRow = row + path[i][0];
                int newCol = col + path[i][1];
                if (isValid(newRow, newCol) && !marked[newRow][newCol]) {
                    if (helper(newRow, newCol, index + 1)) {
                        return true;
                    }
                }
            }
            marked[row][col] = false;
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    public static void main(String[] args) {
        boolean b = new Solution79().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "DECCBA");
        System.out.println('A' + 1);
//        System.out.println(new StringBuilder("abc").delete(3, 3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
