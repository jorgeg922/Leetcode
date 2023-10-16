class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int min = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            int current = nums[mid];
            
            if(current < min){
                min = current;
            }
            
            if(nums[mid] > nums[right]){//shift ocurred
                if(nums[mid] >= nums[left] && nums[right] < nums[left]){
                    left = mid+1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(nums[mid] < nums[right]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        
        return min;
    }
}
 
/*
[3,4,5,1,2]
[3,4,5,1,2]
[4,5,6,7,0,1,2]
[11,13,15,17]
*/
