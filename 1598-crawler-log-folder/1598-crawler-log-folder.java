class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        
        for(String log : logs){
            if(log.equals("./")){
                continue;
            }
            
            if(log.equals("../")){
                if(count > 0){
                    count--;
                }
                
            }else{
               count++; 
            }            
        }
        
        return count;
    }
}