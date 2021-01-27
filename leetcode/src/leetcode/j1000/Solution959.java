package leetcode.j1000;

import java.util.HashMap;
import java.util.Map;

class Solution959 {
    public int regionsBySlashes(String[] grid) {
        int u = 1, l = 2, d = 3, r = 4;
        int length = grid.length;
        Map<String, Integer> points = new HashMap<>(10);
        int index = 0;

        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++) {
                for (int j = 1; j <= 4; j++) {
                    points.put(String.format("%s-%s-%s", i, k, j), index++);
                }
            }
        }
        UnionFind unionFind = new UnionFind(points.size());
        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++) {
                if (points.containsKey(String.format("%s-%s-%s", i + 1, k, 1))) {
                    Integer didx = points.get(String.format("%s-%s-%s", i, k, 3));
                    Integer uidx = points.get(String.format("%s-%s-%s", i + 1, k, 1));
                    unionFind.union(didx, uidx);
                }
                if (points.containsKey(String.format("%s-%s-%s", i, k + 1, 2))) {
                    Integer ridx = points.get(String.format("%s-%s-%s", i, k, 4));
                    Integer lidx = points.get(String.format("%s-%s-%s", i, k + 1, 2));
                    unionFind.union(ridx, lidx);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            char[] lines = grid[i].toCharArray();
            for (int k = 0; k < length; k++) {
                Integer uidx = points.get(String.format("%s-%s-%s", i, k, 1));
                Integer lidx = points.get(String.format("%s-%s-%s", i, k, 2));
                Integer didx = points.get(String.format("%s-%s-%s", i, k, 3));
                Integer ridx = points.get(String.format("%s-%s-%s", i, k, 4));
                if (lines[k] == '\\') {
                    unionFind.union(uidx, ridx);
                    unionFind.union(lidx, didx);
                } else if (lines[k] == '/') {
                    unionFind.union(uidx, lidx);
                    unionFind.union(ridx, didx);
                } else {
                    unionFind.union(uidx, lidx);
                    unionFind.union(lidx, ridx);
                    unionFind.union(ridx, didx);
                }
            }
        }
        return unionFind.setCount;
    }

    static class UnionFind {
        int[] parent, rank;
        int setCount;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            setCount = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            return parent[i] == i ? i : (parent[i] = find(parent[i]));
        }

        public boolean union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return false;
            }

            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            parent[fy] = fx;
            rank[fx] += rank[fy];
            setCount--;
            return true;
        }
    }

    public static void main(String[] args) {
//        new Solution959().regionsBySlashes(new String[]{"\\/", "/\\"});
        new Solution959().regionsBySlashes(new String[]{"/\\", "\\/"});
    }
}