class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int insertPoint = 0;
        Deque<Integer> maxInWindow = new LinkedList<Integer>(); //store indexes
        
        for(int i=0; i<nums.length; i++){
            
            while(!maxInWindow.isEmpty() && nums[maxInWindow.getLast()] < nums[i]){
                maxInWindow.pollLast();
            }
            maxInWindow.addLast(i);
            if(i-maxInWindow.getFirst() >= k){
                maxInWindow.pollFirst();
            }
            if(i+1 >= k){
                ans[insertPoint++] = nums[maxInWindow.getFirst()];
            }
        }
        
        return ans;
    }
}