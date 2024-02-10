class Solution {
    HashMap<Integer,Boolean> memo = new HashMap<>();
    public boolean canJump(int[] nums) {
        return dp(0, nums);
    }
    
    public boolean dp(int index, int[] nums){
        if(index == nums.length-1){
            return true;
        }
        
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        
        int jump = nums[Math.min(index,nums.length-1)];
        while(jump >= 1){
            if(index+jump <= nums.length -1 && dp(index+jump, nums)){
                return true;
            }
            jump--;
        }
        
        memo.put(index, false);
        return false;
    }
}