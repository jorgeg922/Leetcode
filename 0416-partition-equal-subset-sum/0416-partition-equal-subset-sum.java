class Solution {
    int total = 0;
    public boolean canPartition(int[] nums) {
        for(int num : nums){
            total += num;
        }
        
        if(total%2 != 0){
            return false;
        }
        
        Boolean[][] mem = new Boolean[nums.length][(total/2)];
       
        return dp(0,0,nums,mem);
    }
    
    public boolean dp(int index, int runningSum, int[] nums, Boolean[][] mem){
        if(runningSum == total/2){
            return true;
        }
        
        if(index == nums.length || runningSum > total/2){
            return false;
        }
               
        if(mem[index][runningSum] != null){
            return mem[index][runningSum];
        }
        
        boolean result = dp(index+1, runningSum+nums[index], nums, mem) || 
                        dp(index+1, runningSum, nums, mem);
        
        mem[index][runningSum] = result;
        return result;
    }
}