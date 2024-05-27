class Solution {
    public int specialArray(int[] nums) {                
        Arrays.sort(nums);
        int x = 0;
        int current_index = 0;
        
        if(nums[0] == nums[nums.length-1] && nums[0] == nums.length){
            return nums[0];
        }
        
        while(x < nums[nums.length-1]){
            int nums_greater = nums.length - current_index;
            if(x == nums_greater){
                return x;
            }
            
            while(nums[current_index] == x){
                current_index++;
            }
            
            x++;           
        }
        
        return -1;
        
    }
}