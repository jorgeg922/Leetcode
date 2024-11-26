class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        
        int[] ans = new int[nums.length];
        int zeroCount = 0;
        int zeroIndex = -1;
        int maxProduct = 1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
                zeroIndex = i;
                continue;
            }
            maxProduct *= nums[i];    
        }
        
        if(zeroCount > 1){
            return ans;
        }
        
        if(zeroCount == 1){
            ans[zeroIndex] = maxProduct;
            return ans;
        }
        
        for(int i=0; i<nums.length; i++){
            ans[i] = maxProduct/nums[i];
        }
        
        return ans;
        
        
    }
}