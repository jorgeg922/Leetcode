class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int zeroCount = 0;
        int zeroIndex = 0;
        int total_product = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
                zeroIndex = i;
                continue;
            }
            total_product *= nums[i];
        }
        
        if(zeroCount >= 2){
            //Arrays.fill(ans,0);
            return ans;
        }else if(zeroCount == 1){
            Arrays.fill(ans, 0);
            ans[zeroIndex] = total_product;
            return ans;
        }
        
        for(int i=0; i<nums.length; i++){
            ans[i] = total_product/nums[i];
        }
        return ans;
    }
}