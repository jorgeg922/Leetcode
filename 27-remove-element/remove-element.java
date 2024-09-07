class Solution {
    public int removeElement(int[] nums, int val) {        
        int left=0;
        int right=nums.length-1;
        
        while(left <= right){
            //while(nums[right] == val && right > left){
            //    right--;
            //}
            
            if(nums[left] == val){
                swap(nums, left, right);
                right--;
                continue;
            }
            
            left++;
        }
        
        
        return left;
    }
    
    
    
    public void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}