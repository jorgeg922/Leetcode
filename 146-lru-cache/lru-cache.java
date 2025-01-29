class LRUCache {
    class Node{
        Node next;
        Node prev;
        int key;
        int value;

        public Node (int key, int value){
            this.key = key;
            this.value = value;
        }
        
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    int currSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        currSize = 0;
        head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;    
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node curr = map.get(key);
        removeNode(curr);
        insertNode(curr);

        return curr.value;

    }
    
    public void put(int key, int value) {
        Node node; 
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            removeNode(node);
            currSize--;
        }else{
            node = new Node(key, value);
            //map.put(key, node);
        }

        insertNode(node);
        currSize++;

        while(currSize > capacity && tail.prev != head){
            removeNode(tail.prev);
            currSize--;
        }
    }

    public Node removeNode(Node node){
        System.out.println(node.key);
        System.out.println(node.value);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        map.remove(node.key);
        return node;
    }

    public void insertNode(Node node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
        map.put(node.key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */