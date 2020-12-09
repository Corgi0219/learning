class Solution861 {
    public int matrixScore(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int res = (int) (rows * Math.pow(2, cols - 1));
        int[] flips = new int[rows];
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 0) {
                flips[i] = 1;
            }
        }

        for (int i = 1; i < cols; i++) {
            int zeros = 0, nozeros = 0;
            for (int k = 0; k < rows; k++) {
                if (flips[k] == 1) {
                    if (A[i][k] == 1) {
                        zeros++;
                    } else {
                        nozeros++;
                    }
                } else {
                    if (A[i][k] == 0) {
                        zeros++;
                    } else {
                        nozeros++;
                    }
                }
            }
            res += Math.max(zeros, nozeros) * Math.pow(2, cols - 1 - i);
        }
        return res;
    }
}