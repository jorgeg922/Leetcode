class Solution {
    public int maxProfit(int[] prices) {
        int bestPrice = Integer.MAX_VALUE;
        int bestProfit = Integer.MIN_VALUE;
        
        for(int price : prices){
            if(price < bestPrice){
                bestPrice = price;
                continue;
            }
            
            bestProfit = Math.max(bestProfit, price-bestPrice);
        }
        
        return bestProfit==Integer.MIN_VALUE?0:bestProfit;
    }
}