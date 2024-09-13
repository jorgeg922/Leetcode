class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] bounds = new int[] {-k,k};
        Map<Integer,Long> drag = new HashMap<>();
        long maxSum = Long.MIN_VALUE;
        long sumTil = 0;
        for(int i=0; i<nums.length; i++){           
            drag.put(nums[i], Math.min(drag.getOrDefault(nums[i], Long.MAX_VALUE),sumTil));
            
            sumTil += nums[i];
                     
            for(int bound : bounds){
                if(drag.containsKey(nums[i]+bound)){
                    maxSum = Math.max(maxSum, sumTil - drag.get(nums[i]+bound));
                }
                
            }     
           
        }
        
        return maxSum != Long.MIN_VALUE?maxSum:0;
    }
}