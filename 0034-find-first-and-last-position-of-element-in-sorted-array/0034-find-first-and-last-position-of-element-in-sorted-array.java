class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            if(nums[left] == target && nums[right]==target){
               return new int[]{left,right};
            }
            
            if(nums[mid] < target){
                left = mid+1;
            }
            
            if(nums[mid] > target){
                right= mid-1;
            }
            
            if(left>=0 && left<nums.length && nums[left] < target){
                left++;
            }
            
            if(right>=0 && right<nums.length && nums[right] > target){
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }
}