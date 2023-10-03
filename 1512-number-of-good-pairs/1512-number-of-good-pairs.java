class Solution {
    public int numIdenticalPairs(int[] nums) {
        int numPairs = 0;
        HashMap<Integer,Integer> count = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            numPairs += count.getOrDefault(nums[i],0);
            count.put(nums[i], count.getOrDefault(nums[i],0)+1);
        }
        
        return numPairs;
    }
}