enum Visited{
    GOOD, BAD, UNK
}

class Solution {
    int[] nums;
    Visited[] memo;
    public boolean canJump(int[] nums) {
        this.memo = new Visited[nums.length];
        Arrays.fill(memo, Visited.UNK);
        this.nums = nums;
        return dp(0);
    }
    
    public boolean dp(int index){
        if(index >= nums.length-1){
            memo[index] = Visited.GOOD;
            return true;
        }
        
       if(memo[index] != Visited.UNK){
            return memo[index]==Visited.GOOD ? true:false;
        }
        
        if(nums[index] == 0){
            memo[index] = Visited.BAD;
            return false;
        }
        
        boolean reached = false;
        
        for(int i=1; i<=nums[index]; i++){
           if(dp(index+i)){
               memo[index] = Visited.GOOD;
               return true;
           }
        }
        
        memo[index] = Visited.BAD;
        return false;
    }
}