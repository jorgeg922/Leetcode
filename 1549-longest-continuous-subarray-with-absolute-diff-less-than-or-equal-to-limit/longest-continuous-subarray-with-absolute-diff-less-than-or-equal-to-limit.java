class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        int left = 0;
        int len = 0;
        
        for(int right=0; right<nums.length; right++){
            while(!maxQ.isEmpty() && nums[right] > maxQ.peekLast()){
                maxQ.pollLast();               
            }
            maxQ.addLast(nums[right]);
            while(!minQ.isEmpty() && nums[right] < minQ.peekLast()){
                minQ.pollLast();
            }
            minQ.addLast(nums[right]);
            
            if(maxQ.peekFirst() - minQ.peekFirst() > limit){
                if(nums[left] == maxQ.peekFirst()){
                    maxQ.pollFirst();
                }
                if(nums[left] == minQ.peekFirst()){
                    minQ.pollFirst();
                }
                left++;
            }
            
            len = Math.max(len, right - left + 1);
        }
        
        return len;
    }
}