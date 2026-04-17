class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == d) return true;

            for (int v : g.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return false;
    }
}