class Solution {
    int[] nums;
    public void nextPermutation(int[] nums) {
        this.nums = nums;
        int inflectionPt = nums.length-2;
        
        while(inflectionPt >= 0){
            if(nums[inflectionPt] < nums[inflectionPt+1]){
                break;
            }
            inflectionPt--;
        }
        
        
        if(inflectionPt >= 0){
            int nextHighest = nums.length-1;
            while(nums[nextHighest] <=  nums[inflectionPt]){
                nextHighest--;
            }        
            swap(inflectionPt, nextHighest);
        }
      
        reverse(inflectionPt+1, nums.length-1);
    }
        
    public void swap(int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    
    public void reverse(int left, int right){
        while(left < right){
            swap(left, right);
            left++;
            right--;
        }
    }
}