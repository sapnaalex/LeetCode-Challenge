class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(end)) return 0;

        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(begin);
        endSet.add(end);

        int steps = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> next = new HashSet<>();

            for (String word : beginSet) {
                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);

                        if (endSet.contains(newWord)) return steps + 1;

                        if (set.contains(newWord)) {
                            next.add(newWord);
                            set.remove(newWord);
                        }
                    }
                    arr[i] = old;
                }
            }

            beginSet = next;
            steps++;
        }
        return 0;
    }
}