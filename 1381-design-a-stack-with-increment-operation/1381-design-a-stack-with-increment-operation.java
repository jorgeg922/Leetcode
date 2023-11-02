class CustomStack {
    LinkedList<Integer> ll;
    int maxSize;
    
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.ll = new LinkedList<>();
    }
    
    public void push(int x) {
        if(ll.size() < maxSize){
            ll.addLast(x);
        }
    }
    
    public int pop() {
        if(ll.isEmpty()){
            return -1;
        }
        return ll.pollLast();
    }
    
    public void increment(int k, int val) {
        if(ll.size() < k){
            k = ll.size();
        }
        
        for(int i=0; i<k; i++){
            ll.set(i,ll.get(i)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */