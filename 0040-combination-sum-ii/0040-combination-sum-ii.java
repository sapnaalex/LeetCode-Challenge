class Solution {
    public static void sort(int [] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    public static void backtrack(List<List<Integer>> res, List<Integer> temp, int [] nums, int target, int start){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;
            temp.add(nums[i]);
            backtrack(res, temp, nums, target-nums[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
}