class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,new ArrayList<>(), nums, result);
        return result;
    }
    public static void backtrack(int start, List<Integer> temp, int[] nums, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(i+1, temp, nums, res);
            temp.remove(temp.size()-1);
        }
    }
}