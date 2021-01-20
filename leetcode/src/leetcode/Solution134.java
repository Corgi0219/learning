package leetcode;

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] circleGas = new int[gas.length * 2];
        int[] circleCost = new int[cost.length * 2];
        for (int i = 0, k = 0; i < circleGas.length; i++, k++) {
            if (k == gas.length) k = 0;
            circleGas[i] = gas[k];
            circleCost[i] = cost[k];
        }
        int oil = 0;
        for (int k = 0; k < circleGas.length; k++) {
            for (int i = k; i < circleGas.length; i++) {
                if (circleGas[i] + oil >= circleCost[i]) {
                    oil = circleGas[i] + oil - circleCost[i];
                } else {
                    oil = 0;
                    break;
                }
                if (i == k + gas.length) {
                    return k;
                }
            }
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        new Solution134().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        new Solution134().canCompleteCircuit(new int[]{ 2, 3, 4}, new int[]{3, 4, 3});
    }
}