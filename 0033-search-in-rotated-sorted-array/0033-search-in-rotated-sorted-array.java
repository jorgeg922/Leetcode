class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            int mid_val = nums[mid];
            
            if(mid_val == target){
                return mid;
            }
            
            if(nums[left] <= mid_val){
                if(target < mid_val && target >= nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target > mid_val && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        
        return -1;
    }
}