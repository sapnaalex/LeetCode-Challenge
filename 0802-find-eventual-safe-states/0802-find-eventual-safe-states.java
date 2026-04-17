class Solution {
    public List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length;
        int[] vis = new int[n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++)
            if (dfs(g, i, vis)) res.add(i);

        return res;
    }

    boolean dfs(int[][] g, int u, int[] vis) {
        if (vis[u] != 0) return vis[u] == 2;

        vis[u] = 1;

        for (int v : g[u])
            if (!dfs(g, v, vis)) return false;

        vis[u] = 2;
        return true;
    }
}