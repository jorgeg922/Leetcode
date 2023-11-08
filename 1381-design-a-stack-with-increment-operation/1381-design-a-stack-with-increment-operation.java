class CustomStack {
    int[] stack;
    int ptr=0;
    int maxSize;
    int currentSize;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        int currentSize = 0;
        stack = new int[maxSize];
        ptr = 0;
    }
    
    public void push(int x) {
       if(currentSize < maxSize){
           stack[ptr++] = x;
           currentSize++;
       }
    }
    
    public int pop() {
        if(currentSize == 0){
            return -1;
        }
        
        int top = stack[ptr-1];
        ptr--;
        currentSize--;
        return top;
    }
    
    public void increment(int k, int val) {
        int num = Math.min(k, currentSize);
        
        for(int i=0; i<num; i++){
            stack[i] += val;
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