class Solution {
    int[] prefixSum;
    int pf;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        pf = 0;
        for(int i=0; i<w.length; i++){
            pf += w[i];
            prefixSum[i] = pf;
        }
    }
    
    public int pickIndex() {
        double target = pf * Math.random();
        for(int i=0; i<prefixSum.length; i++){
            if(prefixSum[i] > target){
                return i;
            }
        }
        
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */