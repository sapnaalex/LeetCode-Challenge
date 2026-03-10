class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int i=0;
        int j = height.length-1;
        while(i<j){
            int wid = j-i;
            int h = Math.min(height[i], height[j]);
            int water = wid*h;
            maxWater = water>maxWater?water:maxWater;
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxWater;
    }
}