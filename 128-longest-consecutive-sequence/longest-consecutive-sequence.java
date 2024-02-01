class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int count = 0;
        int longest_count = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                count = 1;
                int next = num+1;
                while(set.contains(next)){
                    count++;
                    next++;
                }
                longest_count = Math.max(longest_count,count);
            }
        }
        
        return longest_count;
    }
}