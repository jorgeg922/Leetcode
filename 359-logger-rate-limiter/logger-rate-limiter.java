class Logger {
    Map<String, Integer> messages;
    public Logger() {
        messages = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!messages.containsKey(message)){
            messages.put(message, timestamp);
            return true;
        }
        if(messages.containsKey(message) && timestamp  >= messages.get(message) + 10){
            messages.put(message, timestamp);
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