class ExamRoom {
    class Node{
        Node prev;
        Node next;
        int val;
        public Node(int val){
            this.val = val;
        }
    }
    
    int n;
    Node head = new Node(-1);
    Node tail = new Node(-1);
    Map<Integer, Node> map = new HashMap<>();
    
    public ExamRoom(int n) {
        this.n = n;
        join(head, tail);
    }
    
    public int seat() {
        if(head.next == tail){
            Node node = new Node(0);
            join(head,node);
            join(node,tail);
            map.put(0,node);
            return 0;
        }
        
        int prevStudent = -1;
        int maxDistanceToClosest = 0;
        int val = 0;
        Node pos = null;
        
        Node curr = head;
        while(curr != tail){
            if(prevStudent == -1){
                maxDistanceToClosest = curr.val;
                pos = curr;
            }else if((curr.val - prevStudent)/2 > maxDistanceToClosest){
                maxDistanceToClosest = (curr.val - prevStudent)/2;
                val = (curr.val + prevStudent)/2;
                pos = curr;
            }
            
            prevStudent = curr.val;
            curr = curr.next;
        }
        
        if(n-1-tail.prev.val > maxDistanceToClosest){
            pos = tail;
            val = n-1;
        }
        
        Node insertedNode = new Node(val);
        join(pos.prev, insertedNode);
        join(insertedNode,pos);
        
        map.put(val, insertedNode);
        return val;
    }
    
    public void leave(int p) {
        Node removedNode = map.get(p);
        join(removedNode.prev, removedNode.next);
    }
    
    public void join(Node node1, Node node2){
        node1.next = node2;
        node2.prev = node1;
    }
    
    public void remove(Node node){
        join(node.prev, node.next);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */