class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> grouping = new ArrayList<>();
        grouping.add(nums[0]);
        
        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            if(num <= grouping.get(grouping.size()-1)){
                int index = bs(grouping,num);
                grouping.set(index,num);
            }else{
                grouping.add(num);
            }
        }
        
        return grouping.size();
    }
    
    public int bs(List<Integer> grouping, int num){
        int target = num;
        int left = 0;
        int right = grouping.size()-1;
        
        while(left < right){
            int mid = left + (right - left)/2;
            
            if(grouping.get(mid) == num){
                return mid;
            }
            
            if(grouping.get(mid) > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}