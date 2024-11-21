class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int min = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            min = Math.min(min, nums[mid]);
            
            if(nums[left] <= nums[mid]){//left side is sorted
                if(nums[left] > nums[right]){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }else{
                right = mid -1;
            }
        }
        
        return min;
    }
}