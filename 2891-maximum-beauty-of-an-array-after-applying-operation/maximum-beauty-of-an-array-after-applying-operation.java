class Solution {
    public int maximumBeauty(int[] nums, int k) {
        //if(nums.length == 1){
        //    return 1;
        //}
        
        int maxValue = 0;
        
        for(int num : nums){
            maxValue = Math.max(maxValue, num);
        }
        
        int[] tmp = new int[maxValue+1];
        
        for(int num : nums){
            tmp[Math.max(0,num-k)]++;
            tmp[Math.min(maxValue, num+k+1)]--;
        }
        
        int maxSeq = 0;
        int runningSum = 0;
        for(int val : tmp){
            runningSum += val;
            maxSeq = Math.max(maxSeq, runningSum);
        }
        
        return maxSeq==0?1:maxSeq;
    }
}