class Solution {
    public int arrangeCoins(int n) {
        int res = 0;
        int i=1;
        while(n >= i){
            res++;
            n-=i;
            i++;
        }
        
        return res;
    }
}