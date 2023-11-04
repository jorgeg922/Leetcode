class AllOne {
    class Node{
        Node l;
        Node r;
        int count;
        Set<String> set = new HashSet<String>();
        public Node(String key, int count){
            this.count = count;            
            this.set.add(key);
        }
        
        public void removeNode(){
            this.r.l = this.l;
            this.l.r = this.r;
        }
        
        public void insertToRight(Node node){
            this.r.l = node;
            node.r = this.r;
            node.l = this;
            this.r = node;
        }
        
        public void insertToLeft(Node node){
            this.l.r = node;
            node.l = this.l;
            node.r = this;
            this.l = node;
        }
        
    }
    
    Map<String,Node> keysMap = new HashMap<>();
    Node head;
    Node tail;
    public AllOne() {
        head = new Node("",-1);
        tail = new Node("",-1);
        head.r = tail;
        tail.l = head;
    }
    
    public void inc(String key) {
        Node node = head;
        if(keysMap.containsKey(key)){
            node = keysMap.get(key);
        }
        
        node.set.remove(key);
        
        int count = 0;
        if(node == head){
            count = 1;
        }else{
            count = node.count + 1;
        }
        
        if(node.r.count != count){
            node.insertToRight(new Node(key,count));
        }else{
           node.r.set.add(key); 
        }
            
        

        keysMap.put(key,node.r);
        if(node != head && node.set.isEmpty()){
            node.removeNode();
        }
    }
    
    public void dec(String key) {
        Node node = keysMap.get(key);
        node.set.remove(key);
        
        int newCount = node.count - 1;
        if(newCount >= 1){
            if(node.l.count != newCount){
                node.l.insertToRight(new Node(key,newCount));
            }
            
            //node.l.set.add(key); //this is the newly added node - now the new curr node's left
            keysMap.put(key,node.l);
        }else{
            keysMap.remove(key);
        }
        
        if(node.set.isEmpty()){
            node.removeNode();
        }
        
    }
    
    public String getMaxKey() {
        if(tail.l == head){
            return "";
        }
        return tail.l.set.iterator().next();
    }
    
    public String getMinKey() {
        if(head.r == tail){
            return "";
        }
        return head.r.set.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */