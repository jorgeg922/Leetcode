class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int limit = nums.length/2;
        
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
            
            if(freq.get(num) > limit){
                return num;
            }
        }
        
        return -1;
    }
}