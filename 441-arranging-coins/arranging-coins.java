class Solution {
    public int arrangeCoins(int n) {
        int remainingCoins = n;
        int steps = 0;
        
        while(remainingCoins >= steps){
            remainingCoins -= steps;
            steps++;
        }
        
        return steps-1;
    }
}