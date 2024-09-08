class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
                continue;
            }
            
            profit+= prices[i] - minPrice;
            minPrice = prices[i];
        }
        
        return profit;
        
    }
}