class LRUCache {
    public class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        
        public void setValue(int value){
            this.value = value;
        }
    }
    
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    int size;
    
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {        
        if(!map.containsKey(key)){
            return -1;
        }
        Node curr = map.get(key);
        removeNode(curr);
        insertToEnd(curr);
        return curr.value;
        
    }
    
    public void put(int key, int value) {
        Node curr;
        if(!map.containsKey(key)){
            curr = new Node(key, value);
            map.put(key, curr);
        }else{
            curr = map.get(key);
            curr.setValue(value);
            removeNode(curr);
        }
        
       
        insertToEnd(curr);
        
        if(map.size() > capacity){
            Node remove = head.next;
            removeNode(remove);
            map.remove(remove.key);
        }
    }
    
    public void insertToEnd(Node node){
        Node prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        prev.next = node;
        node.prev = prev;
    }
    
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */