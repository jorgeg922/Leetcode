class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        int curr_sum = 0;
        int max = 0;
        for(int right=0; right<nums.length; right++){
            int target = nums[right];
            curr_sum += target;
            
            while((right-left+1) * target - curr_sum > k){                
                curr_sum -= nums[left];
                left++;
            }
            
            max = Math.max(max,right-left+1);
        }
        
        return max;
    }
}