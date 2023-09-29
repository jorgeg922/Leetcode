class Solution {
    public boolean isMonotonic(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        if(nums[left] < nums[right]){
            for(int i = left+1; i<nums.length; i++){
                if(nums[i] < nums[left]){
                    return false;
                }
                left++;
            }
        }else{
            for(int i = left+1; i<nums.length; i++){
                if(nums[i] > nums[left]){
                    return false;
                }
                left++;
            }
        }
        
        return true;
    }
}