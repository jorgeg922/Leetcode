class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        boolean seenZero = false;
        int seenZeroIndex = -1;
        
        for(int right=0; right<len; right++){
            int curr = nums[right];
            if(curr == 0 && !seenZero){
                seenZero = true;
                seenZeroIndex = right;
            }
            
            if(right < len && seenZero && curr != 0){
                swap(right, seenZeroIndex, nums);
                seenZeroIndex++;
            }
        }
        
    }
    
    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}