class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            int midval = nums[mid];
            if(midval==target){
                return mid;
            }
            //identify which side is sorted
            //work with the sorted side
            if(midval < nums[left]){//it means the right side is sorted
                if(target > midval && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{//the left side is sorted
                if(midval > target && target >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        
        return -1;
    }
}