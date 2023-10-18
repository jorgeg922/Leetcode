class HitCounter {
    Deque<Pair<Integer,Integer>> hits;
    int totalHits;
    public HitCounter() {
        hits = new LinkedList<>();
        totalHits = 0;
    }
    
    public void hit(int timestamp) {
        if(hits.isEmpty() || hits.getLast().getKey() != timestamp){
            hits.addLast(new Pair<Integer,Integer>(timestamp,1));
            totalHits+=1;
            return;
        }
        
        int prevHits = hits.getLast().getValue();
        hits.removeLast();
        hits.addLast(new Pair<Integer,Integer>(timestamp,prevHits+1));
        totalHits+=1;
    }
    
    public int getHits(int timestamp) {
        while(!hits.isEmpty()){
            int diff = timestamp - hits.peekFirst().getKey();
            
            if(diff >= 300){
                totalHits -= hits.peekFirst().getValue();
                hits.removeFirst();
            }else{
                break;
            }
        }
        
        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */