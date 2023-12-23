class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        
        return dp(amount,coins);
    }
    
    public int dp(int amount, int[] coins){
        if(amount == 0){
            return 0;
        }
        
        if(amount < 0){
            return -1;
        }
        
        if(memo[amount] != 0){
            return memo[amount];
        }
        
        int numberOfCoins = Integer.MAX_VALUE;
        
        for(int coin : coins){
            int res = dp(amount-coin, coins);
            if(res > -1 && res <numberOfCoins){
                 numberOfCoins = res+1; 
            }
              
        }
        
        memo[amount] = numberOfCoins;

        
        if(numberOfCoins != Integer.MAX_VALUE){
            return numberOfCoins;
        }
        
        return -1;
        
    }
}