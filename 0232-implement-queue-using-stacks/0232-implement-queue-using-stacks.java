class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> holder = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while(!stack.isEmpty()){
            holder.push(stack.pop());
        }
        
        int ans = holder.pop();
        
        while(!holder.isEmpty()){
            stack.push(holder.pop());
        }
        
        return ans;
    }
    
    public int peek() {
        while(!stack.isEmpty()){
            holder.push(stack.pop());
        }
        
        int ans = holder.peek();
        
        while(!holder.isEmpty()){
            stack.push(holder.pop());
        }
        
        return ans;
        
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */