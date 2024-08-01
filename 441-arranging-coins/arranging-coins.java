class Solution {
    public int arrangeCoins(int n) {
        int remainingCoins = n;
        int step = 1;
        while(remainingCoins >= step){
            remainingCoins -= step;
            step++;
        }
        
        return step-1;
    }
}