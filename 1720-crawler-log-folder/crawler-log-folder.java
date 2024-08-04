class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        
        for(String operation : logs){
            switch(operation){
                case "../":
                    if(depth == 0){
                        break;
                    }
                    depth--;
                    break;
                case "./":
                    break;
                default:
                    depth++;
                    break;
            }
        }
        
        return depth;
    }
}