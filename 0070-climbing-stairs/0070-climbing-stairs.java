class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dp(n);
    }
    
    public int dp(int n){
        if(n<=1){
            return 1;
        }
        
        if(memo[n] != -1){
            return memo[n];
        }
        
        int ways = 0;
        
        ways += dp(n-1) + dp(n-2);
        
        memo[n] = ways;
        return ways;
    }
}