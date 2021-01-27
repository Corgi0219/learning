package leetcode.k1000_2000;

class Solution1319 {

    public static void main(String[] args) {
        new Solution1319().makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}});
    }

    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        int lines = 0;
        for (int[] c : connections) {
            if (!unionFind.union(c[0], c[1])) {
                lines++;
            }
        }
        if (lines >= unionFind.setCount - 1) {
            return unionFind.setCount - 1;
        }
        return -1;
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

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
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