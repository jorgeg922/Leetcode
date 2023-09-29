class Solution {
    public boolean isMonotonic(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        if(nums[left] < nums[right]){
            return verifyMonotonic(1,nums);
        }else{
            return verifyMonotonic(-1,nums);
        }
    }
    
    public boolean verifyMonotonic(int direction, int[] nums){
        int prev = 0;
        for(int i = prev+1; i<nums.length; i++){
            switch(direction){
                case -1:
                    if(nums[i] > nums[prev]){
                        return false;
                    }
                    break;
                case 1:
                    if(nums[i] < nums[prev]){
                        return false;
                    }
                    break;
            }
            prev++;
        }
        
        return true;
    }
}