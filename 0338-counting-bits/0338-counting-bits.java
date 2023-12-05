class Solution {
    public int[] countBits(int n) {
        //111111111111111
        //10
        int[] ans = new int[n+1];
        
        for(int i=0; i<=n; i++){
            int curr = i;
            int ones = 0;
            while(curr != 0){
                if((curr & 1) == 1){
                    ones++;
                }
                
                curr >>= 1;
            }
            
            ans[i] = ones;
        }
        
        return ans;
    }
}