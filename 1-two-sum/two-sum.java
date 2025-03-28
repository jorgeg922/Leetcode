class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seenNumbers = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int numNeeded = target - nums[i];

            if(seenNumbers.containsKey(numNeeded)){
                return new int[]{seenNumbers.get(numNeeded), i};
            }

            seenNumbers.put(nums[i], i);
        }

        return null;
    }
}