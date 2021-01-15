class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] nums = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (matrix[i][k] == '1') {
                    if (k == 0) {
                        nums[i][k]++;
                    } else {
                        nums[i][k] += nums[i][k - 1] + 1;
                    }
                }
            }
        }

        int width = Integer.MAX_VALUE, res = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (i == 0) {
                    if (nums[i][k] > 0) {
                        width = Math.min(width, nums[i][k]);
                        res = Math.max(res, nums[i][k]);
                    }
                } else {
                    int count = 1;
                    width = nums[i][k];
                    for (int j = i; j >= 0; j--) {
                        if (nums[j][k] > 0) {
                            width = Math.min(width, nums[j][k]);
                            res = Math.max(res, width * count++);
                        } else {
                            width = Integer.MAX_VALUE;
                            count = 1;
                        }
                    }
                }
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        new Solution85().maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
//        new Solution85().maximalRectangle(new char[][]{
//                {'1', '1'},
//                {'1', '1'}
//        });
    }
}