class Solution {
    public int maxSubArray(int[] nums) {
        
        int max_sum = nums[0];
        int sum = nums[0];
        
        for(int i=1; i<nums.length; i++){
            sum = Math.max(sum + nums[i], nums[i]);
            max_sum = Math.max(max_sum, sum);
            
        }
        
        return max_sum;
    }
}