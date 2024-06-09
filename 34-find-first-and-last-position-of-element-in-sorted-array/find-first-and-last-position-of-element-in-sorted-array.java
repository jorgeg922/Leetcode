class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};    
        }
        
        int lowerbound = lbs(nums, target);
        int upperbound = rbs(nums, target);
        
        if(nums[lowerbound] != target){
            return new int[]{-1,-1};
        }
        
        return new int[]{lowerbound,upperbound};
        
    }
    
    private int lbs(int[] nums, int target){
        int left=0;
        int right = nums.length-1;
        
        while(left < right){
            int mid = left + (right-left)/2;
            int num = nums[mid];
            
            if(num < target){
                left = mid+1;
            }else{
                right = mid;
            }
            
        }
        
        return left;
    }
 
    private int rbs(int[] nums, int target){
        int left=0;
        int right = nums.length-1;
        
        while(left < right){
            int mid = left + (right-left)/2;
            int num = nums[mid];
            
            if(num <= target){
                left = mid+1;
            }else{
                right = mid;
            }
            
        }
        
        if(nums[right] != target){
            return right -1;
        }
        return right;
    }
}