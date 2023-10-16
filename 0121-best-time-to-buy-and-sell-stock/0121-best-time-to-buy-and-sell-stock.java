class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max_profit = 0;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            
            if(i > 0){
                max_profit = Math.max(max_profit, prices[i] - min);
            }
        }
        
        return max_profit;
    }
}