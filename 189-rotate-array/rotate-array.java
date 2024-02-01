class Solution {
    public void rotate(int[] nums, int k) {
        int kt = k % nums.length;       
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,kt-1);
        reverse(nums,kt,nums.length-1);
    }
    
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }
}