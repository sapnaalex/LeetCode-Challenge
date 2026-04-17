class Solution {
    public boolean isBipartite(int[][] g) {
        int n = g.length;
        int[] color = new int[n]; // 0=uncolored, 1/-1 = colors

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int u = q.poll();

                for (int v : g[u]) {
                    if (color[v] == 0) {
                        color[v] = -color[u];
                        q.add(v);
                    } else if (color[v] == color[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}