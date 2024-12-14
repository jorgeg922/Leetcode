class Solution {
    public long continuousSubarrays(int[] nums) {
        long count = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> nums[b]- nums[a]);
        PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> nums[a]- nums[b]);
       
        int left=0;
        int right=0;
        
        while(right < nums.length){
            max.add(right);
            min.add(right);
            
            while(left < right && nums[max.peek()] - nums[min.peek()] > 2){
                left++;
                
                while(!max.isEmpty() && max.peek() < left){
                    max.poll();
                }
                
                while(!min.isEmpty() && min.peek() < left){
                    min.poll();
                }
            }
            
            count += right-left+1;
            right++;
        }
        
        return count;
    }
}