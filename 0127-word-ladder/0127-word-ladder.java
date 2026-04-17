class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(end)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(begin);
        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String word = q.poll();
                if (word.equals(end)) return steps;

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String next = new String(arr);

                        if (set.contains(next)) {
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    arr[i] = old;
                }
            }
            steps++;
        }
        return 0;
    }
}