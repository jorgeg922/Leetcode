class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[left] != nums[i] && left < i){
                left++;
                int tmp = nums[left];
                nums[left] = nums[i];
                nums[i] = tmp;
                
            }
        }

        return left+1;
    }
}