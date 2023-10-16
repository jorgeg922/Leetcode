class Solution {
    public int arrangeCoins(int n) {
        int blocks = 1;
        int completed = 0;
        while(n > 0 && n >= blocks){
            n -= blocks;
            completed++;
            blocks++;
        }
        
        return completed;
    }
}