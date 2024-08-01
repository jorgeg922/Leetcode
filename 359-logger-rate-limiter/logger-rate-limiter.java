class Logger {
    HashMap<String, Integer> count;
    public Logger() {
        count = new HashMap<String,Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!count.containsKey(message)){
            count.put(message,timestamp);
            return true;
        }
        
        if(timestamp  >= count.get(message) + 10){
            count.put(message,timestamp);
            return true;
        }
        
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */