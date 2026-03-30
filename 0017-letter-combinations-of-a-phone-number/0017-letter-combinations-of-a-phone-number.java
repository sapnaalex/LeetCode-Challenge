class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};

        backtrack(res, "", digits, 0, map);
        return res;
    }
    public static void backtrack(List<String> res, String temp, String digits, int index, String[] map){
        if(index==digits.length()){
            res.add(temp);
            return;
        }
        String letters = map[digits.charAt(index)-'0'];
        for(char c: letters.toCharArray()){
            backtrack(res, temp+c, digits, index+1, map);
        }
    }
}