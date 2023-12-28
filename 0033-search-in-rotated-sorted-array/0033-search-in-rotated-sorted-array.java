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
            
            if(mid_val < nums[left]){
                if(mid_val < target && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                if(mid_val > target && target >= nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        
        return -1;
    }
}