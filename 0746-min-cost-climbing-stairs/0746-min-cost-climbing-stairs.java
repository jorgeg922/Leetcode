class Solution {
    int[] cost;
    HashMap<Integer, Integer> memo;
    public int minCostClimbingStairs(int[] cost) {
        this.memo = new HashMap<>();
        this.cost = cost;
        return dp(cost.length); 
    }
    
    public int dp(int index){
        if(index <= 1){
            return 0;
        }
        
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        int minCost = Math.min(dp(index-1)+cost[index-1],dp(index-2)+cost[index-2]);
        
        memo.put(index, minCost);
        return minCost;
    }
}