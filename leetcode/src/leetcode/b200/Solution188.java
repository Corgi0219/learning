package leetcode.b200;

import java.util.Arrays;

class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int length = prices.length;
        k = Math.min(k, length / 2);

        int[][] buys = new int[length][k + 1];
        int[][] sells = new int[length][k + 1];

        buys[0][0] = -prices[0];
        sells[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            buys[0][i] = sells[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < length; i++) {
            buys[i][0] = Math.max(buys[i - 1][0], sells[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buys[i][j] = Math.max(buys[i - 1][j], sells[i - 1][j] - prices[i]);
                sells[i][j] = Math.max(buys[i - 1][j - 1] + prices[i], sells[i - 1][j]);
            }
        }

        return Arrays.stream(sells[length - 1]).max().getAsInt();
    }
}