package leetcode.g601_700;

class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        int[] parents = new int[length + 1];

        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < length; i++) {
            int[] edge = edges[i];
            if (find(parents, edge[0]) != find(parents, edge[1])) {
                union(parents, edge[0], edge[1]);
            } else {
                return edge;
            }
        }
        return new int[]{};
    }

    private void union(int[] parents, int x, int y) {
        parents[find(parents, x)] = find(parents, y);
    }

    private int find(int[] parents, int i) {
        if (parents[i] != i) {
            i = find(parents, parents[i]);
        }
        return parents[i];
    }
}