class Solution {
    public int removeDuplicates(int[] nums) {
        
        int left = 0;
        for(int right=0; right<nums.length; right++){
            if(nums[left] != nums[right] && left<right){
                left++;
                swap(left, right, nums);
            }
        }
        
        return left+1;
    }
    
    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}