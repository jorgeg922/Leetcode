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
        
        if(timestamp < values.get(0).getKey()){
            return "";
        }
        
        int left=0;
        int right=values.size()-1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair<Integer, String> value = values.get(mid);

            if (value.getKey() == timestamp) {
                return value.getValue();
            } else if (value.getKey() < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right == -1 ? "" : values.get(right).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */