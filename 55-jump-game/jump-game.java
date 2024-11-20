class Solution {
    enum Visited{
        UNK,
        POSTIVE,
        NEGATIVE
    }
    
    public boolean canJump(int[] nums) {
        Visited[] memo = new Visited[nums.length];
        Arrays.fill(memo, Visited.UNK);
        
        return jump(nums, 0, memo);
    }
    
    public boolean jump(int[] nums, int index, Visited[] memo){
        if(memo[index] != Visited.UNK){
            return memo[index]==Visited.POSTIVE?true:false;
        }
        
        if(index == nums.length-1){
            memo[index] = Visited.POSTIVE;
            return true;
        }
        
        int maxJump = nums[index];
        
        for(int i=1; i<=maxJump; i++){
            if(index+1 < nums.length && jump(nums, index+i, memo)){
                memo[index+1]=Visited.POSTIVE;
                return true;
            }
        }
        
        memo[index] = Visited.NEGATIVE;
        return false;
    }
}