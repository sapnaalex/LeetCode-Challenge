class Solution {
    public List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length;
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) rev.add(new ArrayList<>());

        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            out[i] = g[i].length;
            for (int v : g[i])
                rev.get(v).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (out[i] == 0) q.add(i);

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);

            for (int v : rev.get(u)) {
                if (--out[v] == 0)
                    q.add(v);
            }
        }

        Collections.sort(res);
        return res;
    }
}