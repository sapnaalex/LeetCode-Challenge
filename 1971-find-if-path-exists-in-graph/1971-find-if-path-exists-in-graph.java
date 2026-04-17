class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;

        for (int[] e : edges)
            union(p, e[0], e[1]);

        return find(p, s) == find(p, d);
    }

    int find(int[] p, int x) {
        if (p[x] != x) p[x] = find(p, p[x]);
        return p[x];
    }

    void union(int[] p, int a, int b) {
        p[find(p, a)] = find(p, b);
    }
}