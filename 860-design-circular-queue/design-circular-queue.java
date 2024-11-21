class MyCircularQueue {
    int[] array;
    int k;
    int front;
    int rear;
    int currSize;
    public MyCircularQueue(int k) {
        array = new int[k];
        this.k = k;
        front = 0;
        rear = -1;
        currSize = 0;
        Arrays.fill(array,-1);
    }
    
    public boolean enQueue(int value) {
        if(currSize < k){
            if(rear == k-1){
                rear = -1;
            }
            
            rear++;
            
            array[rear] = value;
            currSize++;
            return true;
        }
        
        return false;
       
    }
    
    public boolean deQueue() {
        if(currSize == 0){
            return false;
        }
        
        array[front] = -1;
        currSize--;
        
        if(rear == -1){
            front=0 ;
        }else{
            front++;
        }
        if(front == k){
            front = 0;
        }
        return true;
    }
    
    public int Front() {
        if(currSize == 0){
            return -1;
        }
        return array[front];
    }
    
    public int Rear() {
        if(currSize == 0){
            return -1;
        }
        return array[rear];
    }
    
    public boolean isEmpty() {
        return currSize==0?true:false;
    }
    
    public boolean isFull() {
        return currSize==k?true:false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */