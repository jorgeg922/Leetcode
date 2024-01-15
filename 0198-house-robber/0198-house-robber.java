class Solution {
    int[] nums;
    int size;
    public int rob(int[] nums) {
        this.nums = nums;
        size = nums.length;
        int[] mem = new int[size];
        Arrays.fill(mem,-1);
        
        return dp(0,mem);
    }
    
    public int dp(int i, int[] mem){
        if(i == size-1){
            return nums[i];
        }
        
        if(i+2 == size){
            return Math.max(nums[i], nums[i+1]);
        }
        
        if(mem[i] != -1){
            return mem[i];
        }
        
        int maxProfit = Math.max(dp(i+1,mem), dp(i+2,mem) + nums[i]);
    
        mem[i] = maxProfit;
        return mem[i];
    }
}