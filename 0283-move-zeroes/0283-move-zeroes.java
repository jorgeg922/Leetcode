class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length-1;
        
        for(int i=len; i>=0; i--){
            if(nums[i] == 0 && i < len){
                swap(i,nums);
            }
        }       
    }
    
    public void swap(int index, int[] nums){
        while(index < nums.length-1 && nums[index+1] != 0){
            int tmp = nums[index+1];
            nums[index+1] = nums[index];
            nums[index] = tmp;
            index++;
        }
    }
}