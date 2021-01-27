package leetcode.k1000_2000;

import java.util.Arrays;

class Solution1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int length = edges.length;

        UnionFind1579 uf1 = new UnionFind1579(n);
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (edges[i][0] == 3) {
                if (!uf1.union(edges[i][1] - 1, edges[i][2] - 1)) {
                    res++;
                }
            }
        }
        UnionFind1579 uf2 = new UnionFind1579(Arrays.copyOf(uf1.parents, uf1.parents.length),
                Arrays.copyOf(uf1.rank, uf1.rank.length), uf1.setCount);
        for (int i = 0; i < length; i++) {
            if (edges[i][0] == 1) {
                if (!uf2.union(edges[i][1] - 1, edges[i][2] - 1)) {
                    res++;
                }
            }
        }
        if (uf2.setCount > 1) {
            return -1;
        }
        UnionFind1579 uf3 = new UnionFind1579(Arrays.copyOf(uf1.parents, uf1.parents.length),
                Arrays.copyOf(uf1.rank, uf1.rank.length), uf1.setCount);
        for (int i = 0; i < length; i++) {
            if (edges[i][0] == 2) {
                if (!uf3.union(edges[i][1] - 1, edges[i][2] - 1)) {
                    res++;
                }
            }
        }
        if (uf3.setCount > 1) {
            return -1;
        }
        return res;
    }

//    public static void main(String[] args) {
//        new Solution1579().maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}});
//    }
}

class UnionFind1579 {
    int[] parents, rank;
    int setCount;

    public UnionFind1579(int[] parents, int[] rank, int setCount) {
        this.parents = parents;
        this.rank = rank;
        this.setCount = setCount;
    }

    public UnionFind1579(int n) {
        parents = new int[n];
        rank = new int[n];
        setCount = n;

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int i) {
        return parents[i] == i ? i : (parents[i] = find(parents[i]));
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

        parents[fy] = fx;
        rank[fx] += fy;
        setCount--;
        return true;
    }

}