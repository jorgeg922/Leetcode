class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        
        for(int[] interval : intervals){
            pq.add(interval);
        }
        
        pq.add(newInterval);
        
        List<int[]> reformed = new ArrayList<>();
        reformed.add(pq.poll());
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            int[] prev = reformed.get(reformed.size()-1);
            
            if(curr[0] >= prev[0] && curr[1] <= prev[1]){
                continue;
            }else if(curr[0] <= prev[1]){
                prev[1] = curr[1];
            }else{
                reformed.add(curr);
            }
        }
        
        int[][] ans = new int[reformed.size()][2];
        int ptr = 0;
        for(int[] interval : reformed){
            ans[ptr++] = interval;
        }
        
        return ans;
    }
}