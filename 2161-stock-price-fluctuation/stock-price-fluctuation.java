class StockPrice {
    class Node{
        int timestamp;
        int price;
        boolean valid;

        public Node(int timestamp, int price, boolean valid){
            this.timestamp = timestamp;
            this.price = price;
            this.valid = valid;
        }
    }
    PriorityQueue<Node> max = new PriorityQueue<>((a,b) -> b.price - a.price);
    PriorityQueue<Node> min = new PriorityQueue<>((a,b) -> a.price - b.price);
    PriorityQueue<Node> time = new PriorityQueue<>((a,b) -> b.timestamp - a.timestamp);
    Map<Integer, Node> records = new HashMap<>();
    public StockPrice() {
        
    }
    
    public void update(int timestamp, int price) {
        if(records.containsKey(timestamp)){
            Node node = records.get(timestamp);
            node.valid = false;
            records.remove(timestamp);
        }

        Node newNode = new Node(timestamp, price, true);
        records.put(timestamp, newNode);
        max.add(newNode);
        min.add(newNode);
        time.add(newNode);
    }
    
    public int current() {
        while(!time.isEmpty()){
            if(!time.peek().valid){
                time.poll();
            }else{
                break;
            }
        }
        return time.peek().price;
    }
    
    public int maximum() {
        while(!max.isEmpty()){
            if(!max.peek().valid){
                max.poll();
            }else{
                break;
            }
        }
        return max.peek().price;
    }
    
    public int minimum() {
        while(!min.isEmpty()){
            if(!min.peek().valid){
                min.poll();
            }else{
                break;
            }
        }
        return min.peek().price;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */