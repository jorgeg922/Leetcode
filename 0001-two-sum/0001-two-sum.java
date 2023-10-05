class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> seen = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int needNum = target - nums[i];
            if(seen.containsKey(needNum)){
                return new int[]{seen.get(needNum),i};
            }
            seen.put(nums[i],i);
        }
        
        return null;
    }
}