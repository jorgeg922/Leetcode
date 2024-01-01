class TimeMap {
    HashMap<String, List<Pair<Integer,String>>> dataStore;
    public TimeMap() {
        dataStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!dataStore.containsKey(key)){
            dataStore.put(key, new ArrayList<>());
        }
        
        dataStore.get(key).add(new Pair<Integer,String>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!dataStore.containsKey(key) || dataStore.get(key).size() == 0){
            return "";
        }
        
        List<Pair<Integer, String>> values = dataStore.get(key);
        
        for(int i=values.size()-1; i >=0; i--){
            if(values.get(i).getKey() <= timestamp){
                return values.get(i).getValue();
            }
        }
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */