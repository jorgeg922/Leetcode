class HitCounter {
    Queue<Integer> timestamps;
    public HitCounter() {
        timestamps = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        timestamps.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int target = timestamp - 300;
        while(!timestamps.isEmpty()){
            if(timestamps.peek() <= target){
                timestamps.poll();
            }else{
                break;
            }
        }

        return timestamps.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */