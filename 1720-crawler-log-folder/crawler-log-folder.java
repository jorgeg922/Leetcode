class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        
        for(String operation : logs){
            if(depth == 0 && operation.equals("../")){
                continue;
            }
            
            if(operation.equals("../")){
                depth--;
                continue;
            }
            
            if(!operation.equals("./")){
                depth++;
            }
        }
        
        return depth;
    }
}