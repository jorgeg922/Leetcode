class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int leftmost=0; leftmost<nums.length-2; leftmost++){
            if(leftmost==0 || nums[leftmost] != nums[leftmost-1]){
                int left = leftmost+1;
                int right = nums.length-1;
                while(left < right){
                    if(nums[leftmost] + nums[left] + nums[right] == 0){
                        ans.add(Arrays.asList(nums[leftmost], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left > 0 && left < nums.length && nums[left] == nums[left-1]){
                            left++;
                        }
                        
                        while(right < nums.length-1 && right >= 0 && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if(nums[left] + nums[right] + nums[leftmost] > 0){
                        right--;
                    }else{
                        left++;
                    }                                       
                }
            }            
        }
        return ans;
    }
}