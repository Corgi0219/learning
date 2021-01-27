package leetcode.j1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

class Solution947 {
    public int removeStones(int[][] stones) {
        int len = stones.length;
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            edges.add(new ArrayList<>());
            for (int k = 0; k < len; k++) {
                if (stones[i][0] == stones[k][0] || stones[i][1] == stones[k][1]) {
                    edges.get(i).add(k);
                }
            }
        }

        boolean[] visits = new boolean[len];

        int num = 0;
        for (int i = 0; i < len; i++) {
            if (!visits[i]) {
                num++;
                dfs(i, edges, visits);
            }
        }
        return len - num;
    }

    public void dfs(int x, List<List<Integer>> edges, boolean[] visits) {
        visits[x] = true;
        for (Integer n : edges.get(x)) {
            if (!visits[n]) {
                dfs(n, edges, visits);
            }
        }
    }
}

class Solution947V1 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<>());
        }

        Map<Integer, List<Integer>> rec = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rec.putIfAbsent(stones[i][0], new ArrayList<>());
            rec.get(stones[i][0]).add(i);
            rec.putIfAbsent(stones[i][1] + 10001, new ArrayList<>());
            rec.get(stones[i][1] + 10001).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : rec.entrySet()) {
            List<Integer> list = entry.getValue();
            int k = list.size();
            for (int i = 1; i < k; i++) {
                edge.get(list.get(i - 1)).add(list.get(i));
                edge.get(list.get(i)).add(list.get(i - 1));
            }
        }

        boolean[] vis = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                num++;
                dfs(i, edge, vis);
            }
        }
        return n - num;
    }

    public void dfs(int x, List<List<Integer>> edge, boolean[] vis) {
        vis[x] = true;
        for (int y : edge.get(x)) {
            if (!vis[y]) {
                dfs(y, edge, vis);
            }
        }
    }
}