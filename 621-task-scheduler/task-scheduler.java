class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); //(task num, time)
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        
        for(int task : tasks){
            freq.put(task, freq.getOrDefault(task,0)+1);
        }
        
        for(int fr : freq.values()){
            pq.add(fr);
        }
        
        int time = 1;
        while(!pq.isEmpty() || !q.isEmpty()){
           
            if(!pq.isEmpty()){
                int curr = pq.poll();
                curr-= 1;
                if(curr > 0){
                    q.add(new Pair(curr, time + n));
                }
            }

            if(!q.isEmpty() && time == q.peek().getValue()){
                pq.add(q.poll().getKey());
            }
            time++; 
        }
        
        return time-1;
        
    }
}