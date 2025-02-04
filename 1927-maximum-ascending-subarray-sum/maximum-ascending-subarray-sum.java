class Solution {
    public int maxAscendingSum(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int maxSum = nums[0];
        int runningSum = maxSum;
        for(int i=1; i<nums.length; i++){
            if(nums[i] <= nums[i-1]){
                maxSum = Math.max(maxSum, runningSum);
                runningSum = nums[i];
            }else{
                runningSum += nums[i];
            }
        }

        maxSum = Math.max(maxSum, runningSum);

        return maxSum;
    }
}