class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        for(int[] interval : intervals){
            pq.add(interval);
        }
        
        Deque<int[]> dq = new LinkedList<>();
        
        while(!pq.isEmpty()){
            if(dq.isEmpty()){
                dq.addLast(pq.poll());
                continue;
            }    
            
            int[] curr = pq.poll();
            if(dq.peekLast()[1] < curr[0]){
                dq.addLast(curr);
            }else if(dq.peekLast()[1] < curr[1]){
                dq.peekLast()[1] = curr[1];
            }
        }
        
        int[][] ans = new int[dq.size()][2];
        int ptr = 0;
        
        while(!dq.isEmpty()){
            ans[ptr++] = dq.pollFirst();
        }
        return ans;
    }
}