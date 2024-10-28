class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seen = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int diff = target - num;
            if(seen.containsKey(diff)){
                return new int[]{i, seen.get(diff)};
            }
            
            seen.put(num,i);
        }
        
        return null;
    }
}