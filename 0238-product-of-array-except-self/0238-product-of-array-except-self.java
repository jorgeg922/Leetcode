class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int zero_count = 0;
        int last_zero_index = -1;
        int max_prod = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zero_count+=1;
                last_zero_index = i;
                continue;
            }
            max_prod *= nums[i];
        }
        
        if(zero_count > 1){
            Arrays.fill(ans,0);
            return ans;
        }
        
        if(zero_count == 1){
            Arrays.fill(ans,0);
            ans[last_zero_index] = max_prod;
            return ans;
        }
        
        for(int i=0; i<ans.length; i++){
            ans[i] = max_prod/nums[i];
        }
        
        return ans;
        
        
    }
}