class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        return dfs(g, s, d, vis);
    }

    boolean dfs(List<List<Integer>> g, int u, int d, boolean[] vis) {
        if (u == d) return true;
        vis[u] = true;

        for (int v : g.get(u)) {
            if (!vis[v] && dfs(g, v, d, vis)) return true;
        }
        return false;
    }
}