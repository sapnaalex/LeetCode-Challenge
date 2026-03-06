class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }
    public int quickSelect(int[] arr, int start, int end, int k){
        int pivotIndex = partition(arr,start,end);
            if(k<arr.length-pivotIndex){
                return quickSelect(arr, pivotIndex+1, end, k);
            }else if(k>arr.length-pivotIndex){
                return quickSelect(arr, start, pivotIndex-1, k);
            }
            return arr[pivotIndex];
        
    }
    public int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start;
        int j = end-1;
        while(i<=j){
            while(i<=j && arr[i]<pivot){
                i++;
            }
            while(i<=j && arr[j]>pivot){
                j--;
            }
            if(i<=j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr, i, end);
        return i;
    }
    public void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}