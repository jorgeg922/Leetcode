class MyHashMap {
    class Pair<U,V>{
        U key;
        V value;
        public Pair(U key,V value){
            this.key = key;
            this.value = value;
        }
    }
    
    class Bucket{
        List<Pair<Integer,Integer>> bucket;
        public Bucket(){
            bucket = new LinkedList<>();
        }
        
        public int get(int key){
            for(Pair<Integer,Integer> pair : bucket){
                if(pair.key == key){
                    return pair.value;
                }
            }
            return -1;
        }
        
        public void put(int key, int value){
            for(Pair<Integer,Integer> pair : bucket){
                if(pair.key == key){
                    pair.value = value;
                    return;
                }
            }
            
            bucket.add(new Pair<Integer,Integer>(key,value));
        }
        
        public void remove(int key){
            for(Pair<Integer,Integer> pair : bucket){
                if(pair.key == key){
                    bucket.remove(pair);
                    return;
                }
            }
        }
    }
    
    int buckets = 2333;
    List<Bucket> map;
    public MyHashMap() {
        map = new ArrayList<>();
        for(int i=0; i<buckets; i++){
            map.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        int location = key%buckets;
        map.get(location).put(key, value);
    }
    
    public int get(int key) {
        int location = key%buckets;
        return map.get(location).get(key);
    }
    
    public void remove(int key) {
        int location = key%buckets;
        map.get(location).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */