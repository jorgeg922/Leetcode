class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            int tmp = sum + nums[i];
            sum = Math.max(tmp, nums[i]);
            max_sum = Math.max(max_sum, sum);
        }
        
        return max_sum;
    }
}