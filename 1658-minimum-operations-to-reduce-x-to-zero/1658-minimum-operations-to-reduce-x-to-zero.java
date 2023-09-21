class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int num : nums){
            total += num;
        }
        int n= nums.length;
        int left=0;
        int max_len = -1;
        int current = 0;
        
        for(int right=0; right<n; right++){
            current += nums[right];
            
            while(current > total - x && left <= right){
                current -= nums[left];
                left++;
            }
            
            if(current == total - x){
                max_len = Math.max(max_len, right-left+1);
            }
        }
        
        return max_len != -1 ? n - max_len : -1;
        
    }
}