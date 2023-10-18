class HitCounter {
    ArrayList<Integer> hits;
    public HitCounter() {
        hits = new ArrayList<>();
    }
    
    public void hit(int timestamp) {
        hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        if(hits.size() == 0){
            return 0;
        }
        int target = timestamp;
        int left = 0;
        int right = hits.size()-1;
        
        while(left < right){
            int mid = left + (right - left)/2;
            
            if(hits.get(mid) > target){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        
        int cutoff = timestamp - 300;
        int total = 0;
        while(left >= 0 && hits.get(left) > cutoff){
            total+=1;
            left--;
        }
        
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */