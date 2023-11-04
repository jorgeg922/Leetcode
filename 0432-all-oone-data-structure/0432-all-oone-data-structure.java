class AllOne {
    class Node{
        Set<String> set = new HashSet<>();
        int count;        
        Node left;
        Node right;
        
        public Node(String s, int count){
            set.add(s);
            this.count = count;
            this.left = null;
            this.right = null;
        }
        
        public void remove(){
            this.left.right = this.right;
            this.right.left = this.left;
            this.right = null;
            this.left = null;
        }
        
        public void insertToRight(Node node){
            Node tmp = this.right;
            this.right = node;
            node.left = this;
            node.right = tmp;
            tmp.left = node;
        }
        
        public void insertToLeft(Node node){
            Node tmp = this.left;
            this.left = node;
            node.right = this;
            tmp.right = node;
            node.left = tmp;
        }
        
    }
    
    Map<String, Node> mapToKeys;
    Node head;
    Node tail;
    public AllOne() {
        mapToKeys = new HashMap<>();
        head = new Node("",-1);
        tail = new Node("", -1);
        head.right = tail;
        tail.left = head;
    }
    
    public void inc(String key) {
        Node node = head;
        if(mapToKeys.containsKey(key)){
            node = mapToKeys.get(key);          
        }
        node.set.remove(key);
        int newCount = node==head?1:node.count+1;
        
        if(node.right.count != newCount){
            node.insertToRight(new Node(key,newCount));
        }else{
            node.right.set.add(key);
        }
        
        mapToKeys.put(key, node.right);
        if(node != head && node.set.isEmpty()){
            node.remove();
        }
        
        
    }
    
    public void dec(String key) {
        System.out.println(key);
        Node node = mapToKeys.get(key);
        node.set.remove(key);
        int newCount = node.count-1;
        
        if(newCount >= 1){
            if(node.left.count != newCount){
                node.insertToLeft(new Node(key,newCount));                
            }else{
                node.left.set.add(key);
            }
            mapToKeys.put(key, node.left);
        }else{
            mapToKeys.remove(key);
        }
        
        if(node.set.isEmpty()){
            node.remove();
        }
    }
    
    public String getMaxKey() {
        if(head.right == tail){
            return "";
        }
        return tail.left.set.iterator().next();
    }
    
    public String getMinKey() {
        if(tail.left == head){
            return "";
        }
        return head.right.set.iterator().next();
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