package leetcode.a100;

import java.util.HashMap;
import java.util.Map;

class Solution62 {
    private int res;
    private Map<String, Integer> cache;

    public int uniquePaths(int m, int n) {
        cache = new HashMap<>();
        dfs(m, n, 1, 1);
        return res;
    }

    private void dfs(int m, int n, int currm, int currn) {
        String key = currm + "," + currn;
        if (currm == m && currn == n) {
            res++;
            cache.putIfAbsent(key, res);
            return;
        }

        if (cache.containsKey(key)) {
            res += cache.get(key);
            System.out.println(key);
            return;
        }

        if (currm <= m) {
            dfs(m, n, currm + 1, currn);
        }

        if (currn <= n) {
            dfs(m, n, currm, currn + 1);
        }
    }

    public static void main(String[] args) {
        int paths = new Solution62().uniquePaths(1, 1);
        return;
    }
}