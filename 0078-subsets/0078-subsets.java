class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(), nums, 0);
        return result;
    }
    public static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start){
        res.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(res, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}