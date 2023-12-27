class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            int val = nums[mid];
            
            if(val == target){
                return mid;
            }
            
            if(val < nums[left]){
               if(target > val && target <= nums[right]){
                   left = mid + 1;
               }else{
                   right = mid - 1;
               }
            }else{
                if(val > target && target >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid+1;
                }
            }
        }
        
        return -1;
    }
}