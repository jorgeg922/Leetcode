class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> seenCounts = new HashMap<>();
        seenCounts.put(0,-1);
        
        int max = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            count += (nums[i]==1?1:-1);
            if(seenCounts.containsKey(count)){
                max = Math.max(max, i - seenCounts.get(count));
            }else{
                seenCounts.put(count,i);
            }
        }
        
        return max;
    
    
    }
}