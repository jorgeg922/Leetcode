class Solution {
    HashMap<Integer,Boolean> memo = new HashMap<>();
    public boolean canJump(int[] nums) {
        return dp(0, nums);
    }
    
    public boolean dp(int index, int[] nums){
        if(index >= nums.length-1){
            memo.put(index, true);
            return true;
        }
        
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        
        if(nums[index] == 0){
            memo.put(index, false);
            return false;
        }
        
        int jump = nums[index];
        while(jump >= 1){
            if(dp(index+jump, nums)){
                memo.put(index,true);
                return true;
            }
            jump--;
        }
        
        memo.put(index, false);
        return false;
    }
}