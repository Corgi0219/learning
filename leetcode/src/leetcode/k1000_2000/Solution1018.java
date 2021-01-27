package leetcode.k1000_2000;

import java.util.ArrayList;
import java.util.List;

class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int num = 0;
        List<Boolean> res = new ArrayList<>();

        for (int i = A.length - 1, index = 0; i >= 0; i--) {
            num = ((num << 1) + A[index++]) % 5;
            res.add(num == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution1018().prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1});
    }

}