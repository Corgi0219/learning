package leetcode;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import java.util.*;

class Solution1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int length = edges.length;
        int[][] newEdges = new int[length][4];

        for (int i = 0; i < length; i++) {
            for (int k = 0; k < 3; k++) {
                newEdges[i][k] = edges[i][k];
            }
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, Comparator.comparingInt(t -> t[2]));
        UnionFind unionFind = new UnionFind(n);
        int v = 0;
        for (int i = 0; i < length; i++) {
            if (unionFind.union(newEdges[i][0], newEdges[i][1])) {
                v += newEdges[i][2];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < length; i++) {
            UnionFind unionFind1 = new UnionFind(n);
            int v1 = 0;
            for (int k = 0; k < length; k++) {
                if (i != k && unionFind1.union(newEdges[k][0], newEdges[k][1])) {
                    v1 += newEdges[k][2];
                }
            }
            if (unionFind1.setCount != 1 || v1 > v) {
                res.get(0).add(newEdges[i][3]);
                continue;
            }

            unionFind1 = new UnionFind(n);
            unionFind1.union(newEdges[i][0], newEdges[i][1]);
            v1 = newEdges[i][2];

            for (int k = 0; k < length; k++) {
                if (i != k && unionFind1.union(newEdges[k][0], newEdges[k][1])) {
                    v1 += newEdges[k][2];
                }
            }
            if (v1 == v) {
                res.get(1).add(newEdges[i][3]);
            }
        }
        return res;
    }

    static class UnionFind {
        int[] parent, rank;
        int setCount;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            setCount = n;
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return parent[x] == x ? parent[x] : (parent[x] = find(parent[x]));
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
}