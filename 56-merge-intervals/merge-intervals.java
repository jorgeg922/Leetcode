class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        Deque<int[]> q = new LinkedList<>();

        for(int[] interval : intervals){
            pq.add(interval);
        }

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(q.size() == 0){
                q.addLast(curr);
            }else{
                int[] prev = q.peekLast();

                if(curr[0] <= prev[1]){
                    prev[1] = Math.max(prev[1], curr[1]);
                }else{
                    q.addLast(curr);
                }
            }
        }

        int[][] ans = new int[q.size()][2];
        int ptr = 0;

        while(!q.isEmpty()){
            ans[ptr++] = q.poll();
        }

        return ans;
    }
}