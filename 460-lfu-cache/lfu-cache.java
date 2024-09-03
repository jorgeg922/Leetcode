class LFUCache {
    class Node{
        Node prev;
        Node next;
        int freq;
        int key;
        int val;
        int timeOfInsertion;
        public Node(int key, int val, int timeOfInsertion){
            this.key = key;
            this.val = val;
            this.freq = 1;
            this.timeOfInsertion = timeOfInsertion;
        }
        
        public void setVal(int val){
            this.val = val;
        }
        
        public void increaseFreq(){
            this.freq++;
        }
        
        public int getFreq(){
            return this.freq;
        }
        
        public int getKey(){
            return this.key;
        }
        
        public int getVal(){
            return this.val;
        }
    }
    
    Node head;
    Node tail;
    int capacity;
    int size;
    Map<Integer, Node> nodes;
    PriorityQueue<Node> pq;
    int timeOfInsertion;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        //head = new Node(-1,-1);
        //tail = new Node(-1,-1);
        nodes = new HashMap<>();
        pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Node a, Node b){
                if(a.getFreq() == b.getFreq()){
                    return a.timeOfInsertion - b.timeOfInsertion;
                }
                return a.getFreq() - b.getFreq();
            }
        });
        
        //head.next = tail;
        //tail.prev = head;
        timeOfInsertion = 0;
    }
    
    public int get(int key) {
        if(!nodes.containsKey(key)){
            return -1;
        }
        timeOfInsertion +=1;
        Node curr = nodes.get(key);
        curr.increaseFreq();
        curr.timeOfInsertion = timeOfInsertion;
        pq.remove(curr);
        pq.add(curr);
        return curr.getVal();
    }
    
    public void put(int key, int value) {
        Node curr;
        if(nodes.containsKey(key)){
            curr = nodes.get(key);
            curr.setVal(value);
            curr.increaseFreq();
            pq.remove(curr);
            pq.add(curr);
            return;
        }
        
        timeOfInsertion += 1;
        curr = new Node(key,value, timeOfInsertion);        
        nodes.put(key, curr);
        size++;
        if(size > capacity){
            Node lf = pq.poll();
            nodes.remove(lf.getKey());
            size--;
        }
        pq.add(curr);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */