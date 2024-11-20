class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int ptr = 0;
        Deque<Integer> window = new LinkedList<>();
     
        for(int right=0; right<nums.length; right++){
            while(!window.isEmpty() && nums[window.getLast()] < nums[right]){
                window.pollLast();
            }
            
            window.addLast(right);
            
            if(window.getLast()-window.getFirst() >= k){
                window.pollFirst();
            }
            
            if(right >= k-1){
                ans[ptr++] = nums[window.getFirst()];
            }
        }
        
        return ans;
    }
}