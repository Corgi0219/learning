package leetcode;

class Solution48 {
    public void rotate(int[][] matrix) {
        int temp1, temp2, row = matrix.length, col = matrix[0].length;
        int[] upLeft = {0, 0}, upRight = {0, col - 1}, lowerLeft = {row - 1, 0}, lowerRight = {row - 1, col - 1};
        for (int k = 1; k < row / 2 + 1; k++) {
            int num = upRight[1] - upLeft[1];
            for (int i = 0; i < num; i++) {
                temp1 = matrix[upLeft[0]][upLeft[1]];
                matrix[upLeft[0]][upLeft[1]] = matrix[lowerLeft[0]][lowerLeft[1]];

                temp2 = matrix[upRight[0]][upRight[1]];
                matrix[upRight[0]][upRight[1]] = temp1;

                temp1 = matrix[lowerRight[0]][lowerRight[1]];
                matrix[lowerRight[0]][lowerRight[1]] = temp2;

                matrix[lowerLeft[0]][lowerLeft[1]] = temp1;

                upLeft[0]++;
                lowerLeft[1]++;
                upRight[1]--;
                lowerRight[0]--;
            }
            upLeft[0] = upRight[0] = upLeft[1] = lowerLeft[1] = k;
            upRight[1] = lowerRight[1] = lowerLeft[0] = lowerRight[0] = row - 1 - k;
        }
    }

    public static void main(String[] args) {
        new Solution48().rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        });
    }
}