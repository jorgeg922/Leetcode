class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Node head;
    Node tail;
    int capacity;
    int currSize;
    HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        currSize = 0;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);           
            moveToFront(curr);
            return curr.value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        Node curr;
        if(map.containsKey(key)){
            curr = map.get(key);
            curr.value = value;
            moveToFront(curr);
        }else{
            curr = new Node(key, value);
            map.put(key, curr);
            addToList(curr);
            currSize++;
        }
        
        if(currSize > capacity){
            removeLast();
            currSize--;
        }
        
    
        
    }
    
    private void moveToFront(Node node){
        if(head.next == node){
            return;
        }
        
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        
        addToList(node);
        
    }
    
    private void removeLast(){
        Node last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        map.remove(last.key);
    }
    
    private void addToList(Node node){
        Node oldfront = head.next;
        head.next = node;
        node.prev = head;
        node.next = oldfront;
        oldfront.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */