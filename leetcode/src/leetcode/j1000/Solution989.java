package leetcode.j1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        while (K > 0) {
            list.add(K % 10);
            K /= 10;
        }
        List<Integer> res = new ArrayList<>();
        Collections.reverse(list);
        int next = 0;
        for (int i = A.length - 1, k = list.size() - 1; i >= 0 || k >= 0; i--, k--) {
            if (k >= 0 && i >= 0) {
                if (A[i] + list.get(k) + next >= 10) {
                    res.add((A[i] + list.get(k) + next) % 10);
                    next = 1;
                } else {
                    res.add((A[i] + list.get(k) + next));
                    next = 0;
                }
            } else if (i >= 0){
                if (A[i] + next >= 10) {
                    res.add((A[i] + next) % 10);
                    next = 1;
                } else {
                    res.add((A[i] + next));
                    next = 0;
                }
            }else {
                if (list.get(k) + next >= 10) {
                    res.add((list.get(k) + next) % 10);
                    next = 1;
                } else {
                    res.add((list.get(k) + next));
                    next = 0;
                }
            }
        }
        if (next == 1) {
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        new Solution989().addToArrayForm(new int[]{2, 1, 5}, 806);
    }
}