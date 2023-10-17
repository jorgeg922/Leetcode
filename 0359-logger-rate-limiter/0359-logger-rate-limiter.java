class Logger {
    HashMap<String,Integer> pastMessages;
    public Logger() {
        pastMessages = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!pastMessages.containsKey(message)){
            pastMessages.put(message, timestamp);
            return true;
        }
        
        if(timestamp - pastMessages.get(message) >= 10){
            pastMessages.put(message, timestamp);
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