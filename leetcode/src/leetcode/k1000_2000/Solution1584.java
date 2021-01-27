package leetcode.k1000_2000;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution1584 {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int k = i + 1; k < points.length; k++) {
                edges.add(new Edge(dist(points[i], points[k]), i, k));
            }
        }

        edges.sort(Comparator.comparingInt(e -> e.len));
        int res = 0, num = 1;
        UnionFind uf = new UnionFind(length);
        for (Edge edge : edges) {
            if (uf.union(edge.x, edge.y)) {
                res += edge.len;
                num++;
                if (num == length) {
                    break;
                }
            }
        }
        return res;
    }

    private int dist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int val) {
            return parent[val] == val ? val : (parent[val] = find(parent[val]));
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

            rank[fx] += rank[fy];
            parent[fy] = fx;
            return true;
        }
    }

    static class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}