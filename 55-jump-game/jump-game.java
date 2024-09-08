enum Visited{
    GOOD, BAD, UNK
}
class Solution {
    int[] nums;
    int len;
    Visited[] memo;
    public boolean canJump(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        this.memo = new Visited[len];
        Arrays.fill(memo, Visited.UNK);
        return jump(0);
    }
    
    public boolean jump(int index){
        if(index >= len-1){
            memo[index]=Visited.GOOD;
            return true;
        }
        
        if(memo[index] != Visited.UNK){
            return memo[index]==Visited.GOOD?true:false;
        }
        
        int maxJump = nums[index];
        
        for(int i=1; i<= maxJump; i++){
            if(jump(index+i)){
                memo[index+i]=Visited.GOOD;
                return true;
            }
        }
        
        memo[index] = Visited.BAD;
        return false;
    }
}