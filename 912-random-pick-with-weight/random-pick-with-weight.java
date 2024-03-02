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
        
        int left = 0;
        int right = prefixSum.length-1;
        
        while(left < right){
            int mid = left + (right-left)/2;
            
            if(prefixSum[mid] <= target){
                left++;
            }else{
                right--;
            }
        }
        
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */