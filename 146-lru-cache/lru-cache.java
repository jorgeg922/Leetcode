class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int value;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    
    Node head;
    Node tail;
    Map<Integer, Node> nodes;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        nodes = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(nodes.containsKey(key)){
            removeNode(nodes.get(key));
            moveToFront(nodes.get(key));
            return nodes.get(key).value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if(nodes.containsKey(key)){
            node = nodes.get(key);
            node.value = value;
            removeNode(node);
        }else{
            node = new Node(key,value);
            nodes.put(key, node);
        }
        
        moveToFront(node);
        
        if(nodes.size() > capacity){
            Node lastNode = removeNode(tail.prev);
            nodes.remove(lastNode.key);
        }
    }
    
    public void moveToFront(Node node){
        if(node.prev == head){
            return;
        }
        
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public Node removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */