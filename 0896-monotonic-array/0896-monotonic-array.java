class Solution {
    public boolean isMonotonic(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        if(nums[left] < nums[right]){
            return verify(left,1,nums);
        }else{
            return verify(left,-1,nums);
        }
    }
    
    public boolean verify(int index, int direction, int[] nums){
        
        for(int i = index+1; i<nums.length; i++){
            switch(direction){
                case -1:
                    if(nums[i] > nums[index]){
                        return false;
                    }
                    break;
                case 1:
                    if(nums[i] < nums[index]){
                        return false;
                    }
                    break;
            }
            index++;
        }
        
        return true;
    }
}