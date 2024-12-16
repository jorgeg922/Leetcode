class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer a, Integer b){
                int na = nums[a];
                int nb = nums[b];
                
                if(na == nb){
                    return a-b;
                }
                
                return nums[a]-nums[b];
            }
        });
        
        for(int i=0; i<nums.length; i++){
            pq.add(i);
        }
        
        while(k > 0){
            int minIndex = pq.poll();
            int min = nums[minIndex];
            nums[minIndex] = min * multiplier;
            pq.add(minIndex);
            k--;
        }
        
        return nums;
        
    }
}