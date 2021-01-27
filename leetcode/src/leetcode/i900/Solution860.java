package leetcode.i900;

class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;
        int tenNum = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNum++;
            } else if (bills[i] == 10) {
                if (fiveNum > 0) {
                    tenNum++;
                    fiveNum--;
                } else {
                    return false;
                }
            } else {
                if (fiveNum >= 3 || (fiveNum > 0 && tenNum > 0)) {
                    if (fiveNum > 0 && tenNum > 0) {
                        fiveNum--;
                        tenNum--;
                    } else {
                        fiveNum -= 3;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean change = new Solution860().lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5});
        return;
    }
}