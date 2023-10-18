class MyHashMap {
    class Pair<K,V> {
        K key;
        V value;
        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    
    class Bucket{
        List<Pair<Integer,Integer>> bucket;
        public Bucket(){
            bucket = new LinkedList<>();
        }
        
        public void put(Integer key, Integer value){    
            for(Pair<Integer,Integer> pair : bucket){
                if(pair.key.equals(key)){
                    pair.value = value;
                    return;
                }
            }
            Pair<Integer,Integer> newPair = new Pair<>(key,value);
            bucket.add(newPair);
        }
        
        public Integer get(Integer key){
            for(Pair pair : bucket){
                if(pair.key.equals(key)){
                    return (Integer) pair.value;
                }
            }
            return -1;
        }
        
        public void remove(Integer key){
            for(Pair pair : bucket){
                if(pair.key.equals(key)){
                    bucket.remove(pair);
                    return;
                }
            }
        }
    }
    
    List<Bucket> buckets;
    int size = 2069;
    public MyHashMap() {
        buckets = new ArrayList<>();
        for(int i=0; i<2069; i++){
            buckets.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        Bucket bucket = buckets.get(key%size);
        bucket.put(key, value);
    }
    
    public int get(int key) {
        Bucket bucket = buckets.get(key%size);
        return bucket.get(key);
    }
    
    public void remove(int key) {
        Bucket bucket =  buckets.get(key%size);
        bucket.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */