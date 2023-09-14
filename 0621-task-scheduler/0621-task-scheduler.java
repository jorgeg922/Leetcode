class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();//store pair of -> task and time until it can be added to the pq for processing again
        HashMap<Character,Integer> freq = new HashMap<>();//store freq of each task
        
        for(char task : tasks){
            freq.put(task, freq.getOrDefault(task,0)+1);
        }
        
        for(char task : freq.keySet()){
            pq.add(freq.get(task));
        }
        
        int time = 0;
        
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int val = pq.poll();
                val--;
                if(val > 0){
                    q.add(new Pair(val,time+n));
                }
            }
            
            if(!q.isEmpty() && q.peek().getValue() == time){
                pq.add(q.poll().getKey());
            }
        }
        return time;
    }
}