class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if(!hm.containsKey(sorted)){
                hm.put(sorted, new ArrayList<>());
            }
            hm.get(sorted).add(strs[i]);
        }
        return new ArrayList<List<String>>(hm.values());
    }
}