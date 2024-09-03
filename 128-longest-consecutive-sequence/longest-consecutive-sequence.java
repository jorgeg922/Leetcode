class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int max_size = 1;
        for(int entry : set){
            int current = entry;
            
            if(!set.contains(current-1)){
                int size = 1;
                int prev = current;
                while(set.contains(prev+1)){
                    size++;
                    prev++;
                }
                max_size = Math.max(max_size, size);
            }
            
            
        }
        
        return max_size;
    }
}