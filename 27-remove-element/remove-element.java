class Solution {
    public int removeElement(int[] nums, int val) {
       int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
            if(nums[left] == val){
                swap(left, right, nums);
                right--;
                continue;
            }
            
            left++;
        }
        
        return left;
    }
    
    public void swap(int a, int b, int[] nums){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}