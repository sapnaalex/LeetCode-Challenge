import java.util.Arrays;

class Solution {
    public void sort(int[] nums){
        int n = nums.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        sort(nums); // O(n log n)
        
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            // OPTIMIZATION: Skip duplicate anchors
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // OPTIMIZATION: Early return on exact match
                if (currentSum == target) return target;

                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                    // OPTIONAL: Skip duplicate left values to speed up
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else {
                    right--;
                    // OPTIONAL: Skip duplicate right values to speed up
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return closestSum;
    }
}
